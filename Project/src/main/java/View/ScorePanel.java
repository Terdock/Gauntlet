package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class ScorePanel extends Panel{
	private Label[] labels = new Label[4];
	
	public ScorePanel(Panel panel, Image img){
		super(panel);
		this.setLayout(null);
		this.img = img;
		this.setBounds(700, 0, 300, 600);
	}
	
	public void addName(String[][] heros, Integer playerNumber){
		for (int i = 0; i < playerNumber; i++){
			labels[i] = text(heros[i][0] + " : " + heros[i][1], 
					60, 60 + i*130, 200, 30, Color.LIGHT_GRAY);
		}
	}

	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
