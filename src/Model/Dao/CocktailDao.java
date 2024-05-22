package Model.Dao;

import java.io.IOException;

public interface CocktailDao {

    String addCategory(Cocktail Favorite, String category) throws IOException;

    public String deleteFavorite(Cocktail cocktail) throws IOException;

    public String addFavorite(Cocktail Favourite) throws IOException;
}
