package Model;

import Model.Potion;

public class HealthPotion extends Potion {

	public HealthPotion() {
		super(0, 0);
	}

	public String name() {
		return "Health Potion";
	}
	

	public void useObject(Heros heros) {
		heros.setHp(heros.getHp()+300, this);
	}

	
	
}
