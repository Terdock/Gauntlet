import Controller.*;
import Model.*;
import View.Window;
import observer.Observer;

public class Main {
	public static void main(String[] args) {
		//Cr�ation de la carte visite de la classe AbstractModel visible par le Controller
		AbstractModel game = new GauntletGame();
		
		//Cr�ation de la carte visite de la classe AbstractController visible par le View
		AbstractController control = new Controller(game);
		
		//Cr�ation de la fen�tre contenant toute l'interface graphique
		Window window = new Window(control);
		
		//Ajout des panneaux comme observeurs du Model
		game.addObserver((Observer)window.getPanel()[7]);
		game.addObserver((Observer)window.getPanel()[6]);
		game.addObserver((Observer)window.getPanel()[8]);
	}
}