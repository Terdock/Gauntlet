package Model;

import Model.WorldObject;

public class KeyDoor extends WorldObject {
	Map map;
	Integer numberOfDoor;

	public KeyDoor(Map map,Integer posX, Integer posY, Integer numberOfDoor) {
		super(posX, posY);
		this.map = map;
		numberOfDoor = numberOfDoor;
		
	}

	public String name(){
		return "KeyDoor";
	}

	@Override
	public void useObject() {
		map.openDoor(getPosX(),getPosY());
	}


}
