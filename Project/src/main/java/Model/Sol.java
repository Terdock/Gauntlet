/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

public class Sol extends PlateauObject {

	private int numberMap;

	public Sol(int pos_x, int pos_y, boolean passable,int numberMap) {
		super(pos_x, pos_y, passable);
		this.numberMap = numberMap;
		
	}

	@Override
	public String nameImage() {

		return this.getClass().getName()+ Integer.toString(numberMap);
	}

	
}
