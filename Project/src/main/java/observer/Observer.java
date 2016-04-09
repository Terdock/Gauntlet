package observer;

import java.util.ArrayList;

import Model.WorldEntity;

public interface Observer {
	public void update(ArrayList<WorldEntity> List_Hero,ArrayList<WorldEntity> List_Monster);

}
