package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TextField extends JTextField{
	private Font font = new Font("Tempus Sans ITC",Font.BOLD,16);
	
	public TextField(String name, Integer i){
		this.setForeground(Color.ORANGE);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setText(name);
		this.setFont(font);
		this.setOpaque(false);
		this.setBounds(550, 230 + (i-1)*100, 200, 30);
	}

}
