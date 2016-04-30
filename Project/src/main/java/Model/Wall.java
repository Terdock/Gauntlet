package Model;

public class Wall extends PlateauObject  {
	 Integer numberMap; 
	 
	
	public Wall() {
		super(0, 0, false);
	}
	public Wall(Integer posX, Integer posY, boolean passable,Integer numberMap) {
		super(posX, posY, passable);
		this.numberMap = numberMap;
	}



	public String name(){
		System.out.println(this.getClass().getName()+Integer.toString(numberMap));
		return this.getClass().getName()+Integer.toString(numberMap);

	}
	
	

}
