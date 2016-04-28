package Model;

public class Weapon {
	private Integer posX, posY;
	private String type;
	
	public Weapon(Integer posX, Integer posY, String type){
		this.posX = posX;
		this.posY = posY;
		this.type = type;
	}

	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posX) {
		this.posX = posX;
	}

	public Integer getPosY() {
		return posY;
	}

	public void setPosY(Integer posY) {
		this.posY = posY;
	}
	
	public String name(){
		return type;
	}
	
	

}
