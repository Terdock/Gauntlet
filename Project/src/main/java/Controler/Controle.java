package Controler;

import java.util.ArrayList;

import Model.*;

public class Controle extends AbstractControler{
	
	public Controle(AbstractModel game){
		super(game);
		Keyboard k = new Keyboard();
	}


	public void initComposant(String mode, String[][] playerRegister) {
		game.createHero(playerRegister);
		game.createPlateau(mode);
		
	}
	
	
	
	
	


}
