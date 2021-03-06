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
	public abstract void doActionHeros(String action, Integer state, Integer player);
	public abstract void doActionMonsters();
	public abstract void setDimensions(Integer[] dimensions);
	public abstract void attackHeros(Integer player);
	public abstract void checkModeEnd();


}