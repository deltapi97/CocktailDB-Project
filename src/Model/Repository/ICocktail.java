package Model.Repository;

import Model.Dao.Cocktail;
import org.json.JSONArray;


import java.util.List;

public interface ICocktail {

    List<Cocktail> getAll();

    JSONArray getCocktailDetails(String id);
}
