package Model;

public class Exit extends Sol{
	
	public Exit(Integer posX, Integer posY, boolean passable, boolean weaponPassable) {
		super(posX, posY, passable, weaponPassable, 0);
	}

	public String name(){
		return "Exit";
	}

	public boolean next(Integer posX, Integer posY) {
		return posX.equals(getPosX()) && posY.equals(getPosY());
	}

}
