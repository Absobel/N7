
/* ------------------------------------------------------- 
		Les packages Java qui doivent etre importes.
*/
import java.lang.*;
import java.net.InetAddress;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.rmi.*;
import javax.swing.*;

/* ------------------------------------------------------- 
		Implementation de l'application
*/

public class Saisie extends JApplet {
	private static final long serialVersionUID = 1;
	TextField nom, email;
	Choice carnets;
	Label message;

	public void init() {
		setSize(300, 200);
		setLayout(new GridLayout(6, 2));
		add(new Label("  Nom : "));
		nom = new TextField(30);
		add(nom);
		add(new Label("  Email : "));
		email = new TextField(30);
		add(email);
		add(new Label("  Carnet : "));
		carnets = new Choice();
		carnets.addItem("Carnet1");
		carnets.addItem("Carnet2");
		add(carnets);
		add(new Label(""));
		add(new Label(""));
		Button Abutton = new Button("Ajouter");
		Abutton.addActionListener(new AButtonAction());
		add(Abutton);
		Button Cbutton = new Button("Consulter");
		Cbutton.addActionListener(new CButtonAction());
		add(Cbutton);
		message = new Label();
		add(message);
	}

	// La reaction au bouton Consulter
	class CButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String n, c;
			n = nom.getText();
			c = carnets.getSelectedItem();
			message.setText("Consulter(" + n + "," + c + ")        ");
			// DO IT
			try {
				int port = 1099 + Integer.parseInt(c.substring(6));
				Carnet carnet = (Carnet) Naming
						.lookup("//" + InetAddress.getLocalHost().getHostName() + ":" + port + "/" + c);
				RFiche fiche = carnet.Consulter(n, true);
				message.setText("nom = " + fiche.getNom() + " email = " + fiche.getEmail());				
			} catch (RuntimeException e) {
				message.setText("Fiche non trouvee");	
			} catch (Exception e) {
				System.out.println("CarnetImpl err: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	// La reaction au bouton Ajouter
	class AButtonAction implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String n, e, c;
			n = nom.getText();
			e = email.getText();
			c = carnets.getSelectedItem();
			message.setText("Ajouter(" + n + "," + e + "," + c + ")        ");
			// DO IT
			try {
				int port = 1099 + Integer.parseInt(c.substring(6));
				Carnet carnet = (Carnet) Naming
						.lookup("//" + InetAddress.getLocalHost().getHostName() + ":" + port + "/" + c);
				carnet.Ajouter(new SFicheImpl(n, e));
			} catch (Exception ex) {
				System.out.println("CarnetImpl err: " + ex.getMessage());
				ex.printStackTrace();
			}

		}
	}

	public static void main(String args[]) {
		Saisie a = new Saisie();
		a.init();
		a.start();
		JFrame frame = new JFrame("Applet");
		frame.setSize(400, 200);
		frame.getContentPane().add(a);
		frame.setVisible(true);
	}

}
