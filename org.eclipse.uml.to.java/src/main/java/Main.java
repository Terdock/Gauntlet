/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code


import Controler.*;
import Model.*;
import View.*;


/**
 * Description of Main.
 * 
 * @author Edith
 */
public class Main {
	
	public static void main(String[] args){

	    AbstractModel Game = new GauntletGame();

	    AbstractControler control = new Controle(Game);

	    Fenetre Fenetre = new Fenetre(control);

	    Game.addObserver(Fenetre);

	}
}
