package Controler;

import java.util.ArrayList;

import Model.AbstractModel;

public abstract class AbstractControler {
	AbstractModel Game;
		
	public AbstractControler(AbstractModel Game){
		this.Game = Game;
	}

	public abstract void initComposant(String mode, String[][] playerRegister);

}
