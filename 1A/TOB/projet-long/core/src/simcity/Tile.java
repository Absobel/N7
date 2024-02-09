package simcity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Json.Serializable;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.PixmapIO;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.files.FileHandle;
import java.util.HashMap;
import java.util.Map;

/**
 * Définition et methodes d'une tuile
 */
public class Tile implements Serializable {
    private transient TextureRegion texture;
    private String textureFilePath;
    private static Map<TextureRegion, String> textureFilePaths = new HashMap<>();

    public Tile(TextureRegion texture) {
        this.texture = texture;
    }

    public Tile(Textures texture2, int col, int row, int i) {
    }

    public void draw(SpriteBatch batch, int col, int row, int height) {
        float x = (col - row) * (Textures.TILE_SIZE_CUBE/2);  // Isometric projection
        float y = (col + row) * (Textures.TILE_SIZE_CUBE/4) + height*Textures.TILE_SIZE_CUBE/2;
        batch.draw(texture, x, y);
    }

    @Override
    public void write(Json json) {
        // Check if the texture is already in the map
        if (textureFilePaths.containsKey(this.texture)) {
            // If it is, use the existing file path
            this.textureFilePath = textureFilePaths.get(this.texture);
        } else {
            // If it's not, save the texture to a new file
            Texture texture = this.texture.getTexture();
            TextureData textureData = texture.getTextureData();
            if (!textureData.isPrepared()) {
                textureData.prepare();
            }
            Pixmap pixmap = textureData.consumePixmap();

            // Generate a unique file path for the texture
            this.textureFilePath = "texture" + this.hashCode() + ".png";

            // Save the pixmap to a file
            try {
                PixmapIO.writePNG(new FileHandle(this.textureFilePath), pixmap);
            } catch (Exception e) {
                // Handle exception
            }

            // Add the texture and file path to the map
            textureFilePaths.put(this.texture, this.textureFilePath);
        }

        // Write the texture file path to the JSON
        json.writeValue("textureFilePath", this.textureFilePath);
    }

    @Override
    public void read(Json json, JsonValue jsonData) {
        // Read the texture file path from the JSON
        this.textureFilePath = jsonData.getString("textureFilePath");

        // Load the texture from the file
        this.texture = new TextureRegion(new Texture(Gdx.files.internal(this.textureFilePath)));
    }
}
