/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

import java.util.ArrayList;
import observer.Observable;

public class GauntletGame extends AbstractModel {
	
	private int Numbermap; 
	private static int nombre_ligne = 1000;
	private static int nombre_colonne = 1000;
	IPlateau Plateau;
	private ArrayList<Hero> List_Hero;
	private ArrayList<Monster> List_Monster;
	private String Mode; 
	private int Multiplayer;
	/**
	 * The constructor.
	 */
	public GauntletGame() {
	
		
	}

	@Override
	public void createHero(String[][] playerRegister) {
		List_Hero = convertListHero(playerRegister);
		Multiplayer = playerRegister.length; 
		
	}

	
	public String getMode() {
		return Mode;
	}
	public void setMode(String mode) {
		Mode = mode;
	}
	
	
	public void createPlateau(String Mode){
		setMode(Mode);
		Plateau = new Plateau(nombre_ligne,nombre_colonne,0,Mode);
	}
	
	public ArrayList<Hero> convertListHero(String[][] playerRegister){
		for (int i = 0; i < playerRegister.length; i++ ){
			if( playerRegister[i][1] == "Wizzard" ){
				Wizzard W = new Wizzard(1,1);
				W.setPlayerName(playerRegister[i][0]);
				List_Hero.add(W);
			}
			else if( playerRegister[i][1] == "Knight" ){
				Knight K = new Knight(1,1);
				K.setPlayerName(playerRegister[i][0]);
				List_Hero.add(K);
			}
			else if( playerRegister[i][1] == "Dwarf" ){
				Dwarf D = new Dwarf(1,1);
				D.setPlayerName(playerRegister[i][0]);
				List_Hero.add(D);
			}
			else if( playerRegister[i][1] == "Elf" ){
				Elf E = new Elf(1,1);
				E.setPlayerName(playerRegister[i][0]);
				List_Hero.add(E);
			}
		}
		return List_Hero;
			
		
	}


	
	
	
	



}
