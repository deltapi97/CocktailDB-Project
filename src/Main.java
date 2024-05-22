import View.Factory.SelectOS;
import org.json.JSONException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JSONException, IOException, InterruptedException {

        SelectOS startDialog = new SelectOS();
        startDialog.setVisible(true);
    }
}

