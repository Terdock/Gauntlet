package Model;

public abstract class WorldObject extends WorldEntity {
	
	private boolean Visible;
	
	public boolean isVisible() {
		return Visible;
	}

	public void setVisible(boolean visible) {
		Visible = visible;
	}

	public WorldObject(Integer posX, Integer posY) {
		super(posX, posY);
		 setVisible(false);
	}


	
	public String nameType(){
		return "Object";
	}

}
