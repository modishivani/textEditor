import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class fileMenu extends JMenu implements ActionListener {
    JFrame frame;
    JTextPane pane;
    JMenuItem menuItemNew, menuItemOpen, menuItemSave;

    public fileMenu(JFrame f, JTextPane p) {
        this.setText("File");

        frame = f;
        pane = p;

        //label the menu items
        menuItemNew = new JMenuItem("New");
        menuItemOpen = new JMenuItem("Open");
        menuItemSave = new JMenuItem("Save");

        //actionlisteners for each menu item
        menuItemNew.addActionListener(this::actionPerformed);
        menuItemOpen.addActionListener(this::actionPerformed);
        menuItemSave.addActionListener(this::actionPerformed);

        //add the menu items to the drop down list
        this.add(menuItemNew);
        this.add(menuItemOpen);
        this.add(menuItemSave);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //determine which command was selected
        String selected = e.getActionCommand();

        if (selected.equalsIgnoreCase("New")) {
            //confirm new file with user
            int input = JOptionPane.showConfirmDialog(frame,
                    "Are you sure you would like to open a new file? Any unsaved progress will be lost.",
                    "New File Confirmation",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (input == 0) {
                pane.setText("");
            }
        } else if (selected.equalsIgnoreCase("Save")) {
            //open file chooser for user
            JFileChooser fileChooser = new JFileChooser();
            int choice = fileChooser.showSaveDialog(null);
            if (choice == fileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    //write and save the contents of the text editor
                    FileWriter fileWriter = new FileWriter(file, false);
                    BufferedWriter writer = new BufferedWriter(fileWriter);
                    writer.write(pane.getText());
                    writer.flush();
                    writer.close();
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(frame, ioException.getMessage());
                }

            }
        } else if (selected.equalsIgnoreCase("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            int choice = fileChooser.showOpenDialog(null);
            if (choice == fileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    //write the contents of the chosen file onto the text editor
                    String readLines = "";
                    String fileText = "";
                    FileReader fileReader = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fileReader);
                    readLines = reader.readLine();
                    while (readLines != null) {
                        fileText += readLines + "\n";
                        readLines = reader.readLine();
                    }
                    pane.setText(fileText);

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(frame, e1.getMessage());
                }

            }
        }

    }
}
