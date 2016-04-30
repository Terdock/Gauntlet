package Model;

public class Weapon {
	private String type;
	private Integer direction;
	private Integer degat; 
	private Creatures creature;
	
	public Weapon(String type, Integer direction, Creatures creature){
		this.type = type;
		this.direction = direction;
		this.creature = creature;
	}
	
	public Integer getDirection() {
		return direction;
	}

	public Creatures getCreature() {
		return creature;
	}

	public String name(){
		return type;
	}

	public void attack(Creatures creature) {
		creature.receiveAttack(degat, creature.getDefense());
		
	}
	
	

}
