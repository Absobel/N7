package hdfs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;

import config.Config;
import config.Project;

public class ServerCommandsImpl implements ServerCommands {
	public static final int FMT_TXT = 0;
	public static final int FMT_KV = 1;

    private int port;

    public ServerCommandsImpl(int port) {
        this.port = port;
    }

    private Socket connectToClient() {
        Socket client_socket = null;
        try (ServerSocket server_socket = new ServerSocket(port)) {
            client_socket = server_socket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client_socket;
    }

    private void closeSocket(Socket client_socket) {
        try {
            client_socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFilePath(String filename, Config config) {
        int this_id = port - config.getBasePort();
        String[] desconstructed_file_path = filename.split("/");
        String file_name = desconstructed_file_path[desconstructed_file_path.length - 1];
        String file_path = config.getServerDestPath() + file_name + ".part." + this_id;
        return file_path;
    }

    @Override
    public String read(String filename) throws RemoteException {
        Config config = new Project().getConfig();
        String file_path = getFilePath(filename, config);
        
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(file_path)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

    @Override
    public void write(String filename, int fmt) throws RemoteException {
        new Thread(() -> {
            Socket client_socket = connectToClient();

            Config config = new Project().getConfig();
            String file_path = getFilePath(filename, config);

            File file = new File(file_path);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
                FileWriter filewriter = new FileWriter(file_path)
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    filewriter.write(line);
                    filewriter.write("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeSocket(client_socket);
            }
        }).start();
    }
    
    @Override
    public void delete(String filename) throws RemoteException {
        Config config = new Project().getConfig();
        String file_path = getFilePath(filename, config);
        
        File file = new File(file_path);
        file.delete();
    }
}
