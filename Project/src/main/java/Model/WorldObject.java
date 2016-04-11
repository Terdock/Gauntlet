package Model;

public abstract class WorldObject extends WorldEntity {
	

	private static int height = 15;
	private static int width = 15;
	private boolean visible = false;
	
	public WorldObject(int posX, int posY) {
		super(posX, posY);
	}

	public static int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
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
