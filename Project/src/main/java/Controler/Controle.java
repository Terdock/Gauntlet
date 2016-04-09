package Controler;

import java.util.ArrayList;

import Model.*;

public class Controle extends AbstractControler{
	
	public Controle(AbstractModel Game){
		super(Game);
		Keyboard K  = new Keyboard();
	}


	@Override
	public void initComposant(String mode, String[][] playerRegister) {
		Game.createHero(playerRegister);
		Game.createPlateau(mode);		// TODO Auto-generated method stub
		
	}


}
