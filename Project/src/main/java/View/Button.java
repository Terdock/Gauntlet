package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton {
	private int x, y, width, height;
	private Font font = new Font("Tempus Sans ITC",Font.BOLD,16);
	private String type;
	private Color color;
	
	
	public Button(ImageIcon imageIcon, int x, int y, int width, int height){
		super(imageIcon);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		initialisation();
	}
	
	public Button(String name, int x, int y, int width, int height, Color color){
		super(name);
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
        this.setFont(font);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        //this.setBorderPainted(false);
        this.setFocusPainted(false);
	}

}
