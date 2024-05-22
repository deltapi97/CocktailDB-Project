package Model.Repository;

import Model.Dao.Cocktail;

import java.io.IOException;

public interface IFavorite {

    void add(Cocktail cocktail) throws IOException;
}
