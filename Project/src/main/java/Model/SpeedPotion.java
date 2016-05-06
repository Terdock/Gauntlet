package Model;

public class SpeedPotion extends WorldObject {


	public SpeedPotion() {
		super(0, 0);
	}

	public String name() {
		return "Speed Potion";
	}

	public void useObject(Heros heros){
		heros.setStep(2);
		
	}



}
