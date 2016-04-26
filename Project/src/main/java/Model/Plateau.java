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
	private Creatures[] listHero;
	private Creatures[] listMonster;
	private Integer playerNumber;
	
	public void setListTerrain(PlateauObject[][] listTerrain) {
		this.listTerrain = listTerrain;
	}

	public Plateau(Integer nombreLigne, Integer nombreColonne,Integer numberMap,String mode,String[][] playerResiter, Integer playerNumber) {
		this.nombreLigne = nombreLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
		this.playerNumber = playerNumber;
		this.listTerrain = new PlateauObject[nombreColonne][nombreLigne];
		this.listTerrain2 = new PlateauObject[nombreColonneArene][nombreLigneArene];
		this.map = new Map(nombreLigne, nombreColonne,numberMap);
		Initialisation(nombreLigne,nombreColonne,mode, playerResiter);
		
	}	
	


	private void Initialisation(Integer nombreLigne,Integer nombreColonne, String mode,String[][] playerRegister){
		listTerrain2 = map.createListTerrain(nombreLigneArene,nombreColonneArene,listTerrain2);
		if (mode.equals("Mode Quête")){
			this.listTerrain = map.createListTerrain(nombreLigne,nombreColonne,listTerrain);
			createHero(playerRegister);
			listMonster = map.getListMonster();
			
			for (Creatures mob: listMonster){
				listTerrain[mob.getPosX()][mob.getPosY()].setCreature(mob);
			}
		}
		else{
			this.listTerrain = listTerrain2;
		}
		for (Creatures player : listHero ){
				listTerrain[player.getPosX()][player.getPosY()].setCreature(player); 
			}
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


	public boolean isMoveValide(Integer posX, Integer posY, String action) {
		boolean passable = false;
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
		this.listHero = new Creatures[playerNumber];
		for (Integer i = 0; i < playerNumber; i++ ){
			if(playerRegister[i][1] == "Sorcier"){
				listHero[i] = new Wizzard(3,4);
				((Heros) listHero[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Guerrier"){
				listHero[i] = new Warrior(3,3);
				((Heros) listHero[i]).setPlayerName(playerRegister[i][0]);
			}else if( playerRegister[i][1] == "Nain"){
				listHero[i] = new Dwarf(4,3);
				((Heros) listHero[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Elfe"){
				listHero[i] = new Elf(4,4);
				((Heros) listHero[i]).setPlayerName(playerRegister[i][0]);
			}
		}
	}
	

	public void checkAttackMonster(){
		for(Creatures hero : listHero){
			for (Integer j =  0; j < 10; j++){
				for(Integer i = 0; i < 10;i++){
					Integer a,b,c,d,e,f,h;
					a=hero.getPosX()-i; b=hero.getPosY()-j;c=hero.getPosX()+i;d=hero.getPosY()+j;
					if(a > 0 && b > 0 && a < nombreColonne &&  b< nombreLigne )
						isAttack(((PlateauObject) listTerrain[a][b]).getCreature(),hero,a,b);
					if(c > 0 && b > 0 && c < nombreColonne &&  b< nombreLigne )
						isAttack(((PlateauObject) listTerrain[c][b]).getCreature(),hero,c,b);
					if(a > 0 && d > 0 && a < nombreColonne &&  d< nombreLigne )
						isAttack(((PlateauObject) listTerrain[a][d]).getCreature(),hero,a,d);
					if(c > 0 && d > 0 && c < nombreColonne &&  d < nombreLigne )
						isAttack(((PlateauObject) listTerrain[c][d]).getCreature(),hero,c,d);
					
				}
			}
		}	
	}
	public void isAttack(Creatures mob, Creatures hero, Integer i, Integer j){	
			if(!(mob == null) && !(mob.equals(hero))){
				if(isMoveValide(mob.getPosX(),mob.getPosY(), ((Monster) mob).doAction( hero.getPosX(),hero.getPosY()))){
					if(Math.abs(mob.getPosX() -  hero.getPosX()) > 1 || Math.abs(mob.getPosY()-hero.getPosY())> 1 ){
						mob.move(((Monster) mob).doAction( hero.getPosX(),hero.getPosY()));
						Integer nextPosX = listTerrain[i][j].getCreature().getPosX();
						Integer nextPosY = listTerrain[i][j].getCreature().getPosY();
						listTerrain[nextPosX][nextPosY].setCreature(listTerrain[i][j].getCreature());
						listTerrain[i][j].setCreature(null);
					}  
					else{
						mob.attack(hero);
					}
				}
			}
	}


	@Override
	public WorldEntity[][] getListTerrain() {
		return listTerrain;
	}

	public Creatures[] getListHero() {
		return listHero;
	}

	@Override
	public void setListTerrain(WorldEntity[][] listTerrain) {
		// TODO Auto-generated method stub
		
	}
}
