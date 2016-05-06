package Model;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;


public abstract class AbstractModel implements Observable {
	
	
	//Carte visite de toutes les classes héritant de AbstractModel
	public abstract void setGameMode(String gameMode);
	public abstract void setPlayerNumber(Integer playerNumber);
	public abstract void setNumberLineMode(Integer numberLineMode);
	public abstract void setNumberColumnMode(Integer numberColumnMode);
	public abstract void createGame(String[][] playerRegister);
	public abstract void doActionHeros(String action, Integer state, Integer player);
	public abstract void attackHeros(Integer player);
	public abstract void checkAttackMonster();
	public abstract Creatures[] getListHeros();
	public abstract void checkModeEnd();
	
	
	
	//(Pour ce qui suit) Implémentation des observers pour les prévenir des changements dans Model
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	public void addObserver(Observer obs){
		 this.listObserver.add(obs);
	}
	
	public void removeObserver(){
		listObserver = new ArrayList<Observer>();
	}
	
	public void notifyObserver(WorldEntity[][] listTerrain){
		for (Observer obs:listObserver)
			obs.update(listTerrain);
	}
	
	public void notifyObserver(Integer numberMap) {
		for(Observer obs: listObserver)
			obs.update(numberMap);
	}
	
	public void notifyObserver(WorldEntity[] listHeros) {
		for(Observer obs: listObserver)
			obs.update(listHeros);
	}
	
	public void notifyObserver(boolean replay) {
		for(Observer obs: listObserver)
			obs.update(replay);
	}
		
}