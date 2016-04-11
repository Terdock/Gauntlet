package Model;

import java.util.ArrayList;
import observer.Observable;

public class GauntletGame extends AbstractModel {
	
	private int numberMap; 
	private static int nombreLigne = 1000;
	private static int nombreColonne = 1000;
	IPlateau plateau;
	private ArrayList<Hero> List_Hero = new ArrayList<Hero>();
	private ArrayList<WorldEntity> listHero = new ArrayList<WorldEntity>();
	private ArrayList<Monster> List_Monster = new ArrayList<Monster>();
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<PlateauObject> List_Terrain =  new ArrayList<PlateauObject>();
	private ArrayList<WorldEntity> listTerrain =  new ArrayList<WorldEntity>();
	private String mode; 
	private int multiplayer;
	
	
	public GauntletGame() {
		
	}

	
	public void createHero(String[][] playerRegister) {
		List_Hero = convertListHero(playerRegister);
		for(int i = 0; i < List_Hero.size();i++)
			listHero.add(List_Hero.get(i));
		multiplayer = List_Hero.size(); 
		notifyObserver(listHero);
		
	}

	
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	public void createPlateau(String Mode){
		setMode(Mode);
		this.plateau = new Plateau(nombreLigne,nombreColonne,0,Mode);
		List_Terrain = this.plateau.getLIST_TERRAIN();
		for(int i = 0; i < List_Terrain.size();i++)
			listTerrain.add(List_Terrain.get(i));
		notifyObserver(listTerrain);
	}
	
	public ArrayList<Hero> convertListHero(String[][] playerRegister){
		for (int i = 0; i < Integer.valueOf(playerRegister[4][0]); i++ ){
			if(playerRegister[i][1].equals("Sorcier")){
				Wizzard W = new Wizzard(1,1);
				W.setPlayerName(playerRegister[i][0]);
				List_Hero.add(W);
			}else if(playerRegister[i][1].equals("Guerrier")){
				Knight K = new Knight(1,1);
				K.setPlayerName(playerRegister[i][0]);
				List_Hero.add(K);
			}else if( playerRegister[i][1].equals("Nain")){
				Dwarf D = new Dwarf(1,1);
				D.setPlayerName(playerRegister[i][0]);
				List_Hero.add(D);
			}else if(playerRegister[i][1].equals("Elfe")){
				Elf E = new Elf(1,1);
				E.setPlayerName(playerRegister[i][0]);
				List_Hero.add(E);
			}
		}
		return List_Hero;
			
		
	}

}
