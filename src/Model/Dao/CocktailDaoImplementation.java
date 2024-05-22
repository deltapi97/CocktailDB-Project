package Model.Dao;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class CocktailDaoImplementation implements CocktailDao {
    List<Cocktail> favorites;

    public CocktailDaoImplementation(List<Cocktail> favorites) {

        this.favorites = favorites;

    }

    @Override
    public String addFavorite(Cocktail Favorite) throws IOException {

        this.favorites.add(Favorite);

        save();

        return "Added";
    }

    @Override
    public String addCategory(Cocktail Favorite,String category) throws IOException {

        Favorite.setCategory(category);

        save();

        return "Added Category";
    }

    @Override
    public String deleteFavorite(Cocktail Favorite) throws IOException {

        favorites.remove(Favorite);

        save();

        return "Deleted";

    }

    private void save() throws IOException {
        // Initiate as pretty JSON printing
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Initiate new file into given directory
        FileWriter file = new FileWriter("src\\favorite.json");

        // Write the given ArrayList favourites to JSON file
        gson.toJson(favorites, file);

        // flush data to file and close
        file.flush();
        file.close();
    }
}
