package Model;

import Model.Potion;

public class HealthPotion extends Potion {
	private Integer hp = 1000000;

	public HealthPotion(Integer PosX, Integer PosY) {
		super(PosX, PosY);
	}

	public String name() {
		return "Health Potion";
	}
	
	public void useObject(){
		
	}

	public void useObject(Heros heros) {
		heros.setHp(hp, this);
	}

	
	
}
