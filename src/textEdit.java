import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class textEdit {
    private JTextArea area;
    private JFrame frame;
    JMenuBar menuBar;
    JMenu menuFile, menuEdit;
    JMenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemCut, menuItemCopy, menuItemPaste;

    public textEdit() {

        /*// set look and feel for the entire application
        try {
            UIManager.setLookAndFeel(new ());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }*/

        frame = new JFrame("Text Editor");
        JPanel panel = new JPanel();
        area = new JTextArea();
        area.setLineWrap(true);
        //panel.add(area);
        //panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.add(area);
        frame.getRootPane().setBorder(new EmptyBorder(5,5,5,5));
        frame.setBounds(15,15,15,15);
        frame.setSize(1000,800);
        frame.show();

        menuBar = new JMenuBar();

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuItemNew = new JMenuItem("New");
        menuFile.add(menuItemNew);

        menuItemOpen = new JMenuItem("Open");
        menuFile.add(menuItemOpen);

        menuItemSave = new JMenuItem("Save");
        menuFile.add(menuItemSave);

        menuItemCut = new JMenuItem("Cut");
        menuEdit.add(menuItemCut);

        menuItemCopy = new JMenuItem("Copy");
        menuEdit.add(menuItemCopy);

        menuItemPaste = new JMenuItem("Paste");
        menuEdit.add(menuItemPaste);

        frame.setVisible(true);
        frame.setSize(420,420);
        frame.setJMenuBar(menuBar);

    }

    public static void main(String[] args) {
        textEdit tE = new textEdit();
    }
}
