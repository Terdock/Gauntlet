package Controller;

import Model.AbstractModel;

public class Controller extends AbstractController{
	
	public Controller(AbstractModel game){
		super(game);
	}
	
	public void setDimensions(Integer[] dimensions){
		game.setNombreColonneSurvivor(dimensions[0]);
		game.setNombreLigneSurvivor(dimensions[1]);
	}
	
	public void setGameMode(String gameMode){
		game.setGameMode(gameMode);
	}
	
	public void setGamePlayerNumber(Integer playerNumber){
		game.setPlayerNumber(playerNumber);
	}

	public void attackHeros(Integer player){
		game.attackHeros(player);
	}

	public void initComposant(String[][] playerRegister) {
		game.createPlateau(playerRegister);
	}
	
	public void doActionHeros(String action, Integer state, Integer player){
		if(game.getListHeros()[player].isLife()){
			game.doActionHeros(action, state, player);
		}
	}
	
	public void doActionMonsters(){
		game.checkAttackMonster();
	}
	public void checkModeEnd(){
		game.checkModeEnd();
	}


}