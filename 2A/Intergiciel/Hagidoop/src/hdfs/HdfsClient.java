package hdfs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import config.Config;
import config.Project;
import java.util.List;
import java.util.ArrayList;

public class HdfsClient {
	public static final int FMT_TXT = 0;
	public static final int FMT_KV = 1;

	private static final String HOST_FILEPATH = "target/hostnames.txt";

	private static void usage() {
		System.out.println("Usage: java HdfsClient read <file>");
		System.out.println("Usage: java HdfsClient write <txt|kv> <file>");
		System.out.println("Usage: java HdfsClient delete <file>");
		System.out.println("Usage: java HdfsClient exit");
	}

	private static boolean areArgsValid(String[] args) {
		if (args.length < 2 || args.length > 3) {
			return false;
		}

		String command = args[0];
		boolean isCommand1Args = command.equals("read") || command.equals("delete");
		boolean isCommand2Args = command.equals("write");

		return (isCommand1Args && args.length == 2)
				|| (isCommand2Args && args.length == 3);
	}

	private static Socket[] connectToServers() {
		List<String> hosts = new ArrayList<String>();
		try {
			hosts = Files.readAllLines(Paths.get(HOST_FILEPATH));
		} catch (IOException e) {
			System.out.println("Couldn't read hostnames file");
			e.printStackTrace();
		}

		Config config = new Project().getConfig();
		int nb_of_servers = config.getNbOfServers();

		Socket[] sockets = new Socket[nb_of_servers];

		for (int i = 0; i < nb_of_servers; i++) {
			String hostname = hosts.get(i).split(":")[0];
			int port = Integer.parseInt(hosts.get(i).split(":")[1]);
			try {
				sockets[i] = new Socket(hostname, port);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return sockets;
	}

	private static void closeSockets(Socket[] sockets) {
		for (Socket socket : sockets) {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("Couldn't close socket");
				e.printStackTrace();
			}
		}
	}

	private static List<String> getHosts() {
		List<String> hosts = new ArrayList<String>();
		try {
			hosts = Files.readAllLines(Paths.get(HOST_FILEPATH));
		} catch (IOException e) {
			System.out.println("Couldn't read hostnames file");
			e.printStackTrace();
		}
		return hosts;
	}

	public static void HdfsWrite(Socket[] sockets, int fmt, String fname) throws IOException {
		Config config = new Project().getConfig();
		int nb_of_servers = config.getNbOfServers();
		BufferedWriter[] writers = new BufferedWriter[sockets.length];
		for (int i = 0; i < sockets.length; i++) {
			writers[i] = new BufferedWriter(new OutputStreamWriter(sockets[i].getOutputStream()));
		}
		long totalLines = Files.lines(Paths.get(fname)).count();
		long baseFragmentSize = totalLines / nb_of_servers;
		long remainder = totalLines % nb_of_servers;

		Thread[] threads = new Thread[nb_of_servers];
		for (int i = 0; i < nb_of_servers; i++) {
			long fragmentSize = baseFragmentSize + (i < remainder ? 1 : 0);
			long startLine = i * baseFragmentSize + Math.min(i, remainder);
			threads[i] = new Thread(new WriteTask(sockets[i], fname, startLine, fragmentSize));
			threads[i].start();
		}
		for (int i = 0; i < nb_of_servers; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		if (!areArgsValid(args)) {
			usage();
			return;
		}

		Config config = new Project().getConfig();
		int nb_of_servers = config.getNbOfServers();
		int registry_base_port = config.getRegistryBasePort();
		List<String> hosts = getHosts();

		Registry[] registries = new Registry[nb_of_servers];
		ServerCommands[] commands = new ServerCommands[nb_of_servers];
		for (int i = 0; i < nb_of_servers; i++) {
			String hostname = hosts.get(i).split(":")[0];
			int registry_port = registry_base_port + i;
			registries[i] = LocateRegistry.getRegistry(hostname, registry_port);
			try {
				commands[i] = (ServerCommands) registries[i].lookup("ServerCommands");
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
		}

		Socket[] sockets = new Socket[nb_of_servers];

		if (args[0].equals("read")) {
			File file = new File(args[1]);
			if (!file.exists()) {
				file.createNewFile();
			}
			try (FileWriter writer = new FileWriter(file)) {
				for (int i = 0; i < nb_of_servers; i++) {
					String fragment = commands[i].read(args[1]);
					writer.write(fragment);
				}
			}
		} else if (args[0].equals("write")) {
			int fmt = args[1].equals("txt") ? FMT_TXT : FMT_KV;
			for (int i = 0; i < nb_of_servers; i++) {
				commands[i].write(args[2], fmt);
			}
			sockets = connectToServers();
			HdfsWrite(sockets, fmt, args[2]);
			closeSockets(sockets);
		} else if (args[0].equals("delete")) {
			for (int i = 0; i < nb_of_servers; i++) {
				commands[i].delete(args[1]);
			}
		}
	}
}
