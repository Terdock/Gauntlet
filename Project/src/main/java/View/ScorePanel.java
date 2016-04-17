package View;

import java.awt.Color;
import java.awt.Graphics;

public class ScorePanel extends Panel{
	
	public ScorePanel(Panel panel){
		super(panel);
		this.setBounds(700, 0, 300, 600);
	}

	public void paintComponent(Graphics g){
		this.setBackground(Color.BLACK);
		//g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}
