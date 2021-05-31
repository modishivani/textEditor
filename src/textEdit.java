import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class textEdit {
    private JTextArea area;
    private JFrame frame;
    private menuBar menu;


    public textEdit() {

        frame = new JFrame("Text Editor");
        area = new JTextArea();
        menu = new menuBar(frame, area);
        area.setLineWrap(true);
        frame.add(area);
        frame.getRootPane().setBorder(new EmptyBorder(5,5,5,5));
        frame.setBounds(15,15,15,15);
        frame.setSize(1000,800);
        frame.setJMenuBar(menu);
        frame.show();
        frame.setVisible(true);
        frame.setSize(420,420);


    }

    public static void main(String[] args) {
        textEdit tE = new textEdit();
    }
}
