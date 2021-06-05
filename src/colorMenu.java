import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class colorMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextPane pane;
    JButton fontcolorButton;

    public colorMenu(JFrame f, JTextPane p) {
        // set label for color selector
        this.setText("Color");
        frame = f;
        pane = p;

        fontcolorButton = new JButton();

        fontcolorButton.setText("Choose Color");
        this.add(fontcolorButton);
        // action listener for when user selects
        fontcolorButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

        if (e.getSource() == fontcolorButton) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "Choose a Color", Color.black);
            StyleConstants.setForeground(style, color);
            doc.setCharacterAttributes(start, end - start, style, false);
        }
    }
}
