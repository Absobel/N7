package simcity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;

import simcity.Ressource.RessourceType;

public class Afficher extends Stage{
    private Gestion gestion;
    private BitmapFont font;
    private Table donnee;
    private Array<Label> ressour = new Array<>(7);

    public Afficher(Gestion gestion) {
        this.gestion = gestion;
        this.font = new BitmapFont();
        this.donnee = new Table();
        donnee.setFillParent(true);
        donnee.top();
        donnee.right();
        this.addActor(donnee);
        font.setColor(Color.RED);
        font.getData().setScale(1);
        ressour.add( new Label("Monnaie : " + gestion.getMonnaie(), new Label.LabelStyle(font, font.getColor())));
        ressour.get(0).setAlignment(Align.right);
        ressour.add( new Label("    électricité : " + gestion.getRessourceValue(RessourceType.ELECTRICITE), new Label.LabelStyle(font, font.getColor())));
        ressour.get(1).setAlignment(Align.right);
        ressour.add( new Label("    eau : " + gestion.getRessourceValue(RessourceType.EAU), new Label.LabelStyle(font, font.getColor())));
        ressour.get(2).setAlignment(Align.right);
        ressour.add( new Label("    bonheur : " + gestion.getRessourceValue(RessourceType.BONHEUR), new Label.LabelStyle(font, font.getColor())));
        ressour.get(3).setAlignment(Align.right);
        ressour.add( new Label("    habitants : " + gestion.getRessourceValue(RessourceType.HABITANTS), new Label.LabelStyle(font, font.getColor())));
        ressour.get(4).setAlignment(Align.right);
        font.setColor(Color.BLACK);
        ressour.add( new Label("    Score : " + gestion.citymanager.score, new Label.LabelStyle(font, font.getColor())));
        ressour.get(5).setAlignment(Align.left);
        
        ressour.add( new Label("    Level : " + gestion.citymanager.level, new Label.LabelStyle(font, font.getColor())));
        ressour.get(6).setAlignment(Align.left);

        for (Label ress : ressour) {
            donnee.add(ress).pad(1);
        }
    }

    public void maj() {
        
        ressour.get(0).setText("Monnaie : " + gestion.getMonnaie());
        ressour.get(1).setText("    électricité : " + gestion.getRessourceValue(RessourceType.ELECTRICITE));
        ressour.get(2).setText("    eau : " + gestion.getRessourceValue(RessourceType.EAU));
        ressour.get(3).setText("    bonheur : " + gestion.getRessourceValue(RessourceType.BONHEUR));
        ressour.get(4).setText("    habitants : " + gestion.getRessourceValue(RessourceType.HABITANTS));
        ressour.get(5).setText("   Score : " + gestion.citymanager.score);
        ressour.get(6).setText("   Level : " + gestion.citymanager.level);
        
    }


}