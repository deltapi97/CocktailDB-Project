package View;

import Controller.AddFavoriteListener;
import Controller.DetailsListener;
import Model.Dao.Cocktail;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;


public class CocktailPanel extends JPanel {
    private Cocktail cocktail;

    public CocktailPanel(Cocktail cocktail) {
        this.cocktail = cocktail;
        display(cocktail);
    }

    public void display(Cocktail cocktail) {
        setLayout(new BorderLayout());

        try {
            //get image
            URL url = new URL(cocktail.getImg());
            BufferedImage c = ImageIO.read(url);
            ImageIcon imageIcon = new ImageIcon(c); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it
            Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // scale
            imageIcon = new ImageIcon(newimg); // transform it back
            JLabel iconLabel = new JLabel(cocktail.getName(), imageIcon, JLabel.CENTER);
            //add font
            iconLabel.setFont(new Font("Sans-serif", Font.BOLD, 16));
            iconLabel.setHorizontalTextPosition(SwingConstants.CENTER);
            iconLabel.setVerticalTextPosition(SwingConstants.TOP);
            //add image to panel
            add(iconLabel, BorderLayout.CENTER);


        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException");
            e.printStackTrace();
        }

        // buttons
        JButton button1 = new JButton("Add");
        JButton button2 = new JButton("Details");

        button1.setToolTipText("Click to add to favourites");
        button2.setToolTipText("Click to see details");
        button1.setMargin(new Insets(10, 10, 10, 10));
        button2.setMargin(new Insets(10, 10, 10, 10));

        button1.setPreferredSize(new Dimension(50, 40));
        button2.setPreferredSize(new Dimension(100, 40));
        //add actionlisteners
        AddFavoriteListener addlistener = new AddFavoriteListener(cocktail);
        DetailsListener details = new DetailsListener(cocktail.getId());
        button1.addActionListener(addlistener);
        button2.addActionListener(details);

       //panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(button1, BorderLayout.EAST);
        buttonPanel.add(button2, BorderLayout.WEST);
    }
}