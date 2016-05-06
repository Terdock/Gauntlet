package Model;

public abstract class WorldObject extends WorldEntity {
	
	private boolean Visible;

	public WorldObject(Integer posX, Integer posY) {
		super(posX, posY);
		 setVisible(false);
	}
	
	public abstract void useObject(Heros heros);
	
	public String nameType(){
		return "Object";
	}
	
	public boolean isVisible() {
		return Visible;
	}

	public void setVisible(boolean visible) {
		Visible = visible;
	}

}
