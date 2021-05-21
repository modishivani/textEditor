import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class textEdit {
    private JTextArea area;
    private JFrame frame;

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

    }

    public static void main(String[] args) {
        textEdit tE = new textEdit();
    }
}
