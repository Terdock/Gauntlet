package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.Panel;

public class Keyboard implements KeyListener{
	private Boolean[][] Keys;
	private Integer playerNumber;
	
	public Keyboard(){
		
	}

	public Keyboard(Integer playerNumber, Panel panel) {
		this.playerNumber = playerNumber;
		panel.addKeyListener(this);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		Keys = new Boolean[playerNumber][5];
		for(int i = 0; i<playerNumber;i++){
			for(int j = 0; j<5; j++){
				Keys[i][j] = false;
			}
		}
	}

	
	public void keyPressed(KeyEvent e) {
		changeValue(true, e);
	}

	public void keyReleased(KeyEvent e) {
		changeValue(false, e);
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	private void changeValue(Boolean bool, KeyEvent e){
		switch (e.getKeyCode()){
		case 38:
			Keys[0][0] = bool;
			System.out.println("UP, YES !!!!" + String.valueOf(bool));
			break;
		case 39:
			Keys[0][1] = bool;
			break;
		case 40:
			Keys[0][2] = bool;
			break;
		case 37:
			Keys[0][3] = bool;
			break;
		case 32:
			if(playerNumber.equals(1)){
				Keys[0][4] = bool;
			}else if(playerNumber.equals(2)){
				Keys[1][4] = bool;
			}
			break;
		case 13:
			if(playerNumber.equals(2)){
				Keys[0][4] = bool;
			}
			break;
		case 90:
			conditionMultiplayer(0, bool);
			break;
		case 68:
			conditionMultiplayer(1, bool);
			break;
		case 83:
			conditionMultiplayer(2, bool);
			break;
		case 81:
			conditionMultiplayer(3, bool);
			break;
		}
	}
	
	private void conditionMultiplayer(Integer i, Boolean bool){
		if(playerNumber.equals(2)){
			Keys[1][i] = bool;
		}
	}

}

