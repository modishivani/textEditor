import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class colorMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextPane pane;
    JButton fontcolorButton;

    public colorMenu(JFrame f, JTextPane p) {
        this.setText("Color");
        frame = f;
        pane = p;

        fontcolorButton = new JButton();
        this.add(fontcolorButton);
        fontcolorButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fontcolorButton) {
            JColorChooser colorChooser = new JColorChooser();
            Color color = colorChooser.showDialog(null, "Choose a Color", Color.black);
            pane.setForeground(color);
        }
    }
}
