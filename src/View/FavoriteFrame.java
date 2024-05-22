package View;

import javax.swing.*;

import Model.Dao.Cocktail;
import Model.Singleton.Singleton;

import java.awt.*;
import java.util.List;

public class FavoriteFrame {

    private JFrame fr;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JScrollPane scrollPane;
    private JLabel title;

    public FavoriteFrame() {

        initComponents();
    }

    private void initComponents() {

        //frame
        fr = new JFrame();
        fr.setTitle("Favorites");
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setSize(800, 500);
        fr.setLayout(new BorderLayout());
        fr.setLocationRelativeTo(null);
        fr.setResizable(false);

        mainPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        scrollPane = new JScrollPane();

        // faster scroll on mid panel
        scrollPane.setViewportView(mainPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        mainPanel.setBackground(Color.GRAY);

        Singleton instance = Singleton.getInstance();
        List<Cocktail> favorites = instance.getFavoriteRepo().getAll();
        // display the list of cocktails
        for (int i = 0; i < favorites.size(); i++) {


            mainPanel.add(new FavoritePanel(favorites.get(i)));

        }


        fr.add(scrollPane, BorderLayout.CENTER);
        topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        fr.add(topPanel, BorderLayout.NORTH);

        //title
        title = new JLabel("Favorites", JLabel.CENTER);
        topPanel.add(title);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Sans-serif", Font.BOLD, 36));

        show();
    }

    public void show() {
        this.fr.setVisible(true);
    }
}