import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fontMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextPane pane;
    JMenuItem serif, sansSerif, monospaced;

    public fontMenu(JFrame f, JTextPane p) {
        //label for the menu bar
        this.setText("Font");

        frame = f;
        pane = p;

        serif = new JMenuItem("Serif");
        sansSerif = new JMenuItem("SansSerif");
        monospaced = new JMenuItem("Monospaced");

        //action listeners for when the user clicks them
        serif.addActionListener(this::actionPerformed);
        sansSerif.addActionListener(this::actionPerformed);
        monospaced.addActionListener(this::actionPerformed);

        //add the different font options to the drop down
        this.add(serif);
        this.add(sansSerif);
        this.add(monospaced);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //determine which font the user selected
        String selected = e.getActionCommand();

        StyledDocument doc = pane.getStyledDocument();
        Style style = pane.addStyle("", null);

        //access the selected text, so that the entire pane's font does not change
        int start = pane.getSelectionStart();
        int end = pane.getSelectionEnd();
        //no selection
        if (start == end) {
            return;
        }
        //backwards selection (select starting from back end)
        if (start > end) { // Backwards selection?
            int temp = start;
            start = end;
            end = temp;
        }

        //change the font of the selected text
        if (selected.equalsIgnoreCase("Serif")) {
            StyleConstants.setFontFamily(style, "Serif");

        } else if (selected.equalsIgnoreCase("SansSerif")) {
            StyleConstants.setFontFamily(style, "SansSerif");

        } else if (selected.equalsIgnoreCase("Monospaced")) {
            StyleConstants.setFontFamily(style, "Monospaced");
        }
        doc.setCharacterAttributes(start, end - start, style, false);
    }
}
