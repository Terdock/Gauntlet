package observer;

import java.util.ArrayList;

import Model.WorldEntity;

public interface Observable {
	
	 public void addObserver(Observer obs);
	 public void removeObserver();
	 public void notifyObserver(ArrayList<WorldEntity> List_Hero, ArrayList<WorldEntity> List_Monster);

}
