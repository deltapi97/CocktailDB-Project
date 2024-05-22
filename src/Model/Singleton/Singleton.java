package Model.Singleton;

import Model.Repository.*;

public class Singleton {
    private static Singleton instance = new Singleton();

    private IGeneric favoritesRepo;
    private IGeneric cocktailRepo;

    private Singleton() {
        favoritesRepo = new FavoriteRepo();
        cocktailRepo = new CocktailRepo();
        cocktailRepo.getAll();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public CocktailRepo getCocktailRepo() {

        return (CocktailRepo) cocktailRepo;
    }

    public FavoriteRepo getFavoriteRepo() {

        return (FavoriteRepo) favoritesRepo;
    }
}
