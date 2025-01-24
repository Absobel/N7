package daemon;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import config.Config;
import config.Project;

public class HagidoopServer {
        public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java HagidoopServer <port>");
            System.exit(1);
        }

        Config config = new Project().getConfig();
        int base_registry_port = config.getHagidoopBasePort();
        int port = Integer.parseInt(args[0]);
        int this_id = port - base_registry_port;
        System.out.println("HagidoopServer " + this_id + " started"); // TODO: remove

        RunMap runmap = new RunMapImpl(this_id);
        Registry registry = LocateRegistry.createRegistry(port);
        registry.rebind("RunMap", runmap);

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }   
        }
    }
}
