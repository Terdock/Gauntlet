package Model;

import Model.Potion;

public class PowerPotion extends Potion {
	

	public PowerPotion(Integer PosX, Integer PosY) {
		super(PosX, PosY);
	}

	public String name() {
		return "Power Potion";
	}

	public void useObject() {
		
	}
	
	public void useObject(Heros heros){
		heros.setPower(heros.getPower() + 5);
	}


}
