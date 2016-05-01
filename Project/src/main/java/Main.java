import java.awt.EventQueue;

import Controller.*;
import Model.*;
import View.Window;
import observer.Observer;

public class Main {
	
	public static void main(String[] args) {
		
		AbstractModel game = new GauntletGame();
		AbstractController control = new Controller(game);
		Window window = new Window(control);
		game.addObserver((Observer)window.getPanel()[7]);
		game.addObserver((Observer)window.getPanel()[6]);
		game.addObserver((Observer)window.getPanel()[8]);
	}
}