import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextArea area;
    JMenuItem menuItemCut, menuItemCopy, menuItemPaste;

    public editMenu(JFrame f, JTextArea a) {
        this.setText("Edit");

        frame = f;
        area = a;
        menuItemCut = new JMenuItem("Cut");
        menuItemCopy = new JMenuItem("Copy");
        menuItemPaste = new JMenuItem("Paste");

        menuItemCut.addActionListener(this::actionPerformed);
        menuItemCopy.addActionListener(this::actionPerformed);
        menuItemPaste.addActionListener(this::actionPerformed);

        this.add(menuItemCut);
        this.add(menuItemCopy);
        this.add(menuItemPaste);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = e.getActionCommand();
        if (selected.equalsIgnoreCase("Cut"))
        {
            area.cut();
        } else if (selected.equalsIgnoreCase("Copy"))
        {
            area.copy();
        } else if (selected.equalsIgnoreCase("Paste"))
        {
            area.paste();
        }
    }
}
