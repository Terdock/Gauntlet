package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controler.AbstractControler;

public class Panel extends JPanel{
	private Panel panel;
	private Button[] buttons = new Button[10];
	private String[] buttonName = {"Mode Quête","Mode Arène","Mode Survivor"};
	private ImageIcon[] ImageIcons;
	private Label[] labels = new Label[16], nameLabels = new Label[4];
	private TextField[] playerName;
	private ComboBox[] typeHeros;
	private String type;
	private Image img;
	private CardLayout card;
	
	
	public Panel(){
		this.card = new CardLayout();
		this.setLayout(card);
	}
	
	public Panel(Image img, Panel panel, String type){
		this.panel = panel;
		this.type = type;
		this.img = img;
		//chargeImage();
		this.setBounds(0, 0, 700, 600);
		construction(0,700);
	}
	
	public Panel(Image img, Panel panel, ImageIcon[] ImageIcons, String type){
		this.img = img;
		this.panel = panel;
		this.ImageIcons = ImageIcons;
		this.type = type;
		this.setLayout(null);
		initialisation();
	}
	
	private void construction(int x, int width){
		panel.add(this, type);
		if (x < 300){
			this.setBackground(Color.GREEN);
		}else{
			this.setBackground(Color.BLACK);
		}
	}
	
	private void initialisation(){
		panel.add(this, type);
		if (type.equals("Home")){
			buttons[0] = button("Jouer", 450, 480, 100, 30, Color.ORANGE);
			labels[0] = arrow(ImageIcons[0], 450, 450, 100, 30);
	        labels[1] = arrow(ImageIcons[0], 450, 510, 100, 30);
		}else if (type.equals("ModeDeJeu")){
			arrows();
			labels[10] = text("MODE DE JEU", 390, 150, 225, 35, Color.ORANGE);
	        labels[11] = arrow(ImageIcons[5], 405, 190, 198, 30);
	        for(Integer i = 0; i<3;i++){
	        	buttons[i+1] = button(buttonName[i], 405, 230 + i*50, 200, 35, Color.ORANGE);
	        }
		}else if (type.equals("Player")){
			arrows();
			labels[12] = text("NOMBRE DE JOUEUR", 330, 150, 400, 35, Color.ORANGE);
			for (Integer i = 1; i <= 4; i++){
				buttons[i+3] = button(String.valueOf(i) + " Joueur", 405, 230 + (i-1)*50, 200, 35, Color.ORANGE);
			}
		}else if (type.equals("1")||type.equals("2")||type.equals("3")||type.equals("4")){
			arrows();
			writeName(Integer.valueOf(type));
			choiceHeros(Integer.valueOf(type));
			buttons[8] = button("Commencer", 410, 510, 200, 35, Color.ORANGE);
		}
	}

	private void arrows(){
		labels[2] = arrow(ImageIcons[1], 302, 0, 198, 30);
        labels[3] = arrow(ImageIcons[2], 500, 0, 198, 30);
        labels[4] = arrow(ImageIcons[1], 302, 580, 198, 30);
        labels[5] = arrow(ImageIcons[2], 500, 580, 198, 30);
        labels[6] = arrow(ImageIcons[3], 0, 102, 30, 198);
        labels[7] = arrow(ImageIcons[4], 0, 300, 30, 198);
        labels[8] = arrow(ImageIcons[3], 970, 102, 30, 198);
        labels[9] = arrow(ImageIcons[4], 970, 300, 30, 198);
	}
	
	private void chargeImage(){
		
	}
	
	private void writeName(int playerNumber){
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
	
	public void paintComponent(Graphics g){
		if(!type.equals("harr")){
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}else{
			g.drawImage(img, 0, 0, 700, this.getHeight(), this);
		}
		               
	}
	
	private Button button(String name, int x, int y, int width, int height, Color color){
		Button button = new Button(name, x, y, width, height, color);
		this.add(button);
		return button;
	}
	
	private Label text(String name, int x, int y, int width, int height, Color color){
		Label label = new Label(name, x, y, width, height, color);
		this.add(label);
		return label;
	}
	
	private Label arrow(ImageIcon icon, int x, int y, int width, int height){
		Label label = new Label(icon, x, y, width, height);
		this.add(label);
		return label;
	}

	public CardLayout getCard() {
		return card;
	}
	
	public Button[] getButtons() {
		return buttons;
	}

	public String[] getButtonName() {
		return buttonName;
	}

	public ComboBox[] getTypeHeros() {
		return typeHeros;
	}

	public TextField[] getPlayerName() {
		return playerName;
	}
	
	
	
//pattern observer : permet de changer la list des entities à adequat lorsqu'on fait la mise à jour d'une des listes
	
	

}
