package observer;

import java.util.ArrayList;

import Model.WorldEntity;

public interface Observer{

	public abstract void update(ArrayList<WorldEntity> entities);
	public abstract void update(Integer numberMap);

}
