package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ImageMenu extends Stage {
    private Table imageTable;
    private Skin skin;

    public ImageMenu(Viewport viewport, SpriteBatch batch) {
        super(viewport, batch);
        Gdx.input.setInputProcessor(this);

        // Chargez le skin contenant les images prédéfinies
        skin = new Skin(Gdx.files.internal("assets/skin/glassy-ui.json"));

        // Créez une table pour afficher les images
        imageTable = new Table();
        imageTable.setFillParent(true);
        imageTable.center();
        this.addActor(imageTable);
    }

    public void showImageMenu() {
        // Effacez les images précédentes de la table
        imageTable.clear();

        // Ajoutez les images prédéfinies à la table
        Image image1 = new Image(skin.getDrawable("imagesecoles"));
        // Ajoutez autant d'images que vous le souhaitez

        // Ajoutez les images à la table
        imageTable.add(image1).pad(20f);
        // Ajoutez les autres images à la table

        // Affichez la table avec les images
        imageTable.setVisible(true);
    }

    public void hideImageMenu() {
        // Masquez la table avec les images
        imageTable.setVisible(false);
    }

    @Override
    public void dispose() {
        skin.dispose();
        super.dispose();
    }
}
