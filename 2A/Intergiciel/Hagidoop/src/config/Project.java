package config;

public class Project {
    public static String PATH = "config/config.json"; // Ensure this is the path to your YAML file

    Config config;

    public Project() {
        this.config = new Config(PATH);
    }

	public Config getConfig() {
		return config;
	}
}
