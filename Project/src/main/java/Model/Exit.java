package Model;

public class Exit extends PlateauObject{
	
	public Exit(Integer posX, Integer posY, boolean passable, boolean weaponPassable, Integer numberMap) {
		super(posX, posY, passable, weaponPassable, "Ground", numberMap);
	}

	public boolean next(Integer posX, Integer posY) {
		return posX.equals(getPosX()) && posY.equals(getPosY());
	}
	
	public String name(){
		return "Exit";
	}
}
