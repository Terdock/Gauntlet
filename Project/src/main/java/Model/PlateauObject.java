package Model;

public abstract class PlateauObject extends WorldEntity {
	
	private boolean passable;
	private Integer Form;

	public PlateauObject(Integer posX, Integer posY, boolean passable) {
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
