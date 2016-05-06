package Model;

public class GiantStepPotion extends WorldObject{
	
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
