package Model;


public class Staircase extends PlateauObject {
	
	private static Integer nombreLigne = Plateau.getNombrelignearene();
	private static Integer nombreColonne = Plateau.getNombrecolonnearene();
	
	public Staircase(boolean passable) {
		super((nombreLigne-2)*getWidth(), (nombreColonne-2)*getHeigth(), passable);
	}
	
	public String nameImage(){
		return null;
	}
	
	public void grimper(){
		
	}
}
