import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fileMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextArea area;
    JMenuItem menuItemNew, menuItemOpen, menuItemSave;

    public fileMenu(JFrame f, JTextArea a) {
        this.setText("File");

        frame = f;
        area = a;
        menuItemNew = new JMenuItem("New");
        menuItemOpen = new JMenuItem("Open");
        menuItemSave = new JMenuItem("Save");

        menuItemNew.addActionListener(this::actionPerformed);
        menuItemOpen.addActionListener(this::actionPerformed);
        menuItemSave.addActionListener(this::actionPerformed);

        this.add(menuItemNew);
        this.add(menuItemOpen);
        this.add(menuItemSave);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
