import java.awt.EventQueue;

import Controller.*;
import Model.*;
import View.Window;

public class Main {
	
	public static void main(String[] args) {
		
		AbstractModel game = new GauntletGame();
		AbstractController control = new Controller(game);
		Window window = new Window(control);
		game.addObserver(window);
		
	}
}