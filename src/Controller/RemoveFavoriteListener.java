package Controller;

import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.*;

import Model.Dao.CocktailDaoImplementation;
import Model.Singleton.Singleton;
import Model.Dao.Cocktail;
import Model.Dao.CocktailDao;

public class RemoveFavoriteListener implements ActionListener {
    Singleton instance = Singleton.getInstance();
    private Cocktail cocktail;
    private List<Cocktail> favorites = instance.getFavoriteRepo().getAll();
    private JPanel panel;

    public RemoveFavoriteListener(Cocktail cocktail, JPanel panel) {
        this.cocktail = cocktail;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        // create dao object
        CocktailDao cocktailDao = new CocktailDaoImplementation(favorites);
        // delete given cocktail from favourite list
        if (favorites.contains(cocktail)) {
            try {
                cocktailDao.deleteFavorite(cocktail);
                panel.setVisible(false);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else {
            // if the cocktail is already deleted, then display message.
            // Show Warning Dialog
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Item Already Deleted", "Notification",
                    JOptionPane.WARNING_MESSAGE);

        }
    }
}
