/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

import Model.Potion;
import Model.WorldObject;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Potion.
 * 
 * @author Edith
 */
public abstract class Potion extends WorldObject {
	// Start of user code (user defined attributes for Potion)

	// End of user code

	/**
	 * The constructor.
	 */
	public Potion(int PosX,int PosY) {
		// Start of user code constructor for Potion)
		super(PosX,PosY);
		// End of user code
	}

	@Override
	public abstract String nameImage();
	

}