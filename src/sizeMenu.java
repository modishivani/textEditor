import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class sizeMenu extends JMenu{
    JFrame frame;
    JTextPane pane;
    JSpinner fontSizeSpinner;

    public sizeMenu(JFrame f, JTextPane p) {
        this.setText("Size");
        frame = f;
        pane = p;

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setValue(pane.getFont().getSize());

        this.add(fontSizeSpinner);
        fontSizeSpinner.addChangeListener(e -> {

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

            StyleConstants.setFontSize(style, (int)fontSizeSpinner.getValue());
            doc.setCharacterAttributes(start, end - start, style, false);
        });
    }
}


