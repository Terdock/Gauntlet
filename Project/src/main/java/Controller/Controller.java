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

	public void attackMonster(){
		
	}

	public void initComposant(String[][] playerRegister) {
		game.createPlateau(playerRegister);
	}
	
	public void doActionHeros(String action, Integer player){
		if(game.getListHeros()[player].isLife()){
			game.doActionHeros(action, player);
		}
	}
	
	public void doActionMonsters(){
		game.checkAttackMonster();
	}


}