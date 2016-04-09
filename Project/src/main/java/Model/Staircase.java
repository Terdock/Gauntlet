/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;


public class Staircase extends PlateauObject {
	
	private final static int nombre_ligne = 40;
	private final static int nombre_colonne = 40;
	
	public Staircase(boolean passable) {
		super(nombre_ligne, nombre_colonne, passable);
		// TODO Auto-generated constructor stub
	}
	
	public String nameImage()
	{
		return this.getClass().getName();
	}
	
	public void grimper(){
		
	}
}
