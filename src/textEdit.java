import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.*;

public class textEdit {
    private JTextPane pane;
    private JFrame frame;
    private menuBar menu;


    public textEdit() {

        frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        pane = new JTextPane();
        menu = new menuBar(frame, pane);

        frame.add(pane);
        frame.getRootPane().setBorder(new EmptyBorder(5,5,5,5));
        frame.setBounds(15,15,15,15);
        frame.setSize(1000,800);
        frame.setJMenuBar(menu);
        frame.show();
        frame.setVisible(true);
        frame.setSize(800,800);


    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        textEdit tE = new textEdit();
    }
}
