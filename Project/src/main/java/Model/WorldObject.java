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
	
	private boolean visible = false;
	
	public WorldObject(int pos_x, int pos_y) {
		super(pos_x, pos_y);
		// TODO Auto-generated constructor stub
	}

	public static int getHeight() {
		return Height;
	}

	public static void setHeight(int height) {
		Height = height;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public static int getWidth() {
		return Width;
	}

	public static void setWidth(int width) {
		Width = width;
	}
	
	public String nameType(){
		return "Object";
	}

	// Start of user code (user defined attributes for WorldObject)

	// End of user code


}
