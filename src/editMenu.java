import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextPane pane;
    JMenuItem menuItemCut, menuItemCopy, menuItemPaste;

    public editMenu(JFrame f, JTextPane p) {
        this.setText("Edit");

        frame = f;
        pane = p;

        //label the menu items
        menuItemCut = new JMenuItem("Cut");
        menuItemCopy = new JMenuItem("Copy");
        menuItemPaste = new JMenuItem("Paste");

        //when they are selected, perform the appropriate action
        menuItemCut.addActionListener(this::actionPerformed);
        menuItemCopy.addActionListener(this::actionPerformed);
        menuItemPaste.addActionListener(this::actionPerformed);

        //add items to the drop down list
        this.add(menuItemCut);
        this.add(menuItemCopy);
        this.add(menuItemPaste);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //determine which item was selected, and perform the appropriate action for each one
        String selected = e.getActionCommand();
        if (selected.equalsIgnoreCase("Cut"))
        {
            pane.cut();
        } else if (selected.equalsIgnoreCase("Copy"))
        {
            pane.copy();
        } else if (selected.equalsIgnoreCase("Paste"))
        {
            pane.paste();
        }
    }
}
