/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Hole.
 * 
 * @author Edith
 */
public class Hole extends PlateauObject {
	
	public Hole(int pos_x, int pos_y,boolean passable) {
		super(pos_x, pos_y, passable);
		// TODO Auto-generated constructor stub
	}
	
	public String nameImage()
	{
		return this.getClass().getName();
	}

	public void tomber(){
		
	}
}
