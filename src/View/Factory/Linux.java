package View.Factory;

import Controller.Factory.OperatingSystem;
import View.MainFrame;
import org.json.JSONException;

import java.awt.*;
import java.io.IOException;

public class Linux implements OperatingSystem {
    @Override
    public void view() throws JSONException, IOException, InterruptedException {
        MainFrame frame = new MainFrame("Linux", Color.WHITE);
        frame.show();
    }

}
