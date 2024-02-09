import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

public class VueChatFenetre {
    private VueChat fenetre;
    private ControleurChat controleur;

    private JFrame frame;
    private JPanel framePlusPadding;
    private JButton boutonFermer;

    public VueChatFenetre(Chat chat, String pseudo) {
        this.fenetre = new VueChat(chat);

        this.frame = new JFrame("Chat de " + pseudo);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(400, 400);
        this.frame.setVisible(true);

        this.framePlusPadding = new JPanel();
        this.framePlusPadding.setBorder(new EmptyBorder(0, 5, 5, 0));
        this.framePlusPadding.setLayout(new BorderLayout());

        this.boutonFermer = new JButton("Fermer");
        this.boutonFermer.addActionListener(e -> this.frame.dispose());
        this.framePlusPadding.add(this.boutonFermer, BorderLayout.NORTH);

        this.framePlusPadding.add(this.fenetre, BorderLayout.CENTER);

        this.controleur = new ControleurChat(chat, pseudo);
        this.controleur.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.framePlusPadding.add(this.controleur, BorderLayout.SOUTH);

        this.frame.add(this.framePlusPadding);
    }
}
