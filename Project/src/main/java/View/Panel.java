package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panel extends JPanel{
	protected Panel panel;
	protected ImageIcon[] imageIcons;
	protected String type;
	protected Image img;
	private Label[] labels = new Label[8];
	private CardLayout card;
	
	
	public Panel(){
		this.card = new CardLayout();
		this.setBounds(0, 0, 1000, 600);
		this.setLayout(card);
	}
	
	public Panel(Panel panel){
		this.panel = panel;
		panel.add(this);
	}
	
	public Panel(Panel panel, String type){
		this.panel = panel;
		this.type = type;
		this.setLayout(null);
		panel.add(this, type);
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
		//Arrow from Up
		labels[0] = arrow(imageIcons[1], 302, 0, 198, 30);
        labels[1] = arrow(imageIcons[2], 500, 0, 198, 30);
        //Arrow from Down
        labels[2] = arrow(imageIcons[1], 302, 570, 198, 30);
        labels[3] = arrow(imageIcons[2], 500, 570, 198, 30);
        //Arrow from Left
        labels[4] = arrow(imageIcons[3], 0, 102, 30, 198);
        labels[5] = arrow(imageIcons[4], 0, 300, 30, 198);
        //Arrow from Right
        labels[6] = arrow(imageIcons[3], 964, 102, 30, 198);
        labels[7] = arrow(imageIcons[4], 964, 300, 30, 198);
	}
	
	protected Button button(String name, int x, int y, int width, int height, Color color){
		Button button = new Button(name, x, y, width, height, color);
		button.setFocusable(false);
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
}
