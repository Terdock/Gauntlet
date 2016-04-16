package Model;


public abstract class WorldEntity {
	private static Integer width = 30;
	private static Integer height = 30;
	private Integer posX;
	private Integer posY;
	private boolean visible = true;
	
	public WorldEntity(Integer posX, Integer posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public abstract String nameImage();
	public abstract String nameType();


	public static Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public static Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getPosX() {
		return posX;
	}

	public void setPosX(Integer posX) {
		this.posX= posX;
	}

	public Integer getPosY() {
		return posY;
	}

	public void setPosY(Integer posY) {
		this.posY = posY;
	}

	public boolean getVisible(){
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	


}
