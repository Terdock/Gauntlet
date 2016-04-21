package Controller;

import Model.AbstractModel;

public class Controller extends AbstractController{
	
	public Controller(AbstractModel game){
		super(game);
	}
	
	public void setGameMode(String gameMode){
		game.setGameMode(gameMode);
	}
	
	public void setGamePlayerNumber(Integer playerNumber){
		game.setPlayerNumber(playerNumber);
	}


	public void initComposant(String[][] playerRegister) {
		game.createHero(playerRegister);
		game.createPlateau();
	}
	
	public void doAction(String action, Integer player){
		game.doAction(action, player);
	}


}