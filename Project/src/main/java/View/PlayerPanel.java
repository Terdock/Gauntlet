package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class PlayerPanel extends Panel{
	private Label label = new Label();
	private Button[] buttons = new Button[4]; 
	
	public PlayerPanel(Image img, Panel panel, ImageIcon[] imageIcons, String type){
		super(img, panel, imageIcons, type);
		initialisation();
	}
	
	private void initialisation(){
		arrows();
		label = text("NOMBRE DE JOUEUR", 330, 150, 400, 35, Color.ORANGE);
		for (Integer i = 1; i <= 4; i++){
			buttons[i-1] = button(String.valueOf(i) + " Joueur", 405, 230 + (i-1)*50, 200, 35, Color.ORANGE);
		}
	}

	public Button[] getButtons() {
		return buttons;
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	

}
