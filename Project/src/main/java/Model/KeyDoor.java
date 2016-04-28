package Model;

import Model.WorldObject;

public class KeyDoor extends WorldObject {
	IMap map;
	Integer numberOfDoor;

	public KeyDoor(IMap map,Integer posX, Integer posY, Integer numberOfDoor) {
		super(posX, posY);
		this.map = map;
		numberOfDoor = numberOfDoor;
		
	}

	public String name(){
		return null;
	}

	@Override
	public void useObject() {
		map.openDoor(getPosX(),getPosY());
	}


}
