package Model;

import java.util.ArrayList;
import observer.Observable;

public class GauntletGame extends AbstractModel {
	
	private Integer numberMap; 
	private static Integer nombreLigne = 15;
	

	private static Integer nombreColonne = 15;
	IPlateau plateau;
	private ArrayList<Hero> List_Hero = new ArrayList<Hero>();
	private ArrayList<WorldEntity> listHero = new ArrayList<WorldEntity>();
	private ArrayList<Monster> List_Monster = new ArrayList<Monster>();
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<PlateauObject> List_Terrain =  new ArrayList<PlateauObject>();
	private ArrayList<WorldEntity> listTerrain =  new ArrayList<WorldEntity>();
	private String mode; 
	private Integer multiplayer;
	
	public GauntletGame() {
		this.numberMap = 0;
		
	}
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	public void createPlateau(String Mode){
		setMode(Mode);
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,Mode);
		this.List_Terrain = this.plateau.getLIST_TERRAIN();
		for(PlateauObject obj : List_Terrain)
			listTerrain.add(obj);
		notifyObserver(listTerrain);
		this.List_Monster = plateau.getListMonster();
		for(Monster mob : List_Monster)
			listMonster.add(mob);
		//notifyObserver(listMonster);
	}
	
	public void createHero(String[][] playerRegister) {
		List_Hero = convertListHero(playerRegister);
		for(Hero hero : List_Hero)
			listHero.add(hero);
		multiplayer = List_Hero.size(); 
		notifyObserver(listHero);
	}
	
	public ArrayList<Hero> convertListHero(String[][] playerRegister){
		for (Integer i = 0; i < playerRegister.length; i++ ){
			if(playerRegister[i][1] == "Sorcier"){
				Wizzard W = new Wizzard(1,1);
				W.setPlayerName(playerRegister[i][0]);
				List_Hero.add(W);
			}else if(playerRegister[i][1] == "Guerrier"){
				Knight K = new Knight(1,1);
				K.setPlayerName(playerRegister[i][0]);
				List_Hero.add(K);
			}else if( playerRegister[i][1] == "Nain"){
				Dwarf D = new Dwarf(1,1);
				D.setPlayerName(playerRegister[i][0]);
				List_Hero.add(D);
			}else if(playerRegister[i][1] == "Elfe"){
				Elf E = new Elf(1,1);
				E.setPlayerName(playerRegister[i][0]);
				List_Hero.add(E);
			}
		}
		return List_Hero;
	}

	public Integer getNumberMap() {
		return numberMap;
	}

	public void setNumberMap(Integer numberMap) {
		this.numberMap = numberMap;
	}
}
