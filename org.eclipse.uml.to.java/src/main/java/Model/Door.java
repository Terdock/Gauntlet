/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Porte.
 * 
 * @author Edith
 */
public class Door extends PlateauObject {

	private boolean Open = false;
	private int numberDoor;
	
	public Door(int pos_x, int pos_y,boolean passable,int numberDoor) {
		super(pos_x, pos_y, passable);
		this.numberDoor = numberDoor;
		
		// TODO Auto-generated constructor stub
	}

	public String nameImage()
	{
		return this.getClass().getName();
	}

	public boolean isOpen() {
		return Open;
	}

	public void setOpen(boolean open) {
		Open = open;
	}

	public int getNumberDoor() {
		return numberDoor;
	}

}
