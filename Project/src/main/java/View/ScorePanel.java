package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import Model.Heros;
import Model.WorldEntity;
import observer.Observer;

public class ScorePanel extends Panel implements Observer {
	private Label[] labelsName = new Label[2], labelsScore = new Label[2], labelsHp = new Label[2],
					labelsForce = new Label[2], labelsDefense = new Label[2];
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
			labelsName[i] = text(heros[i][0], 
					45, 60 + i*170, 200, 30, Color.LIGHT_GRAY);
			labelsHp[i] = text("Vie : 0", 
					60, 100 + i*170, 200, 30, Color.LIGHT_GRAY);
			labelsHp[i].setFont(new Font("Monotype Corsiva",Font.BOLD,20));
			labelsScore[i] = text("Score : 0", 
					60, 130 + i*170, 200, 30, Color.LIGHT_GRAY);
			labelsScore[i].setFont(new Font("Monotype Corsiva",Font.BOLD,20));
			labelsForce[i] = text("Force : 150", 
					60, 160 + i*170, 200, 30, Color.LIGHT_GRAY);
			labelsForce[i].setFont(new Font("Monotype Corsiva",Font.BOLD,20));
			labelsDefense[i] = text("Défense : 5", 
					60, 190 + i*170, 200, 30, Color.LIGHT_GRAY);
			labelsDefense[i].setFont(new Font("Monotype Corsiva",Font.BOLD,20));
		}
		previousPlayerNumber = playerNumber;
	}
	
	private Integer playerHp(Integer player){
		return ((Heros)listHeros[player]).getHp();
	}
	
	private Integer playerScore(Integer player){
		return ((Heros)listHeros[player]).getScore();	
	}
	
	private Integer playerPower(Integer player){
		return ((Heros)listHeros[player]).getPower();
	}
	
	private Integer playerDefense(Integer player){
		return ((Heros)listHeros[player]).getDefense();
	}
	
	private void setLabelsScoreText(){
		for (int i = 0; i < playerNumber ; i++){
			labelsHp[i].setText("Vie : " + String.valueOf(playerHp(i)));
			labelsScore[i].setText("Score : " + String.valueOf(playerScore(i)));
			labelsForce[i].setText("Force : " + String.valueOf(playerPower(i)));
			labelsDefense[i].setText("Defense : " + String.valueOf(playerDefense(i)));
		}
	}
	
	private void resetScoreText(){
		for (int i = 0; i < previousPlayerNumber; i++){
			labelsName[i].setText(" ");
			labelsHp[i].setText(" ");
			labelsScore[i].setText(" ");
			labelsForce[i].setText(" ");
			labelsDefense[i].setText(" ");
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
