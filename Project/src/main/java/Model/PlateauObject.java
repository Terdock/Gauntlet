package Model;

public abstract class PlateauObject extends WorldEntity {
	
	private boolean passable;
	
	public PlateauObject(int posX, int posY, boolean passable) {
		super(posX, posY);
		this.passable = passable;
	}

	boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		this.passable = passable;
	}
	
	public String nameType(){
		return "Terrain";
	}
	
	

}
