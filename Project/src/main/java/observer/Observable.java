package observer;

import java.util.ArrayList;

import Model.PlateauObject;

public interface Observable {
	
	 public void addObserver(Observer obs);
	 public void removeObserver();
	 public void notifyObserver(PlateauObject[][] listTerrain);
	 public void notifyObserver(Integer numberMap);

}
