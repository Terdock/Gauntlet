package Model;


public class Staircase extends PlateauObject {
	
	private final static Integer nombreLigne = 40;
	private final static Integer nombreColonne = 40;
	
	public Staircase(boolean passable) {
		super(nombreLigne, nombreColonne, passable);
	}
	
	public String nameImage(){
		return null;
	}
	
	public void grimper(){
		
	}
}
