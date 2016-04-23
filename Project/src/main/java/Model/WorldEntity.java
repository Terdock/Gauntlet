package Model;


public abstract class WorldEntity {
	private static Integer width = 30;
	private static Integer heigth = 30;
	private Integer posX;
	private Integer posY;
	private Integer Form;
	
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

	public static Integer getHeigth() {
		return heigth;
	}

	public void setHeigth(Integer heigth) {
		this.heigth = heigth;
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

	public Integer getForm() {
		return Form;
		
	}
	public void setForm(Integer form) {
		Form = form;
	}

	


}
