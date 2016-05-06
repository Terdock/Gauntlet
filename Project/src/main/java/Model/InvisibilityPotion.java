package Model;

public class InvisibilityPotion extends WorldObject {

	public InvisibilityPotion() {
		super(0, 0);
	}

	public String name() {
		return "Invisibility Potion";
	}

	public void useObject(Heros heros) {
		heros.setVisibility(false);
	}


	
	
	
}
