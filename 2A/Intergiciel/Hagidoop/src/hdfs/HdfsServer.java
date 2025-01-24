package hdfs;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import config.Config;
import config.Project;

public class HdfsServer {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java HdfsServer <port>");
            System.exit(1);
        }

        int socket_port = Integer.parseInt(args[0]);

        Config config = new Project().getConfig();
        int base_port = config.getBasePort();
        int registry_base_port = config.getRegistryBasePort();
        int registry_port = registry_base_port + socket_port - base_port;

        ServerCommands commands = new ServerCommandsImpl(socket_port);
        Registry registry = LocateRegistry.createRegistry(registry_port);
        registry.rebind("ServerCommands", commands);

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }
    }
}
