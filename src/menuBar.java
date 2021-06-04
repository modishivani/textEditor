import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JMenuBar {

    JFrame frame;
    JTextPane pane;

    public menuBar(JFrame f, JTextPane p) {
        frame = f;
        pane = p;
        fileMenu fileM = new fileMenu(f, p);
        editMenu editM = new editMenu(f, p);
        sizeMenu sizeM = new sizeMenu(f, p);
        styleMenu styleM = new styleMenu(f, p);
        colorMenu colorM = new colorMenu (f, p);
        this.add(fileM);
        this.add(editM);
        this.add(sizeM);
        this.add(styleM);
        this.add(colorM);

        this.setVisible(true);
    }

}
