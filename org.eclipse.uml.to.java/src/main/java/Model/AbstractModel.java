package Model;

import java.util.ArrayList;

import observer.Observable;
import observer.Observer;


public abstract class AbstractModel implements Observable {
	
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	public abstract void createPlateau(String Mode);
	public abstract void createHero(ArrayList<ArrayList<String>> playerRegister);
	
	public void addObserver(Observer obs){
		 this.listObserver.add(obs);
	}
	public void removeObserver(){
		listObserver = new ArrayList<Observer>();
	}
	public void notifyObserver(
			ArrayList<WorldEntity> List_Hero,
			ArrayList<WorldEntity> List_Monster){
		
		for (Observer obs : listObserver)
		obs.update(List_Hero,List_Monster);
		 
	}


	

}
