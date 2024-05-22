package Controller;

import Model.Dao.Cocktail;
import Model.Dao.CocktailDao;
import Model.Dao.CocktailDaoImplementation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import Model.Singleton.Singleton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class SetEnumListener implements ActionListener {
    JComboBox<String> comboBox;
    Cocktail favorite;
    Singleton instance = Singleton.getInstance();
    private List<Cocktail> favorites = instance.getFavoriteRepo().getAll();

    public SetEnumListener(Cocktail favorite, JComboBox<String> comboBox) {
        this.favorite=favorite;
        this.comboBox=comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CocktailDao cocktailDao = new CocktailDaoImplementation(favorites);
        try {
            cocktailDao.addCategory(favorite,comboBox.getSelectedItem().toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
