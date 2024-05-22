package View;

import javax.swing.*;

import Controller.FavoriteButtonListener;
import Model.Dao.Cocktail;
import org.json.JSONException;

import java.awt.*;
import java.io.IOException;
import java.util.List;

import Model.Singleton.Singleton;


public class MainFrame {

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel topPanel;
    private JLabel title;
    private JScrollPane scrollPane;
    private String frameTitle;
    private Color color;


    public MainFrame(String frameTitle, Color color) throws JSONException, IOException, InterruptedException {
        this.frameTitle = frameTitle;
        this.color = color;
        initComponents();
    }

    private void initComponents() throws JSONException, IOException, InterruptedException {

        //frame
        frame = new JFrame();
        frame.setTitle(frameTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1800, 1000);
        frame.setLayout(new BorderLayout());
        // frame is displayed in the middle of the screen
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //panel
        mainPanel = new JPanel(new GridLayout(0, 5, 10, 10));
        scrollPane = new JScrollPane();

        // faster scroll on mid panel
        scrollPane.setViewportView(mainPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(20);
        mainPanel.setBackground(color);
        Singleton instance = Singleton.getInstance();
        List<Cocktail> cocktails = instance.getCocktailRepo().getAll().subList(0, 100);
        List<Cocktail> favorites = instance.getFavoriteRepo().readJson();

        // display the list of cocktails
        for (int i = 0; i < cocktails.size(); i++) {
            if (i == 4 || i == 62) {
                continue;
            } else {
                mainPanel.add(new CocktailPanel(cocktails.get(i)));
            }
        }
        frame.add(scrollPane, BorderLayout.CENTER);

        // initialize panel
        topPanel = new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        frame.add(topPanel, BorderLayout.NORTH);

        // title
        title = new JLabel("COCKTAIL LIST", JLabel.CENTER);
        topPanel.add(title);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Sans-serif", Font.BOLD, 36));

        // favorite list button
        JButton favoritelistbutton = new JButton("Favorite List");
        favoritelistbutton.setPreferredSize(new Dimension(200, 50)); // You can adjust the size here
        favoritelistbutton.setFont(new Font("Sans-serif", Font.BOLD, 22));
        favoritelistbutton.setBackground(Color.WHITE);
        favoritelistbutton.setToolTipText("Click to see your favourite cocktails");
        FavoriteButtonListener favoritelistener = new FavoriteButtonListener();
        favoritelistbutton.addActionListener(favoritelistener);

        // create a panel to hold the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(favoritelistbutton);
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        // add the button panel to the frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        show();
    }

    public void show() {
        this.frame.setVisible(true);
    }
}