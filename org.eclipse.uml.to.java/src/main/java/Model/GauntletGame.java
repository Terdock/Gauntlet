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
	
	public void createHero(ArrayList<ArrayList<String>> Player) {
		List_Hero = convertListHero(Player);
		Multiplayer = Player.size(); 
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
	
	public ArrayList<Hero> convertListHero(ArrayList<ArrayList<String>> Player){
		for (int i = 0; i < Player.size(); i++ ){
			if( Player.get(i).get(1) == "Wizzard" ){
				Wizzard W = new Wizzard(1,1);
				W.setPlayerName(Player.get(i).get(0));
				List_Hero.add(W);
			}
			else if( Player.get(i).get(1) == "Knight" ){
				Knight K = new Knight(1,1);
				K.setPlayerName(Player.get(i).get(0));
				List_Hero.add(K);
			}
			else if( Player.get(i).get(1) == "Dwarf" ){
				Dwarf D = new Dwarf(1,1);
				D.setPlayerName(Player.get(i).get(0));
				List_Hero.add(D);
			}
			else if( Player.get(i).get(1) == "Elf" ){
				Elf E = new Elf(1,1);
				E.setPlayerName(Player.get(i).get(0));
				List_Hero.add(E);
			}
		}
		return List_Hero;
			
		
	}
	
	
	
	



}
