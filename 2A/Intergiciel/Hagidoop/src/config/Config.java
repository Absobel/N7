package config;

import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Config {
    private int nb_of_servers;
    private int base_port;
    private int registry_base_port;
    private String server_dest_path;
    private int hagidoop_base_port;

    public Config(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject json = new JSONObject(content);

            this.nb_of_servers = json.getInt("nb_of_servers");
            this.base_port = json.getInt("base_port");
            this.registry_base_port = json.getInt("registry_base_port");
            this.server_dest_path = json.getString("server_dest_path");
            this.hagidoop_base_port = json.getInt("hagidoop_base_port");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions appropriately
        }
    }

    // Getters
    public int getNbOfServers() {
        return nb_of_servers;
    }

    public int getBasePort() {
        return base_port;
    }

    public int getRegistryBasePort() {
        return registry_base_port;
    }

    public String getServerDestPath() {
        return server_dest_path;
    }

    public int getHagidoopBasePort() {
        return hagidoop_base_port;
    }
}
