import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

import java.awt.event.*;
import java.util.*;

/** Programmation d'un jeu de Morpion avec une interface graphique Swing.
  *
  * REMARQUE : Dans cette solution, le patron MVC n'a pas été appliqué !
  * On a un modèle (?), une vue et un contrôleur qui sont fortement liés.
  *
  * @author	Xavier Crégut
  * @version	$Revision: 1.4 $
  */

public class MorpionSwing {

	// les images à utiliser en fonction de l'état du jeu.
	private static final Map<ModeleMorpion.Etat, ImageIcon> images
		= new HashMap<ModeleMorpion.Etat, ImageIcon>();
	static {
		images.put(ModeleMorpion.Etat.VIDE, new ImageIcon("blanc.jpg"));
		images.put(ModeleMorpion.Etat.CROIX, new ImageIcon("croix.jpg"));
		images.put(ModeleMorpion.Etat.ROND, new ImageIcon("rond.jpg"));
	}

// Choix de réalisation :
// ----------------------
//
//  Les attributs correspondant à la structure fixe de l'IHM sont définis
//	« final static » pour montrer que leur valeur ne pourra pas changer au
//	cours de l'exécution.  Ils sont donc initialisés sans attendre
//  l'exécution du constructeur !

	private ModeleMorpion modele;	// le modèle du jeu de Morpion

//  Les éléments de la vue (IHM)
//  ----------------------------

	/** Fenêtre principale */
	private JFrame fenetre;

	/** Bouton pour quitter */
	private final JButton boutonQuitter = new JButton("Q");

	/** Bouton pour commencer une nouvelle partie */
	private final JButton boutonNouvellePartie = new JButton("N");

	/** Cases du jeu */
	private final JLabel[][] cases = new JLabel[3][3];

	/** Zone qui indique le joueur qui doit jouer */
	private final JLabel joueur = new JLabel();

	/** Attribut pour freeze la partie terminée */
	private boolean partieTerminee = false;

// Le constructeur
// ---------------

	/** Construire le jeu de morpion */
	public MorpionSwing() {
		this(new ModeleMorpionSimple());
	}

	/** Construire le jeu de morpion */
	public MorpionSwing(ModeleMorpion modele) {
		// Initialiser le modèle
		this.modele = modele;

		// Créer les cases du Morpion
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				this.cases[i][j] = new JLabel();
			}
		}

		// Initialiser le jeu
		this.recommencer();

		// Construire la vue (présentation)
		//	Définir la fenêtre principale
		this.fenetre = new JFrame("Morpion");
		this.fenetre.setLocation(100, 200);

		// Construire le contrôleur (gestion des événements)
		this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Définir le layout de la fenêtre
		this.fenetre.setLayout(new BorderLayout());


		// Ajout du menu
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Jeu");
		menuBar.add(menu);

		JMenuItem nouvellePartie = new JMenuItem("Nouvelle partie");
		nouvellePartie.addActionListener(new EcouteurBouton(this));
		nouvellePartie.setActionCommand("RECOMMENCER");

		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new EcouteurBouton(this));
		quitter.setActionCommand("QUITTER");

		menu.add(nouvellePartie);
		menu.add(quitter);

		this.fenetre.setJMenuBar(menuBar);


		// Ajout du jeu
		JPanel jeu = new JPanel();
		jeu.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				jeu.add(this.cases[i][j]);
				cases[i][j].addMouseListener(new EcouteurMouseCase(this, i, j));
			}
		}
		this.fenetre.add(jeu, BorderLayout.CENTER);


		// Ajout du joueur et des boutons
		JPanel joueurEtBoutons = new JPanel();

		boutonNouvellePartie.addActionListener(new EcouteurBouton(this));
		boutonNouvellePartie.setActionCommand("RECOMMENCER");
		joueurEtBoutons.add(boutonNouvellePartie, BorderLayout.CENTER);

		joueurEtBoutons.setLayout(new GridLayout(1, 3));
		joueurEtBoutons.add(this.joueur, BorderLayout.CENTER);

		boutonQuitter.addActionListener(new EcouteurBouton(this));
		boutonQuitter.setActionCommand("QUITTER");
		joueurEtBoutons.add(boutonQuitter, BorderLayout.CENTER);

		this.fenetre.add(joueurEtBoutons, BorderLayout.SOUTH);

		// afficher la fenêtre
		this.fenetre.pack();			// redimmensionner la fenêtre
		this.fenetre.setVisible(true);	// l'afficher
	}

// Quelques réactions aux interactions de l'utilisateur
// ----------------------------------------------------

	/** Recommencer une nouvelle partie. */
	public void recommencer() {
		this.modele.recommencer();
		this.partieTerminee = false;

		// Vider les cases
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[i].length; j++) {
				this.cases[i][j].setIcon(images.get(this.modele.getValeur(i, j)));
			}
		}

		// Mettre à jour le joueur
		joueur.setIcon(images.get(modele.getJoueur()));
	}

	/** Quitter le jeu. */
	public void quitter() {
		System.exit(0);
	}

	static class EcouteurBouton implements ActionListener {
		private MorpionSwing jeu;
		public EcouteurBouton(MorpionSwing jeu) {
			this.jeu = jeu;
		}
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("RECOMMENCER")) {
				this.jeu.recommencer();
			} else if (e.getActionCommand().equals("QUITTER")) {
				this.jeu.quitter();
			}
		}
	}

	// Un MouseAdapter par case
	static class EcouteurMouseCase extends MouseAdapter {
		private MorpionSwing jeu;
		private int i;
		private int j;

		public EcouteurMouseCase(MorpionSwing jeu, int i, int j) {
			this.jeu = jeu;
			this.i = i;
			this.j = j;
		}

		public void mouseClicked(MouseEvent e) {
			if (!jeu.partieTerminee) {
				try {
					jeu.modele.cocher(i, j);
					jeu.cases[i][j].setIcon(images.get(jeu.modele.getValeur(i, j)));
					jeu.joueur.setIcon(images.get(jeu.modele.getJoueur()));
					checkerFinPartie();
				} catch (CaseOccupeeException e2) {
					// Ne rien faire
				}
			}
		}

			// Gerer la fin de partie
		private void checkerFinPartie() {
			if (jeu.modele.estTerminee()) {
				jeu.joueur.setIcon(images.get(ModeleMorpion.Etat.VIDE));
				if (jeu.modele.estGagnee()) {
					JOptionPane.showMessageDialog(jeu.fenetre, "Le joueur " + jeu.modele.getJoueur() + " a gagné !");
				} else {
					JOptionPane.showMessageDialog(jeu.fenetre, "La partie est nulle !");
				}
				jeu.partieTerminee = true;
			}
		}
	}


// La méthode principale
// ---------------------

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MorpionSwing();
			}
		});
	}

}
