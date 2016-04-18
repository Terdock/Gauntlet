package observer;

import java.util.ArrayList;

import Model.WorldEntity;

public interface Observable {
	
	 public void addObserver(Observer obs);
	 public void removeObserver();
	 public void notifyObserver(ArrayList<WorldEntity> entities);
	 public void notifyObserver(Integer numberMap);

}
