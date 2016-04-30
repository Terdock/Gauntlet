package View;

import java.awt.Graphics;
import java.awt.Image;

public class AgainPanel extends Panel{
	Image image;
	
	public AgainPanel(Panel panel, Image image, String type){
		super(panel, type);
		this.image = image;
	}

	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, 1000, 600, null);
	}
}
