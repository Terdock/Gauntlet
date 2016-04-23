package Model;

import java.util.ArrayList;

public class Plateau implements IPlateau {
	private Integer nombreLigne;
	private Integer nombreColonne;
	private final static Integer nombreLigneArene = 23;
	private final static Integer nombreColonneArene = 19;
	private Integer numberMap;
	private IMap map;
	private PlateauObject[][] listTerrain;
	private PlateauObject[][] listTerrain2;
	private Creatures[] listHero = new Creatures[4]  ;
	private Creatures[] listMonster = new Creatures[0];
	
	
	public void setListTerrain(PlateauObject[][] listTerrain) {
		this.listTerrain = listTerrain;
	}

	public Plateau(Integer nombreLigne, Integer nombreColonne,Integer numberMap,String mode,String[][] playerResiter) {
		this.nombreLigne = nombreLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
		this.map = new Map(nombreLigne, nombreColonne,numberMap);
		this.listTerrain = new PlateauObject[nombreLigne][nombreColonne];
		this.listTerrain2 = new PlateauObject[nombreLigneArene][nombreColonneArene];
		Initialisation(nombreLigne,nombreColonne,mode, playerResiter);
		
	}	
	


	private void Initialisation(Integer nombreLigne,Integer nombreColonne, String mode,String[][] playerRegister){
		listTerrain2 = map.createListTerrain(nombreLigneArene,nombreColonneArene,listTerrain2);
		if (mode.equals("Mode Quête")){
			this.listTerrain = map.createListTerrain(nombreLigne,nombreColonne,listTerrain);
		}
		else{
			this.listTerrain = listTerrain2;
		}
		System.out.println(listTerrain2);
		createHero(playerRegister);
		listMonster = map.getListMonster();
		for (Creatures player : listHero ){
			listTerrain[player.getPosX()][player.getPosY()].setCreature(player); 
		}
		//for (Creatures mob: listMonster){
			//listTerrain[mob.getPosX()][mob.getPosY()].setCreature(mob);
		//}
	}
	
	

	public Integer getNombreLigne() {
		return nombreLigne;
	}

	public void setNombreLigne(Integer nombreLigne) {
		this.nombreLigne = nombreLigne;
	}

	public Integer getNombreColonne() {
		return nombreColonne;
	}

	public void setNombreColonne(Integer nombreColonne) {
		this.nombreColonne = nombreColonne;
	}
	
	public static Integer getNombrelignearene() {
		return nombreLigneArene;
	}


	public static Integer getNombrecolonnearene() {
		return nombreColonneArene;
	}

	public Integer getNumberMap() {
		return numberMap;
	}

	public void setNumberMap(Integer numberMap) {
		this.numberMap = numberMap;
	}

	public boolean isMoveValide(Integer posX, Integer posY) {
		listTerrain[posX][posY].isPassable();
		return listTerrain[posX][posY].isPassable();
	}

	public boolean isMoveValide(Integer posX, Integer posY, String action) {
		boolean passable = true;
		if (action.equals("Action Up")){
			passable = listTerrain[posX][posY-1].isPassable();
		}else if(action.equals("Action Down")){
			passable = listTerrain[posX][posY+1].isPassable();
		}else if(action.equals("Action Right")){
			passable = listTerrain[posX+1][posY].isPassable();
		}else if(action.equals("Action Left")){
			passable = listTerrain[posX-1][posY].isPassable();
		}
		return passable;
	}

	

	
	public void createHero(String[][] playerRegister){
		for (Integer i = 0; i < playerRegister.length; i++ ){
			if(playerRegister[i][1] == "Sorcier"){
				listHero[i] = new Wizzard(60,60);
				((Heros) listHero[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Guerrier"){
				listHero[i] = new Warrior(60,60);
				((Heros) listHero[i]).setPlayerName(playerRegister[i][0]);
			}else if( playerRegister[i][1] == "Nain"){
				listHero[i] = new Dwarf(60,60);
				((Heros) listHero[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Elfe"){
				listHero[i] = new Elf(60,60);
				((Heros) listHero[i]).setPlayerName(playerRegister[i][0]);
			}
		}
	}


	@Override
	public WorldEntity[][] getListTerrain() {
		return listTerrain;
	}

	@Override
	public void setListTerrain(WorldEntity[][] listTerrain) {
		// TODO Auto-generated method stub
		
	}
}
