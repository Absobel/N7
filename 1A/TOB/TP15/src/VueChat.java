import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextArea;

@SuppressWarnings("deprecation")
public class VueChat extends JTextArea implements Observer {

    public VueChat(Chat chat) {
        super();
        this.setEditable(false);
        this.setLineWrap(true);
        chat.addObserver(this);
    }

    @Override
    public void update(Observable chat, Object message) {
        this.append(message.toString() + "\n");
    }
}
