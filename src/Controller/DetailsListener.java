package Controller;

import Model.Singleton.Singleton;
import View.DetailsDialog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DetailsListener implements ActionListener {
    String id;

    public DetailsListener(String id) {
        this.id = id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Singleton instance = Singleton.getInstance();
        JSONArray jsonArray = instance.getCocktailRepo().getCocktailDetails(id);
        JSONObject details = null;
        try {
            details = (JSONObject) jsonArray.get(0);

            //String that shows
            String detailsString = "<html>Glass: "
                    + details.get("strGlass").toString() + "<br>Instructions: " + details.get("strInstructions").toString() + "<br><br>Ingredients:<br> ";

            if (!details.get("strIngredient1").equals(null) && !details.get("strMeasure1").equals(null)) {
                detailsString = detailsString + details.get("strMeasure1") + " " + details.get("strIngredient1") + "<br>";
            }
            if (!details.get("strIngredient2").equals(null) && !details.get("strMeasure2").equals(null)) {
                detailsString = detailsString + details.get("strMeasure2") + " " + details.get("strIngredient2") + "<br>";
            }
            if (!details.get("strIngredient3").equals(null) && !details.get("strMeasure3").equals(null)) {
                detailsString = detailsString + details.get("strMeasure3") + " " + details.get("strIngredient3") + "<br>";
            }
            if (!details.get("strIngredient4").equals(null) && !details.get("strMeasure4").equals(null)) {
                detailsString = detailsString + details.get("strMeasure4") + " " + details.get("strIngredient4") + "<br>";
            }
            if (!details.get("strIngredient5").equals(null) && !details.get("strMeasure5").equals(null)) {
                detailsString = detailsString + details.get("strMeasure5") + " " + details.get("strIngredient5") + "<br>";
            }


            String endDetailsSting = "</html>";

            DetailsDialog dialog = new DetailsDialog(detailsString + endDetailsSting);
            dialog.setVisible(true);
        } catch (JSONException ex) {
            ex.printStackTrace();
        }
    }
}
