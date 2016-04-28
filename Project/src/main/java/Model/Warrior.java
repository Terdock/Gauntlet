package Model;

public class Warrior extends Heros{
	private Weapon weapon = new Weapon(getPosX(), getPosY(), name());;
	
	public Warrior(Integer posX, Integer posY) {
		super(posX,posY);
	}


	public void rangeAttack() {
		
	}

	public void specialAttack() {
		
	}

	public String name() {
		return "Warrior";
	}

}
