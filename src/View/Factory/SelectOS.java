package View.Factory;

import Controller.OsListener;

import javax.swing.*;
import java.awt.*;

public class SelectOS extends JDialog {

    public SelectOS() {
        setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(500, 200));
        this.setTitle("OS Panel");

        // initialize components
        JComboBox<String> combobox = new JComboBox<>();
        JButton button = new JButton("Apply");
        JLabel label = new JLabel("Select your OS :");

        // add items to the combobox
        combobox.addItem("Windows");
        combobox.addItem("MacOS");
        combobox.addItem("Linux");
        combobox.setPreferredSize(new Dimension(150, 30));  // Make the combo box bigger

        // set up the panel with GridBagLayout
        JPanel ospanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        // add the label to the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        ospanel.add(label, gbc);

        // add the combobox to the panel
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        ospanel.add(combobox, gbc);

        // add the button to the panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER;
        ospanel.add(button, gbc);

        // add panel to the dialog
        add(ospanel);

        // add action listener to the button
        button.addActionListener(new OsListener(combobox, this));

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SelectOS dialog = new SelectOS();
            dialog.setVisible(true);
        });
    }
}
