package Model;

import Model.Potion;

public class GiantStepPotion extends Potion {
	
	public GiantStepPotion(Integer PosX, Integer PosY) {
		super(PosX, PosY);
	}

	
	public String name() {
		return "Giant Step Potion";
	}

	public void useObject() {
	
	}

	public void useObject(Heros heros) {
		heros.setPasDeGeant(true);
	}


}
