package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class IdentityPanel extends Panel{
	private Button button;
	private TextField[] playerName;
	private ComboBox[] typeHeros;
	private Label[] nameLabels;
	
	public IdentityPanel(Image img, Panel panel, ImageIcon[] imageIcons, String type){
		super(img, panel, imageIcons, type);
		initialisation();
	}
	
	private void initialisation(){
		arrows();
		writeName(Integer.valueOf(type));
		choiceHeros(Integer.valueOf(type));
		button = button("Commencer", 410, 510, 200, 35, Color.ORANGE);
	}
	
	private void writeName(int playerNumber){
		nameLabels = new Label[playerNumber];
		this.playerName = new TextField[playerNumber];
		for(Integer i = 1; i<= playerNumber; i++){
			nameLabels[i-1] = text("Joueur "+i.toString(), 450, 10 + i*100, 200, 30, Color.ORANGE);
			playerName[i-1] = new TextField("Nom", i);
			this.add(playerName[i-1]);
		}
	}
	
	private void choiceHeros(int playerNumber){
		this.typeHeros = new ComboBox[playerNumber];
		for (Integer i = 1; i<= playerNumber; i++){
			typeHeros[i-1] = new ComboBox(i);
			this.add(typeHeros[i-1]);
		}
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

}
