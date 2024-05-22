package Controller;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import Controller.Factory.Factory;
import org.json.JSONException;

public class OsListener implements ActionListener {

    public OsListener(JComboBox<String> combo, JDialog dialog) {
        this.combo = combo;
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // close dialog
        dialog.dispose();
        Factory osfactory = new Factory();
        //
        try {
            (osfactory.getOs(combo.getSelectedItem().toString())).view();
        } catch (JSONException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

    JComboBox<String> combo;
    JDialog dialog;
}