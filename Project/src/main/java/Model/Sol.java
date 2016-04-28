package Model;

public class Sol extends PlateauObject {

	private Integer numberMap;

	public Sol(Integer posX, Integer posY, boolean passable,Integer numberMap) {
		super(posX, posY, passable);
		this.numberMap = numberMap;
		
	}

	
	public String name() {

		return this.getClass().getName()+ Integer.toString(numberMap);
	}
	
	

	
}
