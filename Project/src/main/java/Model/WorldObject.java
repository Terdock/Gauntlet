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
<<<<<<< HEAD
		 setVisible(false);
=======
	}

	public static Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public static Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
>>>>>>> branch 'master' of https://github.com/Terdock/Gauntlet
	}
	
	public String nameType(){
		return "Object";
	}

}
