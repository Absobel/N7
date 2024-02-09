import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControleurChat extends JPanel {
    private JButton boutonEnvoyer;
    private JTextField champTexte;

    public ControleurChat(Chat chat, String pseudo) {
        super(new BorderLayout());

        this.boutonEnvoyer = new JButton("Envoyer");
        this.boutonEnvoyer.addActionListener(e -> this.envoyerMessage(chat, pseudo));
        this.add(this.boutonEnvoyer, BorderLayout.EAST);

        this.champTexte = new JTextField();
        this.add(this.champTexte, BorderLayout.CENTER);

        JLabel pseudoGras = new JLabel();
        pseudoGras.setText(pseudo);
        Font font = pseudoGras.getFont();
        pseudoGras.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        this.add(pseudoGras, BorderLayout.WEST);
    }

    public void envoyerMessage(Chat chat, String pseudo) {
        chat.ajouter(new MessageTexte(pseudo, this.champTexte.getText()));
        this.champTexte.setText("");
    }
}
