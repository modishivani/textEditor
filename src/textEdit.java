import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.*;

public class textEdit {
    private JTextPane pane;
    private JFrame frame;
    private menuBar menu;


    public textEdit() {

        //name
        frame = new JFrame("Text Editor");
        //when user clicks the X, stop the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //exit confirmation from the user
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to exit? Any unsaved progress will be lost.", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

        //create typing pane
        pane = new JTextPane();
        menu = new menuBar(frame, pane);

        //add the typing pane
        frame.add(pane);
        //set borders, size, and other elements
        frame.getRootPane().setBorder(new EmptyBorder(5,5,5,5));
        frame.setBounds(15,15,15,15);
        frame.setSize(1000,800);
        frame.setJMenuBar(menu);

        frame.show();
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        //set look and feel
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        //construct the text editor
        textEdit tE = new textEdit();
    }
}
