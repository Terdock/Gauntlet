package Controler;

import Model.AbstractModel;

public abstract class AbstractControler {
	AbstractModel game;
		
	public AbstractControler(AbstractModel game){
		this.game = game;
	}

	public abstract void initComposant(String mode, String[][] playerRegister);

}
