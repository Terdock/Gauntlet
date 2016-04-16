package Model;

public class Door extends PlateauObject {

	private boolean open = false;
	private Integer numberDoor;
	
	public Door(Integer posX, Integer posY,boolean passable,Integer numberDoor){
		super(posX, posY, passable);
		this.numberDoor = numberDoor;
	}

	public String nameImage(){
		return this.getClass().getName();
	}

	public boolean isOpen(){
		return open;
	}

	public void setOpen(boolean open){
		this.open = open;
	}

	public Integer getNumberDoor(){
		return numberDoor;
	}

}
