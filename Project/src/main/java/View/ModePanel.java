package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ModePanel extends Panel{
	private Label[] labels = new Label[2];
	private Button[] buttons = new Button[3];
	private String[] buttonName = {"Mode Quête","Mode Arène","Mode Survivor"};
	
	public ModePanel(Image img, Panel panel, ImageIcon[] imageIcons, String type){
		super(img, panel, imageIcons, type);
		initialisation();
	}
	
	private void initialisation(){
		arrows();
		labels[0] = text("MODE DE JEU", 390, 150, 225, 35, Color.ORANGE);
        labels[1] = arrow(imageIcons[5], 405, 190, 198, 30);
        for(Integer i = 0; i<3;i++){
        	buttons[i] = button(buttonName[i], 405, 230 + i*50, 200, 35, Color.ORANGE);
        }
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	public String[] getButtonName() {
		return buttonName;
	}

	public Button[] getButtons() {
		return buttons;
	}

}
