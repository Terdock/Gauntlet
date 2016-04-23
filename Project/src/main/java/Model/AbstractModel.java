package Model;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;


public abstract class AbstractModel implements Observable {
	
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	public abstract void createPlateau();
	public abstract void setGameMode(String gameMode);
	public abstract void setPlayerNumber(Integer playerNumber);
	public abstract void doActionHeros(String action, Integer player);
	public abstract void checkAttackMonster();
	
	public void addObserver(Observer obs){
		 this.listObserver.add(obs);
	}
	public void removeObserver(){
		listObserver = new ArrayList<Observer>();
	}
	public void notifyObserver(
			WorldEntity[][] listTerrain){
		
		for (Observer obs : listObserver)
		obs.update(listTerrain);
		 
	}
	public void notifyObserver(Integer numberMap) {
		for(Observer obs: listObserver)
			obs.update(numberMap);
		
	}

}
