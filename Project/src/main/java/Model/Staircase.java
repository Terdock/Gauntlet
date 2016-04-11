package Model;


public class Staircase extends PlateauObject {
	
	private final static int nombreLigne = 40;
	private final static int nombreColonne = 40;
	
	public Staircase(boolean passable) {
		super(nombreLigne, nombreColonne, passable);
	}
	
	public String nameImage(){
		return null;
	}
	
	public void grimper(){
		
	}
}
