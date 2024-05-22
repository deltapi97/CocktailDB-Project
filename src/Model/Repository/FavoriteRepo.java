package Model.Repository;

import Model.Dao.Cocktail;
import Model.Dao.CocktailDaoImplementation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteRepo extends GenericRepo<Cocktail> implements IFavorite {

    //initiate favorites list
    public static List<Cocktail> favorites = new ArrayList<Cocktail>();

    public List<Cocktail> readJson() throws JSONException, FileNotFoundException {

        JSONArray favoritesArray = new JSONArray(new JSONTokener(new FileReader("src\\favorite.json")));
        for (int i = 0; i < favoritesArray.length(); i++) {
            favorites.add(new Cocktail());
            favorites.get(i).setId((favoritesArray.getJSONObject(i).getString("id")));
            favorites.get(i).setName((favoritesArray.getJSONObject(i).getString("name")));
            favorites.get(i).setImg((favoritesArray.getJSONObject(i).getString("img")));
            if(favoritesArray.getJSONObject(i)!=null)
             favorites.get(i).setCategory((favoritesArray.getJSONObject(i).getString("category")));

        }
        return favorites;
    }

    private CocktailDaoImplementation dao;

    public FavoriteRepo() {
        super(favorites);
        dao = new CocktailDaoImplementation(favorites);
    }

    @Override
    public void add(Cocktail cocktail) throws IOException {

        dao.addFavorite(cocktail);
    }
}
