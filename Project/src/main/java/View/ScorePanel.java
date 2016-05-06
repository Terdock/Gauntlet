package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Model.Heros;
import Model.WorldEntity;
import observer.Observer;

public class ScorePanel extends Panel implements Observer {
	private Label[] labelsName = new Label[2], labelsScore = new Label[2], labelsHp = new Label[2];
	private WorldEntity[] listHeros;
	private Integer previousPlayerNumber = 0;
	private Integer playerNumber;
	private String[][] heros;
	
	public ScorePanel(Panel panel, Image img){
		super(panel);
		this.setLayout(null);
		this.img = img;
		this.setBounds(720, 0, 300, 600);
	}
	
	public void addName(){
		if (!(labelsName[0] == null) && !(labelsHp[0] == null) && !(labelsScore[0] == null)){
			resetScoreText();
		}
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
		previousPlayerNumber = playerNumber;
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
		for (int i = 0; i < playerNumber ; i++){
			labelsHp[i].setText("Vie : " + String.valueOf(playerHp(i)));
			labelsScore[i].setText("Score : " + String.valueOf(playerScore(i)));
		}
	}
	
	private void resetScoreText(){
		for (int i = 0; i < previousPlayerNumber; i++){
			labelsName[i].setText(" ");
			labelsHp[i].setText(" ");
			labelsScore[i].setText(" ");
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
	
	public void update(boolean replay){
		
	}
}
