/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Wall.
 * 
 * @author Edith
 */
public class Wall extends PlateauObject  {
	 int numberMap; 
	 
	
	public Wall(int pos_x, int pos_y, boolean passable,int numberMap) {
		super(pos_x, pos_y, passable);
		this.numberMap = numberMap;
		// TODO Auto-generated constructor stub
	}

	public String nameImage()
	{
		return this.getClass().getName()+Integer.toString(numberMap);
	}

}
