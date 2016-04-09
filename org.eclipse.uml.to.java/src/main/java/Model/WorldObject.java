/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

import Model.WorldEntity;
import Model.WorldObject;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of WorldObject.
 * 
 * @author Edith
 */
public abstract class WorldObject extends WorldEntity {
	

	/**
	 * Description of the property Height.
	 */
	private static int Height = 15;

	/**
	 * Description of the property Width.
	 */
	private static int Width = 15;
	
	public WorldObject(String nameImage, int pos_x, int pos_y) {
		super(nameImage, pos_x, pos_y);
		// TODO Auto-generated constructor stub
	}

	public static int getHeight() {
		return Height;
	}

	public static void setHeight(int height) {
		Height = height;
	}

	public static int getWidth() {
		return Width;
	}

	public static void setWidth(int width) {
		Width = width;
	}

	// Start of user code (user defined attributes for WorldObject)

	// End of user code


}
