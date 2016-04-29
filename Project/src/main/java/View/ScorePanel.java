package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import Model.Heros;
import Model.WorldEntity;
import observer.Observer;

public class ScorePanel extends Panel implements Observer {
	private Label[] labels = new Label[4];
	private WorldEntity[] listHeros;
	
	public ScorePanel(Panel panel, Image img){
		super(panel);
		this.setLayout(null);
		this.img = img;
		this.setBounds(720, 0, 300, 600);
	}
	
	public void addName(String[][] heros, Integer playerNumber){
		for (int i = 0; i < playerNumber; i++){
			labels[i] = text(heros[i][0] + " : " + heros[i][1], 
					45, 60 + i*130, 200, 30, Color.LIGHT_GRAY);
			labels[i] = text("Score : " + playerScore(i), 
					45, 100 + i*130, 200, 30, Color.LIGHT_GRAY);
		}
	}
	
	private Integer playerScore(Integer player){
		Integer score = ((Heros)listHeros[player]).getScore();
		return score;
	}

	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public void update(WorldEntity[] listHeros) {
		this.listHeros = listHeros;
	}

	public void update(WorldEntity[][] listTerrain) {
		
	}

	public void update(Integer numberMap) {
		
	}
}
