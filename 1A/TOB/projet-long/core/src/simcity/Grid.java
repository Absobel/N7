package simcity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.Json.Serializable;

/**
 * Grille isométrique, là où sont stockés les tuiles (batiments, terrain, etc)
 */
public class Grid implements Serializable {
    private Tile[][][] tiles;
    private int nbCols;
    private int nbRows;
    private int nbLayers;

    public Grid(int nbCols, int nbRows, int nbLayers) {
        this.nbCols = nbCols;
        this.nbRows = nbRows;
        this.nbLayers = nbLayers;
        tiles = new Tile[nbCols][nbRows][nbLayers];
    }


    public void setTile(Tile tile, int col, int row, int height) {
        if (col >= 0 && col < nbCols && 
            row >= 0 && row < nbRows && 
            height >= 0 && height < nbLayers &&
            (tile != null && tiles[col][row][height] == null || tile == null))
        {
            tiles[col][row][height] = tile;
        } else {
            //Gdx.app.error("Grid", "Invalid tile position");   // à remettre quand le placement de tuile se fera une par une
        }
    }

    public void translateTile(int col, int row, int height, int colOffset, int rowOffset, int heightOffset) {
        Tile tile = tiles[col][row][height];
        int newCol = col+colOffset;
        int newRow = row+rowOffset;
        int newHeight = height+heightOffset;
        if (
            tile != null &&

            newCol >= 0 && newCol < nbCols &&
            newRow >= 0 && newRow < nbRows &&
            newHeight >= 0 && newHeight < nbLayers &&

            tiles[newCol][newRow][newHeight] == null)
        {
            tiles[newCol][newRow][newHeight] = tile;
            tiles[col][row][height] = null;
        }
    }

    public void draw(SpriteBatch batch) {
        for (int row = nbRows-1; row >= 0; row--) {
            for (int col = nbCols-1; col >= 0; col--) {
                for (int height = 0; height < nbLayers; height++) {
                    Tile tile = tiles[col][row][height];
                    if (tile != null) {
                        tile.draw(batch, col, row, height);
                    }
                }
            }
        }
    }


    /** 
     * Convertit des coordonnées absolues de l'écran en coordonnées isométriques sur la grille
     * Utilise une matrice de changement de base tout ce qu'il y a de plus classique
     * puis cast en int pour avoir des coordonnées de tuiles au lieu de coordonnées de pixels
     * @param coordIso Coordonnées isométriques
     * @return Coordonnées absolues
     */
    public static Vector2 coordAbsToIso(Vector2 coordAbs) {
        int col = (int) ((coordAbs.x+2*coordAbs.y)/Textures.TILE_SIZE_CUBE - 1.5f);   // 1.5f et 0.5f valeurs empiriques d'un offset qui vient de je ne sais où
        int row = (int) ((2*coordAbs.y-coordAbs.x)/Textures.TILE_SIZE_CUBE - 0.5f);
        return new Vector2(col, row);
    }


    @Override
    public void write(Json json) {
        json.writeValue("nbCols", nbCols);
        json.writeValue("nbRows", nbRows);
        json.writeValue("nbLayers", nbLayers);
        json.writeValue("tiles", tiles);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        nbCols = jsonData.getInt("nbCols");
        nbRows = jsonData.getInt("nbRows");
        nbLayers = jsonData.getInt("nbLayers");
        tiles = json.readValue(Tile[][][].class, jsonData.get("tiles"));
    }
}
