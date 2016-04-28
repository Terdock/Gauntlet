package Model;

import Model.WorldObject;

public class KeyDoor extends WorldObject {
	
	Integer numberOfDoor;

	public KeyDoor(Integer posX, Integer posY, Integer numberOfDoor) {
		super(posX, posY);
		numberOfDoor = numberOfDoor;
	}

	public String name(){
		return null;
	}

	@Override
	public void useObject() {
		// TODO Auto-generated method stub
		
	}


}
