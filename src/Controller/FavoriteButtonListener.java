package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.FavoriteFrame;

public class FavoriteButtonListener implements ActionListener {

    public FavoriteButtonListener() {

    }

    public void actionPerformed(ActionEvent e) {
        FavoriteFrame frame2 = new FavoriteFrame();
        frame2.show();
    }
}
