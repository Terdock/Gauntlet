package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Model.Heros;
import Model.WorldEntity;
import observer.Observer;

public class ScorePanel extends Panel implements Observer {
	private Label[] labelsName = new Label[4], labelsScore = new Label[4], labelsHp = new Label[4];
	private WorldEntity[] listHeros;
	private Integer playerNumber;
	private String[][] heros;
	
	public ScorePanel(Panel panel, Image img){
		super(panel);
		this.setLayout(null);
		this.img = img;
		this.setBounds(720, 0, 300, 600);
	}
	
	public void addName(){
		for (int i = 0; i < playerNumber; i++){
			labelsName[i] = text(heros[i][1] + " : " + heros[i][0], 
					45, 60 + i*130, 200, 30, Color.LIGHT_GRAY);
			labelsHp[i] = text("Vie : 0", 
					60, 100 + i*130, 200, 30, Color.LIGHT_GRAY);
			labelsHp[i].setFont(new Font("Monotype Corsiva",Font.BOLD,20));
			labelsScore[i] = text("Score : 0", 
					60, 130 + i*130, 200, 30, Color.LIGHT_GRAY);
			labelsScore[i].setFont(new Font("Monotype Corsiva",Font.BOLD,20));
		}
	}
	
	private Integer playerHp(Integer player){
		Integer hp = ((Heros)listHeros[player]).getHp();
		return hp;
	}
	
	private Integer playerScore(Integer player){
		Integer score = ((Heros)listHeros[player]).getScore();
		return score;
	}
	
	private void setLabelsScoreText(){
		for (int i = 0; i < playerNumber; i++){
			labelsHp[i].setText("Vie : " + String.valueOf(playerHp(i)));
			labelsScore[i].setText("Score : " + String.valueOf(playerScore(i)));
		}
	}

	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		setLabelsScoreText();
		repaint();
	}
	
	public void setPlayerAndHeros(Integer playerNumber, String[][] heros){
		this.playerNumber = playerNumber;
		this.heros = heros;
	}
	
	public void update(WorldEntity[] listHeros) {
		this.listHeros = listHeros;
	}

	public void update(WorldEntity[][] listTerrain) {
		
	}

	public void update(Integer numberMap) {
		
	}
}
