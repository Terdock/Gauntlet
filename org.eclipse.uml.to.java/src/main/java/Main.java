import java.awt.EventQueue;

import Controler.*;
import Model.*;
import View.Window;

public class Main {
	
	public static void main(String[] args) {
		
		AbstractModel Game = new GauntletGame();
		 
		AbstractControler control = new Controle(Game);
		
		Window window = new Window(control);
		
		Game.addObserver(window);
		
	}
}