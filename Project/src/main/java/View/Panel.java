package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Model.WorldEntity;

public class Panel extends JPanel{
	protected Panel panel;
	protected ImageIcon[] imageIcons;
	protected String type;
	protected Image img;
	private Label[] labels = new Label[8];
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
	}
	
	public Panel(Image img, Panel panel, ImageIcon[] imageIcons, String type){
		this.img = img;
		this.panel = panel;
		this.imageIcons = imageIcons;
		this.type = type;
		this.setLayout(null);
		panel.add(this, type);
	}

	protected void arrows(){
		labels[0] = arrow(imageIcons[1], 302, 0, 198, 30);
        labels[1] = arrow(imageIcons[2], 500, 0, 198, 30);
        labels[2] = arrow(imageIcons[1], 302, 580, 198, 30);
        labels[3] = arrow(imageIcons[2], 500, 580, 198, 30);
        labels[4] = arrow(imageIcons[3], 0, 102, 30, 198);
        labels[5] = arrow(imageIcons[4], 0, 300, 30, 198);
        labels[6] = arrow(imageIcons[3], 970, 102, 30, 198);
        labels[7] = arrow(imageIcons[4], 970, 300, 30, 198);
	}
	
	private void chargeImage(){
		
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	protected Button button(String name, int x, int y, int width, int height, Color color){
		Button button = new Button(name, x, y, width, height, color);
		this.add(button);
		return button;
	}
	
	protected Label text(String name, int x, int y, int width, int height, Color color){
		Label label = new Label(name, x, y, width, height, color);
		this.add(label);
		return label;
	}
	
	protected Label arrow(ImageIcon icon, int x, int y, int width, int height){
		Label label = new Label(icon, x, y, width, height);
		this.add(label);
		return label;
	}

	public CardLayout getCard() {
		return card;
	}

	
	
	
	
//pattern observer : permet de changer la list des entities à adequat lorsqu'on fait la mise à jour d'une des listes
	
	

}
