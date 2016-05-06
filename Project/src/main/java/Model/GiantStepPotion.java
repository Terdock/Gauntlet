package Model;

import Model.Potion;

public class GiantStepPotion extends Potion {
	
	public GiantStepPotion() {
		super(0,0);
	}

	
	public String name() {
		return "Giant Step Potion";
	}

	public void useObject(Heros heros) {
		heros.setPasDeGeant(true);
	}


}
