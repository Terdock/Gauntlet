package Model;

public class HealthPotion extends WorldObject {

	public HealthPotion() {
		super(3, 3);
	}

	public String name() {
		return "Health Potion";
	}
	

	public void useObject(Heros heros) {
		heros.setHp(heros.getHp()+300, this);
	}

	
	
}
