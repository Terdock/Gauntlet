package observer;

import java.util.ArrayList;

import Model.PlateauObject;
import Model.WorldEntity;

public interface Observer{

	public abstract void update(PlateauObject[][] listTerrain);
	public abstract void update(Integer numberMap);
	public abstract void update(WorldEntity[] listTerrain);

}
