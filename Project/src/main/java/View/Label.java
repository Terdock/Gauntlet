package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel{
	private int x, y, width, height;
	private Font font = new Font("Monotype Corsiva",Font.BOLD,32);
	private Color color;
	
	
	public Label(ImageIcon imageIcon, int x, int y, int width, int height){
		super(imageIcon);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		initialisation();
	}
	
	public Label(String Name, int x, int y, int width, int height, Color color){
		super(Name);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		initialisation();
	}
	
	private void initialisation(){
		this.setBounds(x, y, width, height);
		this.setForeground(color);
		this.setOpaque(false);
		this.setFont(font);
	}

}
