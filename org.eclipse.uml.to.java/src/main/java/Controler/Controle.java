package Controler;

import java.util.ArrayList;

import Model.*;

public class Controle extends AbstractControler{
	
	public Controle(AbstractModel Game){
		super(Game);
		Keyboard K  = new Keyboard();
	}

	
	public void initComposant(String Mode, ArrayList<ArrayList<String>> PlayerRegister){
		Game.createHero(PlayerRegister);
		Game.createPlateau(Mode);		
	}


}
