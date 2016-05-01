package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import Model.Heros;
import Model.WorldEntity;
import observer.Observer;

public class AgainPanel extends Panel implements Observer{
	private Image image;
	private Label[] labels = new Label[4];
	private Button[] buttons = new Button[2];
	private Integer playerNumber;
	private String[][] heros;
	private WorldEntity[] listHeros;
	
	public AgainPanel(Panel panel, Image image, ImageIcon[] imageIcons, String type){
		super(panel, type);
		this.imageIcons = imageIcons;
		this.image = image;
		initialisation();
	}
	
	public void initialisation(){
		arrows();
		labels[0] = text("FIN DU JEU", 405, 150, 225, 35, Color.RED);
		labels[1] = arrow(imageIcons[5], 405, 190, 198, 30);
		buttons[0] = button("Rejouer", 405, 330, 200, 35, Color.ORANGE);
		buttons[1] = button("Quitter", 405, 380, 200, 35, Color.RED);
	}

	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, 1000, 600, null);
		showScore();
	}
	
	private void showScore(){
		for(Integer i = 0; i < playerNumber; i++){
			Integer score = ((Heros)listHeros[i]).getScore();
			labels[i+2] = text(heros[i][1] + " : " + heros[i][0] + " : " + String.valueOf(score), 380, 230 + i*50, 300, 35, Color.ORANGE);
		}
	}
	
	public void setPlayerAndHeros(Integer playerNumber, String[][] heros){
		this.playerNumber = playerNumber;
		this.heros = heros;
	}

	public Button[] getButtons() {
		return buttons;
	}

	public void update(WorldEntity[] listHeros) {
		this.listHeros = listHeros;
		this.playerNumber = listHeros.length;
	}
	
	public void update(WorldEntity[][] listTerrain) {
		
	}
	
	public void update(Integer numberMap) {
		
	}
}
