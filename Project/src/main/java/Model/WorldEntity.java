/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;


public abstract class WorldEntity {
	
	/**
	 * Description of the property Width.
	 */
	private static int Width = 30;

	/**
	 * Description of the property Height.
	 */
	private static int Height = 30;

	/**
	 * Description of the property Life.
	 */

	
	public WorldEntity(int pos_x, int pos_y) {
		Pos_x = pos_x;
		Pos_y = pos_y;
	}


	public static int getWidth() {
		return Width;
	}



	public static void setWidth(int width) {
		Width = width;
	}



	public static int getHeight() {
		return Height;
	}



	public static void setHeight(int height) {
		Height = height;
	}


	private int Pos_x;

	private int Pos_y;

	public abstract String nameImage();
	
	public abstract String nameType();
	


	public int getPos_x() {
		return Pos_x;
	}

	public void setPos_x(int pos_x) {
		Pos_x = pos_x;
	}

	public int getPos_y() {
		return Pos_y;
	}

	public void setPos_y(int pos_y) {
		Pos_y = pos_y;
	}

	// Start of user code (user defined attributes for WorldEntity)

	// End of user code



}
