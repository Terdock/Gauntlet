package Model;

public class Weapon {
	private String type;
	private Integer direction;
	private Integer posX;
	private Integer posY;
	private Integer degat; 
	
	public Weapon( String type, Integer direction){
		this.type = type;
		this.direction = direction;
		
	}
	
	public Integer getDirection() {
		return direction;
	}


	public String name(){
		return type;
	}

	public void attack(Creatures creature) {
		creature.receiveAttack(degat, creature.getDefense());
		
	}
	
	

}
