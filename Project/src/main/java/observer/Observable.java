package observer;

import Model.WorldEntity;

public interface Observable {
	
	 public void addObserver(Observer obs);
	 public void removeObserver();
	 public void notifyObserver(WorldEntity[][] entities);
	 public void notifyObserver(Integer numberMap);
	 public void notifyObserver(boolean replay);

}
