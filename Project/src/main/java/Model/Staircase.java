package Model;


public class Staircase extends WorldObject {
	
	private static Integer nombreLigne = Plateau.getNombrelignearene();
	private static Integer nombreColonne = Plateau.getNombrecolonnearene();
	
	public Staircase(Integer posX, Integer posY){
		super(posX, posY);
	}
	
	public String nameImage(){
		return null;
	}
	
	public void grimper(){
		
	}
}
