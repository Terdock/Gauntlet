package Model;

public class Exit extends PlateauObject{
	
	public Exit(Integer posX, Integer posY, boolean passable, boolean weaponPassable) {
		super(posX, posY, passable, weaponPassable);
	}

	public String name(){
		return "Exit";
	}

	public boolean next(Integer posX, Integer posY) {
		return posX.equals(getPosX()) && posY.equals(getPosY());
	}

}
