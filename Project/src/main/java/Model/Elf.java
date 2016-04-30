package Model;

public class Elf extends Heros {
	
	public Elf(Integer posX, Integer posY) {
		super(posX,posY);
	}

	public void specialAttack() {
		
	}

	public String name() {
		return "Elf";
	}

	@Override
	public void rangeAttack(PlateauObject position, Integer direction) {
		// TODO Auto-generated method stub
		
	}
}