package Model.Repository;

import Model.Dao.Cocktail;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CocktailRepo extends GenericRepo<Cocktail> implements ICocktail {

    private static List<Cocktail> cocktails = new ArrayList<Cocktail>();
    //cocktails url
    private String url = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?c=Cocktail";
    //specific cocktail url
    private String url1 = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=";

    public CocktailRepo() {
        super(cocktails);

    }

    @Override
    public List<Cocktail> getAll() {


        try {
            // Initiate client as HTTP Client
            HttpClient client = HttpClient.newHttpClient();

            // Initiate HTTP Request as GET Request for the given URL
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

            // Initiate HTTP response as String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Make a JSON Object out of response's body
            JSONObject object = new JSONObject(response.body());

            // Make a JSON Array and store response's body from JSON Array 'drinks'
            JSONArray cocktailArray = object.getJSONArray("drinks");

            // Set the elements in cocktails array
            for (int i = 0; i < cocktailArray.length(); i++) {
                cocktails.add(new Cocktail());
                cocktails.get(i).setId((cocktailArray.getJSONObject(i).getString("idDrink")));
                cocktails.get(i).setName((cocktailArray.getJSONObject(i).getString("strDrink")));
                cocktails.get(i).setImg((cocktailArray.getJSONObject(i).getString("strDrinkThumb")));
            }

        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cocktails;
    }

    @Override
    public JSONArray getCocktailDetails(String id) {

        JSONArray cocktailArray = null;

        try {
            // Initiate client as HTTP Client
            HttpClient client = HttpClient.newHttpClient();

            // Initiate HTTP Request as GET Request for the given URL
            HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url1 + id)).build();

            // Initiate HTTP response as String
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Make a JSON Object out of response's body
            JSONObject object = new JSONObject(response.body());

            // Make a JSON Array and store response's body from JSON Array 'drinks'
            cocktailArray = object.getJSONArray("drinks");


        } catch (IOException e) {

            e.printStackTrace();
        } catch (InterruptedException e) {

            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return cocktailArray;
    }
}

