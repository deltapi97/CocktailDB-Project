package View;

import javax.swing.*;
import java.awt.*;

public class DetailsDialog extends JDialog {

    public DetailsDialog(String list){
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setModal(true);
        JPanel jPan = new JPanel();
        JLabel label = new JLabel(list);
        jPan.add(label);
        add(jPan);
        pack();
    }
}
