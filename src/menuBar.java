import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menuBar extends JMenuBar implements ActionListener {

    JFrame frame;
    JTextArea area;
    JMenu menuFile, menuEdit;
    JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemCut, menuItemCopy, menuItemPaste;

    public menuBar(JFrame f, JTextArea a) {
        frame = f;
        area = a;
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");

        this.add(menuFile);
        this.add(menuEdit);

        menuItemNew = new JMenuItem("New");
        menuItemOpen = new JMenuItem("Open");
        menuItemSave = new JMenuItem("Save");
        menuItemCut = new JMenuItem("Cut");
        menuItemCopy = new JMenuItem("Copy");
        menuItemPaste = new JMenuItem("Paste");

        menuItemCut.addActionListener(this::actionPerformed);
        menuItemCopy.addActionListener(this::actionPerformed);
        menuItemPaste.addActionListener(this::actionPerformed);

        menuFile.add(menuItemNew);
        menuFile.add(menuItemOpen);
        menuFile.add(menuItemSave);
        menuEdit.add(menuItemCut);
        menuEdit.add(menuItemCopy);
        menuEdit.add(menuItemPaste);

        this.setVisible(true);
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
