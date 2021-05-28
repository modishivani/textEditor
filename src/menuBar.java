import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JMenuBar {

    JFrame frame;
    JTextArea area;

    public menuBar(JFrame f, JTextArea a) {
        frame = f;
        area = a;
        fileMenu fileM = new fileMenu(f, a);
        editMenu fileE = new editMenu(f, a);

        this.add(fileM);
        this.add(fileE);

        this.setVisible(true);
    }

}
