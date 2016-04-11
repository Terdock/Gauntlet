import java.awt.EventQueue;

import Controler.*;
import Model.*;
import View.Window;

public class Main {
	
	public static void main(String[] args) {
		
		AbstractModel game = new GauntletGame();
		AbstractControler control = new Controle(game);
		Window window = new Window(control);
		game.addObserver(window);
		
	}
}