package simcity;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Classe qui contient toutes les textures du jeu, à améliorer pour la
 * performance même si pour l'instant osef un peu
 */
public class Textures {
    public static final int TILE_SIZE_CUBE = 256;
    public static final int TILE_SIZE_FLOOR_X = 256;
    public static final int TILE_SIZE_FLOOR_Y = 152;

    public static final int SKY_WIDTH = 576;
    public static final int SKY_HEIGHT = 324;

    public static List<TextureRegion> grasses = new ArrayList<TextureRegion>();
    public static List<TextureRegion> waters = new ArrayList<TextureRegion>();
    public static TextureRegion chemin_bois_1;
    public static List<TextureRegion> tonneaux = new ArrayList<TextureRegion>();
    public static List<TextureRegion> a_suppr = new ArrayList<TextureRegion>();
    public static List<List<Texture>> sky = new ArrayList<List<Texture>>();
    public static TextureRegion road;

    public static List<TextureRegion> deco = new ArrayList<TextureRegion>();
    public static List<TextureRegion> habitats = new ArrayList<TextureRegion>();
    public static List<TextureRegion> publics = new ArrayList<TextureRegion>();
    public static void load() {
        // Textures
        // Liste de toutes les combinaisons de ciels dans l'ordre d'apparition
        Integer[] nbe_image = { 0, 4, 4, 4, 4, 5, 6, 4, 6 };

        for (int j = 1; j <= 8; j++) {
            List<Texture> oneSky = new ArrayList<Texture>();
            for (int i = 1; i <= nbe_image[j]; i++) {
                oneSky.add(new Texture(Gdx.files.internal(String.format("Sky/Clouds %d/%d.png", j, i))));
            }
            sky.add(oneSky);
        }

        for (int i = 0; i < 10; i++) {
            grasses.add(texture256x256("IsometricTilesEtAutre/256x256 Cubes.png", i, 0));
        }
        for (int i = 0; i < 10; i++) { // à changer, toutes les couleurs ne fonctionnent pas m'enfin bon
            waters.add(texture256x256("IsometricTilesEtAutre/256x256 Cubes.png", i, 2));
        }

        for (int i = 4; i < 9; i++) {
            deco.add(texture256x256("IsometricTilesEtAutre/256x256 Cubes.png", i, 3));
        }
        for (int i = 0; i < 4; i++) { // à changer, toutes les couleurs ne fonctionnent pas m'enfin bon
            habitats.add(texture256x256("IsometricTilesEtAutre/256x256 Cubes.png", i, 3));
        }
        habitats.add(texture256x256("IsometricTilesEtAutre/256x256 Cubes.png", 8, 3));
        habitats.add(texture256x256("IsometricTilesEtAutre/256x256 Cubes.png", 9, 3));

        for (int i = 0; i < 10; i++) { // à changer, toutes les couleurs ne fonctionnent pas m'enfin bon
            publics.add(texture256x256("IsometricTilesEtAutre/256x256 Cubes.png", i, 5));
        }

        Texture spriteShTextureFloor = new Texture(Gdx.files.internal("IsometricTilesEtAutre/256x152 Floorings.png"));
        chemin_bois_1 = new TextureRegion(spriteShTextureFloor, 0 * TILE_SIZE_FLOOR_X, 0 * TILE_SIZE_FLOOR_Y,
                TILE_SIZE_FLOOR_X, TILE_SIZE_FLOOR_Y);

        for (int i = 0; i < 2; i++) {
            tonneaux.add(texture256x256("IsometricTilesEtAutre/256x256 Objects.png", i + 6, 0));
        }

        Texture spriteShTextureASuppr = new Texture(Gdx.files.internal("IsometricTilesEtAutre/256x512 Trees.png"));
        for (int i = 0; i < 24; i++) {
            a_suppr.add(new TextureRegion(spriteShTextureASuppr, i % 6 * TILE_SIZE_CUBE, ((int) i / 6) * TILE_SIZE_CUBE,
                    TILE_SIZE_CUBE, TILE_SIZE_CUBE));
        }

        Texture spriteRoad = new Texture(Gdx.files.internal("IsometricTilesEtAutre/256x256 route.png"));
        road = new TextureRegion(spriteRoad);
    }

    public static void dispose() {
        for (List<Texture> skyPart : sky) {
            for (Texture oneSky : skyPart) {
                oneSky.dispose();
            }
        }
        for (TextureRegion grass : grasses) {
            grass.getTexture().dispose();
        }
        for (TextureRegion water : waters) {
            water.getTexture().dispose();
        }
        for (TextureRegion publics : publics) {
            publics.getTexture().dispose();
        }
        for (TextureRegion habitats : habitats) {
            habitats.getTexture().dispose();
        }
        road.getTexture().dispose();
    }

    public static TextureRegion texture256x256(String path, int x, int y) {
        return new TextureRegion(new Texture(Gdx.files.internal(path)), x * TILE_SIZE_CUBE, y * TILE_SIZE_CUBE,
                TILE_SIZE_CUBE, TILE_SIZE_CUBE);
    }
}
