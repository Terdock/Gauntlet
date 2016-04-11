package Model;

import Model.Potion;
import Model.WorldObject;

public abstract class Potion extends WorldObject {
	public Potion(int PosX,int PosY) {
		super(PosX,PosY);
	}

	public abstract String nameImage();
	

}