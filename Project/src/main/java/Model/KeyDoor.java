package Model;

import Model.WorldObject;

public class KeyDoor extends WorldObject {
	Integer numberOfDoor;
	IPlateau plateau;

	public KeyDoor(IPlateau plateau,Integer posX, Integer posY, Integer numberOfDoor) {
		super(posX, posY);
		this.plateau = plateau;
		this.numberOfDoor = numberOfDoor;	
	}
	
	public String name(){
		return "KeyDoor";
	}

	@Override
	public void useObject(Heros heros) {
		plateau.openDoor(getPosX(),getPosY());
	}


}
