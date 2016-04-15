package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class HomePanel extends Panel{
	private Button button;
	private Label[] labels = new Label[2];
	
	public HomePanel(Image img, Panel panel, ImageIcon[] imageIcons, String type){
		super(img, panel, imageIcons, type);
		initialisation();
	}
	
	private void initialisation(){
		button = button("Jouer", 450, 480, 100, 30, Color.ORANGE);
		labels[0] = arrow(imageIcons[0], 450, 450, 100, 30);
        labels[1] = arrow(imageIcons[0], 450, 510, 100, 30);
	}
	
	public Button getButton() {
		return button;
	}

}
