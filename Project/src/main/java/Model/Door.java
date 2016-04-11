package Model;

public class Door extends PlateauObject {

	private boolean open = false;
	private int numberDoor;
	
	public Door(int posX, int posY,boolean passable,int numberDoor){
		super(posX, posY, passable);
		this.numberDoor = numberDoor;
	}

	public String nameImage(){
		return null;
	}

	public boolean isOpen(){
		return open;
	}

	public void setOpen(boolean open){
		this.open = open;
	}

	public int getNumberDoor(){
		return numberDoor;
	}

}
