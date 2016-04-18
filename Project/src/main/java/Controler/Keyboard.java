package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.Panel;

public class Keyboard implements KeyListener{
	private Boolean[][] Keys;
	
	public Keyboard(){
		
	}

	public Keyboard(Integer playerNumber, Panel panel) {
		panel.addKeyListener(this);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		for(int i = 0; i<playerNumber;i++){
			for(int j = 0; j<5; j++){
				Keys[i][j] = false;
			}
		}
	}

	
	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
