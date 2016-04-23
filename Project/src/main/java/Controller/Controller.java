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
		game.createPlateau();
	}
	
	public void doActionHeros(String action, Integer player){
		game.doActionHeros(action, player);
	}
	
	public void doActionMonsters(){
		game.checkAttackMonster();
	}


}