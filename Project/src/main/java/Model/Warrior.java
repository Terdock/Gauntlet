package Model;

public class Warrior extends Heros{
	
	public Warrior(Integer posX, Integer posY) {
		super(posX,posY);
	}

	public void specialAttack() {
		
	}

	public String name() {
		return "Warrior";
	}

	@Override
	public void rangeAttack(PlateauObject position, Integer direction) {
		// TODO Auto-generated method stub
		
	}

}
