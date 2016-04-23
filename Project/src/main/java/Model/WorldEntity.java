package Model;


public abstract class WorldEntity {
	private Integer posX;
	private Integer posY;
	private Integer Form;
	
	public WorldEntity(Integer posX, Integer posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public abstract String name();
	public abstract String nameType();
<<<<<<< HEAD
=======

>>>>>>> refs/remotes/origin/master

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
