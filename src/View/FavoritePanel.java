package View;

import Controller.RemoveFavoriteListener;
import Controller.SetEnumListener;
import Model.Dao.Cocktail;
import Model.Repository.FavoriteType;
import Model.Singleton.Singleton;
import Controller.ComboRenderer;

import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;


public class FavoritePanel extends JPanel {
private Cocktail favorite;


	public FavoritePanel(Cocktail favorite) {
		this.favorite=favorite;
		display(favorite);
	}

	public void display(Cocktail favorite) {

		setLayout(new BorderLayout());
		// image of cocktail
		try {
			Singleton instance = Singleton.getInstance();
			URL url = new URL(favorite.getImg());
			BufferedImage c = ImageIO.read(url);
			ImageIcon imageIcon = new ImageIcon(c); // load the image to a imageIcon
			Image image = imageIcon.getImage(); // transform it
			Image newimg = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // scale
			imageIcon = new ImageIcon(newimg); // transform it back
			JLabel iconLabel = new JLabel(favorite.getName(), imageIcon, JLabel.CENTER);
			// set font in label
			iconLabel.setFont(new Font("Sans-serif", Font.BOLD, 16));
			// give position to the icon in horizontal and vertical axis
			// by changing text position
			iconLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			iconLabel.setVerticalTextPosition(SwingConstants.TOP);
			// add label to panel
			add(iconLabel, BorderLayout.CENTER);

		} catch (MalformedURLException e) {
			System.out.println("MalformedURL");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}

		// add to favorites button
		JButton button1 = new JButton("Remove");
		// add tool tip to the button when hover
		button1.setToolTipText("Click to remove from favorites");

		//margin
		button1.setMargin(new Insets(10, 10, 10, 10));

		//size
		button1.setPreferredSize(new Dimension(80, 40));

		// set button color
		button1.setBackground(Color.WHITE);
		// delete action
		RemoveFavoriteListener remove = new RemoveFavoriteListener(favorite,this);
		button1.addActionListener(remove);

		JPanel southPanel = new JPanel(new BorderLayout());
		// add the button to the south of border layout
		southPanel.add(button1, BorderLayout.EAST);

		JComboBox<String> comboBox = new JComboBox(FavoriteType.values());
		comboBox.setOpaque(false);
		comboBox.setRenderer(new ComboRenderer(favorite.getCategory()));
		comboBox.setSelectedIndex(-1);
		SetEnumListener enumAction = new SetEnumListener(favorite,comboBox);
		comboBox.addActionListener(enumAction);

		southPanel.add(comboBox,BorderLayout.WEST);

		add(southPanel,BorderLayout.SOUTH);
	}
}