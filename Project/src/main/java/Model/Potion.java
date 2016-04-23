package Model;

import Model.Potion;
import Model.WorldObject;

public abstract class Potion extends WorldObject {
	public Potion(Integer PosX,Integer PosY) {
		super(PosX,PosY);
	}

	public abstract String name();
	

}