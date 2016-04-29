package observer;

import java.util.ArrayList;

import Model.WorldEntity;

public interface Observer{

	public abstract void update(WorldEntity[][] listTerrain);
	public abstract void update(Integer numberMap);
	public abstract void update(WorldEntity[] listHeros);

}
