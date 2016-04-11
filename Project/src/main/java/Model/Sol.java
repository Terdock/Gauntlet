package Model;

public class Sol extends PlateauObject {

	private int numberMap;

	public Sol(int posX, int posY, boolean passable,int numberMap) {
		super(posX, posY, passable);
		this.numberMap = numberMap;
		
	}

	
	public String nameImage() {

		return this.getClass().getName()+ Integer.toString(numberMap);
	}

	
}
