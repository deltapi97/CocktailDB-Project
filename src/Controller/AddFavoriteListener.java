package Controller;

import java.awt.event.*;
import java.io.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Dao.CocktailDaoImplementation;
import Model.Singleton.Singleton;
import Model.Dao.Cocktail;
import Model.Dao.CocktailDao;

public class AddFavoriteListener implements ActionListener {

    Singleton instance = Singleton.getInstance();
    private Cocktail cocktail;
    private List<Cocktail> favorites = instance.getFavoriteRepo().getAll();

    public AddFavoriteListener(Cocktail cocktail) {
        this.cocktail = cocktail;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // create dao object
        CocktailDao cocktailDao = new CocktailDaoImplementation(favorites);

        // if the cocktail exists in favourite list, then display message.
        if (favorites.contains(cocktail)) {
            // Show Warning Dialog
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Item Already Exists in Favourites", "Notification",
                    JOptionPane.WARNING_MESSAGE);

        } else {
            try {
                // add given cocktail to favourite list
                cocktailDao.addFavorite(cocktail);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
