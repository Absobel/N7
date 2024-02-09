package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Time {

    // On prend 1 min = 1h
    private float debut; // temps en seconde de début du jeu
    public int secondes_init = 8 * 60; // Minutes de début de jeu en seconde, équivalent à 8h00

    private float elapsed_time; // Temps passé depuis le lancement du programme

    private BitmapFont font;
    private Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

    private int nb_jour = (int) (secondes_init + (this.elapsed_time - this.debut) / 60) / 24;

    public Time(float delta) {
        this.debut = delta;
        nb_jour = 0;
    }

    /* Mise à jour du temps */
    public void updateTime(float delta) {
        this.elapsed_time += delta;
        nb_jour = (int) (secondes_init + (this.elapsed_time - this.debut) / 60) / 24;
    }

    /* Avoir le temps en heures */
    public float getTime() {
        float time_sec = secondes_init + (this.elapsed_time - this.debut);
        float total = (time_sec / 60) % 24;
        return total;
    }

    public String toString() {
        int heure = (int) Math.floor(getTime());
        int minutes = (int) (getTime() % heure);

        String text = heure + ":" + minutes;
        return text;
    }

    // public void afficheTime(SpriteBatch batch) { // en cours

    // this.font = new BitmapFont();

    // CharSequence text = "Mon texte";
    // font.draw(batch, text, 0, 0);

    // }

    public int getJour() {
        return nb_jour;
    }
}
