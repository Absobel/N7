package daemon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import application.MyReduce;
import config.Config;
import config.Project;
import interfaces.KV;

public class HagidoopClient {
	private static final String HOST_FILEPATH = "target/hostnames.txt";

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

    public static void main (String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java HagidoopClient <file_name>");
            System.exit(1);
        }

        String fname = args[0];

        Config config = new Project().getConfig();
        int registry_base_port = config.getHagidoopBasePort();
        int nb_of_servers = config.getNbOfServers();
        List<String> hosts = getHosts();

        Registry[] registries = new Registry[nb_of_servers];
        RunMap[] runmaps = new RunMap[nb_of_servers];
		for (int i = 0; i < nb_of_servers; i++) {
			String hostname = hosts.get(i).split(":")[0];
			int registry_port = registry_base_port + i;
			try {
                registries[i] = LocateRegistry.getRegistry(hostname, registry_port);
				runmaps[i] = (RunMap) registries[i].lookup("RunMap");
			} catch (RemoteException | NotBoundException e) {
				e.printStackTrace();
			}
		}

        // TODO : make that asynchronous
        KV[][] kv_list_list = new KV[nb_of_servers][];
        for (int i = 0; i < nb_of_servers; i++) {
            try {
                kv_list_list[i] = runmaps[i].runMap(fname);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        MyReduce reduce = new MyReduce(kv_list_list);
        KV[] kv_list = reduce.reduce();

        for (KV kv : kv_list) {
            System.out.println(kv.k + " : " + kv.v);
        }
    }
}
