import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sizeMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextPane pane;
    JSpinner fontSizeSpinner;

    public sizeMenu(JFrame f, JTextPane p) {
        this.setText("Size");
        frame = f;
        pane = p;

        fontSizeSpinner = new JSpinner();
        fontSizeSpinner.setValue(20);
        this.add(fontSizeSpinner);
        fontSizeSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                pane.setFont(new Font(pane.getFont().getFamily(), Font.PLAIN, (int) fontSizeSpinner.getValue()));
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}