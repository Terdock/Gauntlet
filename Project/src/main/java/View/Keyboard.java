package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import View.Panel;

public class Keyboard implements KeyListener{
	private Boolean[][] keys;
	private String[] values = {"Action Up", "Action Right", "Action Down", "Action Left", "Action Attack", "Action Stop"};
	private Integer playerNumber;
	Integer stateValue;
	private Panel panel;

	public Keyboard(Integer playerNumber, Panel panel) {
		this.playerNumber = playerNumber;
		this.panel = panel;
		this.panel.addKeyListener(this);
		this.panel.setFocusable(true);
		this.panel.requestFocusInWindow();
		keys = new Boolean[this.playerNumber][5];
		for(int i = 0; i<this.playerNumber;i++){
			for(int j = 0; j<5; j++){
				keys[i][j] = false;
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
			keys[0][0] = bool;
			break;
		case 39:
			keys[0][1] = bool;
			break;
		case 40:
			keys[0][2] = bool;
			break;
		case 37:
			keys[0][3] = bool;
			break;
		case 32:
			if(playerNumber.equals(1)){
				keys[0][4] = bool;
			}else if(playerNumber.equals(2)){
				keys[1][4] = bool;
			}
			break;
		case 17:
			if(playerNumber.equals(2)){
				keys[0][4] = bool;
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
			keys[1][i] = bool;
		}
	}
	
	public Integer state(Integer player){
		stateValue = 5;
		for(Integer i = 0; i<=4; i++){
			if(keys[player][i]){
				stateValue = i;
			}
		}
		return stateValue;
	}
	
	public String stateToString(Integer state){
		return values[state];
	}
}

