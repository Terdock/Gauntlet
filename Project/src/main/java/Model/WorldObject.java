package Model;

public abstract class WorldObject extends WorldEntity {
	

	private static int height = 15;
	private static int width = 15;
	
	public WorldObject(int posX, int posY) {
		super(posX, posY);
		 setVisible(false);
	}

	public static int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public static int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public String nameType(){
		return "Object";
	}

}
