package Controller;

import Model.AbstractModel;

public abstract class AbstractController {
	AbstractModel game;
		
	public AbstractController(AbstractModel game){
		this.game = game;
	}

	public abstract void setGameMode(String modeDeJeu);
	public abstract void setGamePlayerNumber(Integer playerNumber);
	public abstract void initComposant(String[][] playerRegister);
	public abstract void doActionHeros(String action, Integer player);


}