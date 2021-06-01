import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sizeMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextPane pane;

    public sizeMenu(JFrame f, JTextPane p) {
        this.setText("Size");

        frame = f;
        pane = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

