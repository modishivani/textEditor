import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JMenuBar {

    JFrame frame;
    JTextPane pane;

    public menuBar(JFrame f, JTextPane p) {
        frame = f;
        pane = p;

        //construct each menu item for the menu bar
        fileMenu fileM = new fileMenu(f, p);
        editMenu editM = new editMenu(f, p);
        fontMenu fontM = new fontMenu(f,p);
        sizeMenu sizeM = new sizeMenu(f, p);
        styleMenu styleM = new styleMenu(f, p);
        colorMenu colorM = new colorMenu (f, p);

        //add each type of menu to the bar
        this.add(fileM);
        this.add(editM);
        this.add(fontM);
        this.add(sizeM);
        this.add(styleM);
        this.add(colorM);

        this.setVisible(true);
    }

}
