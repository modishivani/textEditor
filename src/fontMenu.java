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
        this.setText("Font");

        serif = new JMenuItem("Serif");
        sansSerif = new JMenuItem("SansSerif");
        monospaced = new JMenuItem("Monospaced");

        serif.addActionListener(this::actionPerformed);
        sansSerif.addActionListener(this::actionPerformed);
        monospaced.addActionListener(this::actionPerformed);

        this.add(serif);
        this.add(sansSerif);
        this.add(monospaced);

        frame = f;
        pane = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selected = e.getActionCommand();
        StyledDocument doc = pane.getStyledDocument();
        Style style = pane.addStyle("", null);

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
