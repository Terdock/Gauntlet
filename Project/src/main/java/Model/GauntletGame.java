package Model;

import java.util.ArrayList;
import observer.Observable;

public class GauntletGame extends AbstractModel {
	
	private Integer numberMap; 
	private static Integer nombreLigne = 101;
	private static Integer nombreColonne = 101;
	IPlateau plateau;
	private WorldEntity[][] listTerrain = new WorldEntity[nombreColonne][nombreLigne];
	private String gameMode;
	private Integer playerNumber; 
	private Creatures[] listHeros;
	
	public GauntletGame() {
		this.numberMap = 0;
	}
	
	
	public void createPlateau(String[][] playerRegister){
		notifyObserver(numberMap);
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,gameMode,playerRegister,playerNumber);
		this.listTerrain = plateau.getListTerrain();
		this.listHeros = plateau.getListHero();
		notifyObserver(listTerrain);
		}
    
	public final void checkAttackMonster(){	
		plateau.checkAttackMonster();
	};

    public void doActionHeros(String action, Integer player) {
		if(plateau.isMoveValide(listHeros[player].getPosX(),listHeros[player].getPosY(), action)){
			Integer previousPosX = listHeros[player].getPosX();Integer previousPosY = listHeros[player].getPosY();
			listHeros[player].move(action);
			Integer nextPosX = listHeros[player].getPosX();Integer nextPosY = listHeros[player].getPosY();
			((PlateauObject) listTerrain[nextPosX][nextPosY]).setCreature(((PlateauObject) listTerrain[previousPosX][previousPosY]).getCreature());
			((PlateauObject) listTerrain[previousPosX][previousPosY]).setCreature(null);
			
		}
	}

	
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}


	public Integer getNumberMap() {
		return numberMap;
	}

	public void setNumberMap(Integer numberMap) {
		this.numberMap = numberMap;
	}


	public void setPlayerNumber(Integer playerNumber) {
		this.playerNumber = playerNumber;
		
	}


}
