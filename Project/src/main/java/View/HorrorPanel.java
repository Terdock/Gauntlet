package View;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;

public class HorrorPanel extends Panel{
	private Image image;
	private CardLayout card;
	private static int i = 0;

	public HorrorPanel(CardLayout card, Panel panel, Image image, String type){
		super(panel, type);
		this.image = image;
		this.card = card;
		this.setSize(1000, 600);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, 1000, 600, null);
		if (i>0){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			card.show(panel, "Play Again");
			i=0;
		}
		i++;
		repaint();
	}
}
