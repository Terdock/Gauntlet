package Model;

public abstract class PlateauObject extends WorldEntity {
	
	private boolean passable;
	
	public PlateauObject(int pos_x, int pos_y, boolean passable) {
		super(pos_x, pos_y);
		this.passable = passable;
		// TODO Auto-generated constructor stub
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
