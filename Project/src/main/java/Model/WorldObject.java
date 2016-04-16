package Model;

public abstract class WorldObject extends WorldEntity {
	

	private static Integer height = 15;
	private static Integer width = 15;
	
	public WorldObject(Integer posX, Integer posY) {
		super(posX, posY);
		 setVisible(false);
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
	}
	
	public String nameType(){
		return "Object";
	}

}
