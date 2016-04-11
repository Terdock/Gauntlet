package Model;

public class Wall extends PlateauObject  {
	 int numberMap; 
	 
	
	public Wall(int posX, int posY, boolean passable,int numberMap) {
		super(posX, posY, passable);
		this.numberMap = numberMap;
	}

	public String nameImage(){
		return this.getClass().getName()+Integer.toString(numberMap);
	}

}
