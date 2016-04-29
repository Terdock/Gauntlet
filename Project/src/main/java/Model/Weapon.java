package Model;

public class Weapon {
	private String type;
	private Integer direction;
	
	public Weapon(String type, Integer direction){
		this.type = type;
		this.direction = direction;
	}
	
	public Integer getDirection() {
		return direction;
	}

	public String name(){
		return type;
	}
	
	

}
