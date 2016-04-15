package Model;


public abstract class WorldEntity {
	private static int width = 30;
	private static int height = 30;
	private int posX;
	private int posY;
	private boolean visible = true;
	
	public WorldEntity(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public abstract String nameImage();
	public abstract String nameType();


	public static int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public static int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX= posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public boolean getVisible(){
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	


}
