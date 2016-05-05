package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class IdentityPanel extends Panel{
	private Button button;
	private TextField[] playerName;
	private ComboBox[] typeHeros;
	private ComboBox[] dimensions;
	private Label[] labels;
	
	public IdentityPanel(Image img, Panel panel, ImageIcon[] imageIcons, String type){
		super(img, panel, imageIcons, type);
		initialisation();
	}
	
	public IdentityPanel(Image img, Panel panel, ImageIcon[] imageIcons, String type, Integer surcharge){
		super(img, panel, imageIcons, type);
		initialisation(type);
	}
	
	private void initialisation(){
		arrows();
		writeName(Integer.valueOf(type));
		choiceHeros(Integer.valueOf(type));
		button = button("Commencer", 400, 390, 200, 35, Color.ORANGE);
	}
	
	private void initialisation(String type){
		arrows();
		writeName(Integer.valueOf(type));
		choiceHeros(Integer.valueOf(type));
		choiceDimension(Integer.valueOf(type));
		button = button("Commencer", 400, 480, 200, 35, Color.ORANGE);
	}
	
	private void writeName(int playerNumber){
		labels = new Label[playerNumber + 3];
		this.playerName = new TextField[playerNumber];
		for(Integer i = 1; i<= playerNumber; i++){
			labels[i-1] = text("Joueur "+i.toString(), 450, 180 + (i-1)*100, 200, 30, Color.ORANGE);
			playerName[i-1] = new TextField("Nom", i);
			this.add(playerName[i-1]);
		}
	}
	
	private void choiceHeros(int playerNumber){
		this.typeHeros = new ComboBox[playerNumber];
		for (Integer i = 1; i <= playerNumber; i++){
			typeHeros[i-1] = new ComboBox(i);
			this.add(typeHeros[i-1]);
		}
	}
	
	private void choiceDimension(Integer playerNumber){
		labels[playerNumber] = text("Dimension", 430, 390, 200, 30, Color.ORANGE);
		labels[playerNumber + 1] = text("Lignes :", 250, 430, 150, 35, Color.ORANGE);
		labels[playerNumber + 2] = text("Colonnes :", 560, 430, 150, 30, Color.ORANGE);
		this.dimensions = new ComboBox[5];
		Integer[][] bounds = {{365, 432}, {703, 432}};
		for (Integer i = 0; i < 2; i++){
			dimensions[i] = new ComboBox(i, bounds[i]);
			this.add(dimensions[i]);
		}
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public Button getButton() {
		return button;
	}

	public ComboBox[] getTypeHeros() {
		return typeHeros;
	}

	public TextField[] getPlayerName() {
		return playerName;
	}

	public ComboBox[] getDimensions() {
		return dimensions;
	}
	
	

}
