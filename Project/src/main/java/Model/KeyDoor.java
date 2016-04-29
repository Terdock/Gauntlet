package Model;

import Model.WorldObject;

public class KeyDoor extends WorldObject {
	Integer numberOfDoor;
	IPlateau plateau;

	public KeyDoor(IPlateau plateau,Integer posX, Integer posY, Integer numberOfDoor) {
		super(posX, posY);
		this.plateau = plateau;
		numberOfDoor = numberOfDoor;
		
	}

	public String name(){
		return "KeyDoor";
	}

	@Override
	public void useObject() {
		plateau.openDoor(getPosX(),getPosY());
	}


}
