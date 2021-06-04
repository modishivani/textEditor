import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class styleMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextPane pane;
    JMenuItem bold, italics, underL, unbold, unItalics, noUnderL;

    public styleMenu(JFrame f, JTextPane p) {
        this.setText("Style");

        frame = f;
        pane = p;

        //label each menu item
        bold = new JMenuItem("Bold");
        italics = new JMenuItem("Italicize");
        underL = new JMenuItem("Underline");
        unbold = new JMenuItem("Un-bold");
        unItalics = new JMenuItem("Un-italicize");
        noUnderL = new JMenuItem("Remove Underline");

        //when the menu items are clicked, perform the appropriate actions
        bold.addActionListener(this::actionPerformed);
        italics.addActionListener(this::actionPerformed);
        underL.addActionListener(this::actionPerformed);
        unbold.addActionListener(this::actionPerformed);
        unItalics.addActionListener(this::actionPerformed);
        noUnderL.addActionListener(this::actionPerformed);

        //add items to the drop down listr
        this.add(bold);
        this.add(italics);
        this.add(underL);
        this.add(unbold);
        this.add(unItalics);
        this.add(noUnderL);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //determine which item was selected
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

        //change the style of the highlighted text as specified by the selection
        if (selected.equalsIgnoreCase("Bold")) {
            StyleConstants.setBold(style, true);
        } else if (selected.equalsIgnoreCase("Un-bold")) {
            StyleConstants.setBold(style, false);
        } else if (selected.equalsIgnoreCase("Italicize")) {
            StyleConstants.setItalic(style, true);
        } else if (selected.equalsIgnoreCase("Un-italicize")) {
            StyleConstants.setItalic(style, false);
        } else if (selected.equalsIgnoreCase("Underline")) {
            StyleConstants.setUnderline(style, true);
        } else if (selected.equalsIgnoreCase("Remove Underline")) {
            StyleConstants.setUnderline(style, false);
        }
            doc.setCharacterAttributes(start, end - start, style, false);

    }
}