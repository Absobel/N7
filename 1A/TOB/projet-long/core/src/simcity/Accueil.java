package simcity;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Accueil extends ScreenAdapter {

    public static final int WIDTH = 320 * 4; // 16:9 aspect ratio
    public static final int HEIGHT = 180 * 4;
    public static final Musique MUSIQUE = new Musique();

    private SpriteBatch batch;
    private Texture menuTexture;
    private boolean touchejouer;
    private InputHandler inputHandler;
    private OrthographicCamera camera;
    private IsometricRenderer renderer;
    private Viewport viewport;
    private TextButton quitterButton;
    private TextButton jouerButton;
    private TextButton nouvelleButton;
    private TextButton musiqueButton;
    private Stage stageboutton;
    
    private Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

    public Accueil(SpriteBatch batch, Boolean dedans) {
        this.batch = batch;
        this.touchejouer = false; // permet de savoir si on appuie sur la touche joueur
        MUSIQUE.jouer();
    }

    @Override
    public void show() {
        camera = new OrthographicCamera(WIDTH, HEIGHT);

        camera.zoom = 1f;

        viewport = new FitViewport(WIDTH, HEIGHT, camera);

        renderer = new IsometricRenderer();
        menuTexture = new Texture(Gdx.files.internal("image-18-1024x585.png"));
        inputHandler = new InputHandler(camera, renderer.getGrid(), true);
        stageboutton = new Stage(viewport, batch);

        quitterButton = new TextButton("Quitter", skin);
        quitterButton.setPosition(700, 100);
        quitterButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
            }
        });

        stageboutton.addActor(quitterButton);

        jouerButton = new TextButton("Jouer", skin);
        jouerButton.setPosition(700, 300);
        jouerButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                touchejouer = true; // parvient pas a mettre this.touchejouer = false;
                Accueil.MUSIQUE.changerMusique();
            }
        });
        stageboutton.addActor(jouerButton);

        nouvelleButton = new TextButton("Nouvelle partie", skin);
        nouvelleButton.setPosition(700, 200);
        nouvelleButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                touchejouer = true;
                Accueil.MUSIQUE.changerMusique();
            }
        });

        stageboutton.addActor(nouvelleButton);

        musiqueButton = new TextButton(MUSIQUE.toString(), skin);
        musiqueButton.getLabel().setFontScale(0.5f);
        musiqueButton.setPosition(0, 0);
        musiqueButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                MUSIQUE.changerEtat();
                musiqueButton.setText(MUSIQUE.toString());
            }
        });
        musiqueButton.setSize(musiqueButton.getWidth() * 0.5f, musiqueButton.getHeight());
        stageboutton.addActor(musiqueButton);

        Gdx.input.setInputProcessor(stageboutton);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(viewport.getCamera().combined); // utiliser la deuxième caméra pour dessiner l'image

        batch.begin();

        batch.draw(menuTexture, 0, 0, WIDTH, HEIGHT);
        batch.end();

        inputHandler.handleInput(Gdx.graphics.getDeltaTime(), this.touchejouer, Textures.deco.get(0)); // bool rajouté pour écran d'accueil
        stageboutton.act();
        stageboutton.draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        menuTexture.dispose();
    }

    @Override
    public void resize(int width, int height) { // Called when the Application is resized.
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    public boolean getEtat() { // recuperer dans les autres classes la valeure
        return touchejouer;
    }

    public void setEtat(boolean etat) { // pouvoir mettre en vrai ou faux directmenet modifiabme par isomteric
        touchejouer = etat;

    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public void setBooldeInput(InputHandler inputHandler, boolean bool) {
        inputHandler.setBoolean(bool);
    }

    public TextButton getbutton(String nom) {
        if (nom == "quitter") {
            return quitterButton;
        } else if (nom == "jouer") {
            return jouerButton;
        } else {
            return null;
        }
    }

}
