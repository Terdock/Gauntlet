package Model;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;


public abstract class AbstractModel implements Observable {
	
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	public abstract void createPlateau(String mode);
	public abstract void createHero(String[][] playerRegister);
	
	public void addObserver(Observer obs){
		 this.listObserver.add(obs);
	}
	public void removeObserver(){
		listObserver = new ArrayList<Observer>();
	}
	public void notifyObserver(
			ArrayList<WorldEntity> entities){
		
		for (Observer obs : listObserver)
		obs.update(entities);
		 
	}


	

}
