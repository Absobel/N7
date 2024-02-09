package simcity.like;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import simcity.GameScreen;
import simcity.Isometric;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();

		config.setTitle("SimCity Like");
		config.setWindowedMode(GameScreen.WIDTH, GameScreen.HEIGHT);

		new Lwjgl3Application(new Isometric(), config);
	}
}