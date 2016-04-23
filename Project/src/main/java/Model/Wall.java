package Model;

public class Wall extends PlateauObject  {
	 Integer numberMap; 
	 
	
	public Wall(Integer posX, Integer posY, boolean passable,Integer numberMap) {
		super(posX, posY, passable);
		this.numberMap = numberMap;
	}

	public String name(){
		return this.getClass().getName()+Integer.toString(numberMap);
	}
	
	

}
