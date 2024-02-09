package simcity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.Json;

public class menuHUD extends Stage {

    private Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
    private TextButton menu; // Bouton pour dérouler le menu

    // Boutons du sous-menu
    private TextButton batimentsButton;
    private TextButton decoraButton;
    private TextButton sauvegardeButton;
    private TextButton musiqueButton;
    private TextButton accueilButton;
    private TextButton backButton;

    // Boutons du sous-menu bat
    private TextButton servpubButton;
    private TextButton habitationsButton;
    private TextButton autresButton;
    private TextButton retourButton;

    // Boutons du sous-menu service
    private TextButton elecButton;
    private TextButton eauButton;
    private TextButton ecoleButton;
    private TextButton retour2Button;

    //private habitations
    private TextButton immeuble;
    private TextButton maison;
    private TextButton retour3Button;

    private Table table; // Table qui contient le bouton du menu
    private Table sousmenuTable;  // Nouvelle table pour les boutons du sous-menu
    private Table menubat; // Table pour les différents batiments
    private Table service; // Table pour les différents services
    private Table habitations; // Table pour les différents habitations
    
    private BatRessources batRessources;


    public menuHUD(final Viewport viewport, final SpriteBatch batch, final Gestion gestion, final Grid grid) {

        Gdx.input.setInputProcessor(this);  // Active la scène pour récupérer les événements d'entrée
    
        // Création de la table qui contiendra les boutons du menu principal
        this.table = creerTable(true,null);
        // Création de la table qui contiendra les boutons du sous-menu
        this.sousmenuTable = creerTable(false,null);
        // Création de la table qui contiendra les boutons du sous-menu batiments
        this.menubat = creerTable(false,"menubat");
        // Création de la table qui contiendra les boutons du sous-menu batiments
        this.service = creerTable(false,"service");
        // Création de la table qui contiendra les boutons du sous-menu habitations
        this.habitations = creerTable(false,"habitations");
        
        // Ajout du Bouton du menu
        this.menu = creerButon("Menu",0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showmenu();  // Afficher les boutons du sous-menu
            }
        });

        //////////////////////////////////////////////////////////
        // Ajout des boutons du sous-menu
        this.batimentsButton = creerButon("batiments", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showbat();  // Afficher les boutons du sous-menu bat;
            }
        });
        
        this.decoraButton = creerButon("decoration", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (gestion.getgest().dkoAchetable()){
                    setBatRessources( gestion.getgest().dko());
                }
                
            }
        });

        this.sauvegardeButton = creerButon("sauvegarde", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("Sauvegarde");

                /////////////// ça fait crash le jeu et ça bloat de fichiers, ne pas utilisr tel quel mais ne pas supprimer pour l'instant
                Json json = new Json();
                
                // Convert the Grid object into a JSON string
                String jsonString = json.toJson(grid);
                
                // Write the string to a file
                try (java.io.FileWriter file = new java.io.FileWriter("grid.json")) {
                    file.write(jsonString);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        });
        
        
        this.accueilButton = creerButon("accueil", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Isometric isometric = (Isometric) Gdx.app.getApplicationListener(); // ca marche j'ai peur que si on ajout un mute qu'on le perde a chaque retour
                isometric.retourAccueil(); 
            }
        });
        
        this.musiqueButton = creerButon(Accueil.MUSIQUE.toString(), 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Accueil.MUSIQUE.changerEtat();
                musiqueButton.setText(Accueil.MUSIQUE.toString());
            }
        });

        this.backButton = creerButon("Back", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hidemenu();  // Cacher les boutons du sous-menu
            }
        });

        // Ajout des boutons à la table du sous-menu
        TextButton[] buttons = { batimentsButton, decoraButton, sauvegardeButton, musiqueButton, accueilButton, backButton };
        for (TextButton button : buttons) {
            sousmenuTable.add(button).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        }
        
        //////////////////////////////////////////////////////////
        // Ajout des boutons du sous-menu bat
        this.servpubButton = creerButon("service pub", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showservice();  // Afficher les boutons du sous-menu serv;
            }
        });

        this.habitationsButton = creerButon("habitations", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                showhab();
            }
        });

        this.autresButton = creerButon("autres", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println("autres");
            }
        });

        this.retourButton = creerButon("retour", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hidebat();  // Cacher les boutons du sous-menubat
            }
        });

        // Ajout des boutons à la table du sous-menubat
        TextButton[] buttonsBat = { servpubButton, habitationsButton, autresButton, retourButton};
        for (TextButton button : buttonsBat) {
            menubat.add(button).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        }

        //////////////////////////////////////////////////////////
        // Ajout des boutons du sous-menu service

        this.elecButton = creerButon("elec", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if ( gestion.getgest().centraleAchetable()){
                    setBatRessources( gestion.getgest().centrale());

                }
            }
        });

        this.eauButton = creerButon("eau", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if ( gestion.getgest().pompeEauAchetable()){
                    setBatRessources( gestion.getgest().pompeEau());

                }
            }
        });

        this.ecoleButton = creerButon("ecole", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if ( gestion.getgest().ecoleAchetable()){
                    setBatRessources( gestion.getgest().ecole());

                }
            }
        });

        this.retour2Button = creerButon("retour", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hideserv();  // Cacher les boutons du sous-menu service
            }
        });

        // Ajout des boutons à la table du sous-menu service
        TextButton[] buttonsService = {elecButton,eauButton,ecoleButton,retour2Button};
        for (TextButton button : buttonsService) {
            service.add(button).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        }


        //////////////////////////////////////////////////////////
        // Ajout des boutons du sous-menu habitations
        this.immeuble = creerButon("immeuble", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if ( gestion.getgest().immeubleAchetable()){
                    setBatRessources( gestion.getgest().immeuble());

                }
            }
        });

        this.maison = creerButon("maison", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if ( gestion.getgest().maisonAchetable()){
                    setBatRessources( gestion.getgest().maison());

                }
            }
        });

        this.retour3Button = creerButon("retour", 0.5f, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hidehab();  // Cacher les boutons du sous-menu habitations
            }
        });

        TextButton[] buttonshab = {immeuble,maison,retour3Button};
        for (TextButton button : buttonshab) {
            habitations.add(button).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
        }

        // Ajout du bouton menu à la table du menu principal
        table.add(menu).width(batimentsButton.getWidth() * 0.5f).height(batimentsButton.getHeight()).padTop(20f).row();
    }

    private void showmenu() {
        sousmenuTable.setVisible(true);  // Rendre les boutons du sous-menu visibles
        table.setVisible(false);  // Cacher les boutons du menu principal

    }

    private void hidemenu() {
        sousmenuTable.setVisible(false);  // Cacher les boutons du sous-menu
        table.setVisible(true); 
    }

    private void showbat() {

        sousmenuTable.setVisible(false);
        table.setVisible(false);
        
        menubat.setVisible(true);
        
        Gdx.input.setInputProcessor(this);
    }

    public void hidebat() {
        sousmenuTable.setVisible(true);
        table.setVisible(false);
        menubat.setVisible(false);
    }

    public void showservice() {
        service.setVisible(true);  // Rendre les boutons du sous-menu visibles
        menubat.setVisible(false);  // Cacher les boutons du menu principal

    }

    public void hideserv() {
        service.setVisible(false);  // Cacher les boutons du sous-menu
        menubat.setVisible(true); 
    }

    public void dispose() {
        this.dispose();
    }

    public void showhab(){
        habitations.setVisible(true);
        menubat.setVisible(false);
    }

    public void hidehab(){
        habitations.setVisible(false);
        menubat.setVisible(true);
    }

    public BatRessources getBatRessources() {
        return batRessources;
    }

    public void setBatRessources(BatRessources batRessourcess) {
        batRessources = batRessourcess;
    }

    // Pour créer les différentes tables
    private Table creerTable(Boolean visible, String nom) {
        Table table = new Table();
        table.setFillParent(true);
        table.left();
        table.bottom();
        table.setVisible(visible);
        if (nom != null) {
            table.setName(nom);
        }
        this.addActor(table);
        return table;
    }

    // Pour créer les différents boutons
    private TextButton creerButon(String text, float fontScale, ClickListener clickListener) {
        TextButton button = new TextButton(text, skin);
        button.getLabel().setFontScale(fontScale);
        if (clickListener != null) {
            button.addListener(clickListener);
        }
        return button;
    }
}
