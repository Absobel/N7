package simcity;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.assets.AssetManager;

public class Musique {
    private Music musique;
    private AssetManager assetManager; 
    private String pathAcceil = "Joueur du Grenier - Recette pour jeu pourri.mp3";
    private String pathJeu = "musique_chill.mp3";
    private Boolean musiqueAcceuil; //Donne l'information de si c'est la musique d'acceuil ou non

    public Musique() {
        this.assetManager = new AssetManager();
        assetManager.load(this.pathAcceil,Music.class);
        assetManager.load(this.pathJeu,Music.class);
        assetManager.finishLoading();
        this.musique = assetManager.get(this.pathAcceil,Music.class);
        this.musiqueAcceuil = true;
    }

    public void jouer() {
        // Lancer la lecture de la musique
        this.musique.setLooping(true);
        this.musique.play();
    }

    public void pause() {
        // Mettre la musique en pause
        this.musique.pause();
    }

    public void stop() {
        // Arrêter la lecture de la musique
        this.musique.pause();
    }

    public void dispose() {
        // Libérer les ressources de la musique
        this.musique.dispose();
    }

    public void changerEtat() {
        // Changer l'état de la musique
        if (this.musique.isPlaying()) {
            this.musique.stop();
        } else {
            this.musique.play();
        }
    }

    public Boolean getEtat() {
        // Renvoie true si la musique est en train d'être jouée
        return this.musique.isPlaying();
    }

    public void changerMusique() {
        // Changer de musique
        Boolean isPlaying = false; //Pour conserver l'état de la musique quand on change de musique
        if (this.musique.isPlaying()) {
            isPlaying = true;
            this.musique.stop();
        }
        if (this.musiqueAcceuil) {
            this.musique = assetManager.get(this.pathJeu,Music.class);
        } else {
            this.musique = assetManager.get(this.pathAcceil,Music.class);
        }
        this.musiqueAcceuil = !this.musiqueAcceuil;
        if (isPlaying) {
            this.musique.setLooping(true);
            this.musique.play();
        }
    }

    public String toString() {
        String etat = this.musique.isPlaying() ? "ON":"OFF";
        return "Musique : " + etat;
    }
}
