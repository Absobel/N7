package simcity;

import java.util.List;
import com.badlogic.gdx.graphics.Texture;

public class CycleJN {

    public List<Texture> updateSky(float minutes) {

        List<Texture> currentSky;

        float secondes = minutes * 60;

        if ((secondes > 5 * 60) && (secondes < 6 * 60)) {
            currentSky = Textures.sky.get(5);
        } else if ((secondes > 6 * 60) && (secondes < 7 * 60)) {
            currentSky = Textures.sky.get(3);
        } else if ((secondes > 7 * 60) && (secondes < 8 * 60 + 30)) {
            currentSky = Textures.sky.get(1);
        } else if ((secondes > 8 * 60 + 30) && (secondes < 12 * 60)) {
            currentSky = Textures.sky.get(4);
        } else if ((secondes > 12 * 60) && (secondes < 18 * 60)) {
            currentSky = Textures.sky.get(0);
        } else if ((secondes > 18 * 60) && (secondes < 19 * 60)) {
            currentSky = Textures.sky.get(1);
        } else if ((secondes > 19 * 60) && (secondes < 20 * 60)) {
            currentSky = Textures.sky.get(6);
        } else if ((secondes > 20 * 60) && (secondes < 21 * 60)) {
            currentSky = Textures.sky.get(7);
        } else { // night
            currentSky = Textures.sky.get(2);
        }

        return currentSky;
    }

}