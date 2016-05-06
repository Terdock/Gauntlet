package Model;

public class Plateau implements IPlateau {
	private Integer nombreLigne;
	private Integer nombreColonne;
	private Integer nombreLigneArene = 20;
	private Integer nombreColonneArene = 24;
	private Integer nombreLigneSurvivor;
	private Integer nombreColonneSurvivor;
	private Integer numberMap;
	private IMap map;
	private PlateauObject[][] listTerrain;
	private Heros[] listHeros;
	private Creatures[] listMonster;
	private Integer playerNumber;

	public Plateau(Integer nombreLigne, Integer nombreColonne, Integer numberMap, Integer playerNumber) {
		this.nombreLigne = nombreLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
		this.playerNumber = playerNumber;
	}	

	public void Initialisation(String mode, String[][] playerRegister){
		this.map = new Map(this, nombreLigne, nombreColonne, numberMap);
		if (mode.equals("Mode Quête")){
			this.listTerrain = new PlateauObject[nombreColonne][nombreLigne];
			this.listTerrain = map.createListTerrain(nombreLigne,nombreColonne,listTerrain);
			listMonster = map.getListMonster();
			createHero(playerRegister,nombreLigne,nombreColonne);
			for (Creatures mob: listMonster){
				listTerrain[mob.getPosX()][mob.getPosY()].setCreature(mob);
			}
		}else if(mode.equals("Mode Arène")){
			this.listTerrain = new PlateauObject[nombreColonneArene][nombreLigneArene];
			this.listTerrain = map.createListTerrainArene(nombreLigneArene,nombreColonneArene,listTerrain);
			createHero(playerRegister,nombreLigneArene,nombreColonneArene);
		}else if(mode.equals("Mode Survivor")){
			this.listTerrain = new PlateauObject[nombreColonneSurvivor][nombreLigneSurvivor];
			this.listTerrain = map.createListTerrainArene(nombreLigneSurvivor,nombreColonneSurvivor,listTerrain);
			createHero(playerRegister,nombreLigneSurvivor,nombreColonneSurvivor);
			battallons(0);
		}
		
		for (Creatures player : listHeros ){              
				listTerrain[player.getPosX()][player.getPosY()].setCreature(player); 
		}
	}
	
	
	public void Initialisation(String mode, Creatures[] listHeros){
		this.map = new Map(this, nombreLigne, nombreColonne, numberMap);
		this.listHeros = (Heros[]) listHeros;
		if (mode.equals("Mode Quête")){
			this.listTerrain = new PlateauObject[nombreColonne][nombreLigne];
			this.listTerrain = map.createListTerrain(nombreLigne,nombreColonne,listTerrain);
			listMonster = map.getListMonster();
			for (Creatures mob: listMonster){
				listTerrain[mob.getPosX()][mob.getPosY()].setCreature(mob);
			}
		}else if(mode.equals("Mode Arène")){
			this.listTerrain = new PlateauObject[nombreColonneArene][nombreLigneArene];
			this.listTerrain = map.createListTerrainArene(nombreLigneArene,nombreColonneArene,listTerrain);
		}else if(mode.equals("Mode Survivor")){
			this.listTerrain = new PlateauObject[nombreColonneSurvivor][nombreLigneSurvivor];
			this.listTerrain = map.createListTerrainArene(nombreLigneSurvivor,nombreColonneSurvivor,listTerrain);
			battallons(0);
		}
		for (Creatures player : listHeros ){
			listTerrain[player.getPosX()][player.getPosY()].setCreature(player); 
		}
	}

	public void battallons(Integer numberOfBattallons){
		map.createBattallons(numberOfBattallons,nombreColonneArene, nombreLigneArene);
		listMonster = map.getListMonster();
		for (Creatures mob: listMonster){
			if (listTerrain[mob.getPosX()][mob.getPosY()].getCreature() == null){
				listTerrain[mob.getPosX()][mob.getPosY()].setCreature(mob);
			}
		}
		
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

	
	public void createHero(String[][] playerRegister,Integer nombreLigne,Integer nombreColonne){
		this.listHeros = new Heros[playerNumber];
		for (Integer i = 0; i < playerNumber; i++ ){
			if(playerRegister[i][1] == "Sorcier"){
				listHeros[i] = new Wizzard(3+i*(nombreColonne-8),4+i*(nombreLigne-8));
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Guerrier"){
				listHeros[i] = new Warrior(3+i*(nombreColonne-7),3+i*(nombreLigne-7));
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if( playerRegister[i][1] == "Nain"){
				listHeros[i] = new Dwarf(4+i*(nombreColonne-8),3+i*(nombreLigne-7));
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Elfe"){
				listHeros[i] = new Elf(4+i*(nombreColonne-8),4+i*(nombreLigne-8));
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}
		}
	}
	
	public void checkAttackMonster(Integer nombreColonne,Integer nombreLigne){
		for(Heros heros : listHeros){
			for (Integer j =  0; j < 10; j++){
				for(Integer i = 0; i < 10;i++){
					Integer a,b,c,d;
					a = heros.getPosX()-i; b = heros.getPosY()-j; c = heros.getPosX()+i; d = heros.getPosY()+j;
					if(a > 0 && b > 0 && a < nombreColonne &&  b < nombreLigne)
						isAttack(((PlateauObject) listTerrain[a][b]).getCreature(),heros,a,b);
					if(c > 0 && b > 0 && c < nombreColonne &&  b < nombreLigne)
						isAttack(((PlateauObject) listTerrain[c][b]).getCreature(),heros,c,b);
					if(a > 0 && d > 0 && a < nombreColonne &&  d < nombreLigne)
						isAttack(((PlateauObject) listTerrain[a][d]).getCreature(),heros,a,d);
					if(c > 0 && d > 0 && c < nombreColonne &&  d < nombreLigne)
						isAttack(((PlateauObject) listTerrain[c][d]).getCreature(),heros,c,d);
				}
			}
			if ((!heros.isLife()) && listTerrain[heros.getPosX()][heros.getPosY()].getCreature().nameType().equals("Heros")){
				listTerrain[heros.getPosX()][heros.getPosY()].setCreature(null);
			}
		}	
	}
	
	public void isAttack(Creatures mob, Heros heros, Integer i, Integer j){	
		if(!(mob == null) && mob.getImAEnemy() && (mob.isLife())){
			Integer posX = mob.getPosX(), posY = mob.getPosY();
			String action = ((Monster) mob).doAction(heros.getPosX(),heros.getPosY());
			if(isMoveValide(posX, posY, action)){
					mob.move(((Monster) mob).doAction(heros.getPosX(),heros.getPosY()));
					Integer nextPosX = listTerrain[i][j].getCreature().getPosX();
					Integer nextPosY = listTerrain[i][j].getCreature().getPosY();
					listTerrain[nextPosX][nextPosY].setCreature(listTerrain[i][j].getCreature());
					listTerrain[i][j].setCreature(null);	
			}
			if((Math.abs(mob.getPosX()-heros.getPosX()) == 0) && (Math.abs(mob.getPosY()-heros.getPosY()) == 1)
					||((Math.abs(mob.getPosY()-heros.getPosY()) == 0) && (Math.abs(mob.getPosX()-heros.getPosX()) == 1))){
				directionMonster(mob, heros);
				mob.attack(heros);
			}
		}
	}
	
	private void directionMonster(Creatures mob, Heros heros){
		Integer differenceX = mob.getPosX()-heros.getPosX();
		if(differenceX.equals(-1)){
			mob.setDirection(1);
		}else if (differenceX.equals(1)){
			mob.setDirection(3);
		}
		Integer differenceY = mob.getPosY()-heros.getPosY();
		if(differenceY.equals(-1)){
			mob.setDirection(2);
		}else if(differenceY.equals(1)){
			mob.setDirection(0);
		}
	}

	public WorldEntity[][] getListTerrain() {
		return listTerrain;
	}

	
	public Heros[] getListHeros() {
		return listHeros;
	}

	public void setListTerrain(WorldEntity[][] listTerrain) {
		
	}
	
	public void setListTerrain(PlateauObject[][] listTerrain) {
		this.listTerrain = listTerrain;
	}

	public void openDoor(Integer posX,Integer posY) {
		listTerrain[posX][posY] = map.newSol(posX,posY);	
	}
	
	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public void setNombreLigneSurvivor(Integer nombreLigneSurvivor) {
		this.nombreLigneSurvivor = nombreLigneSurvivor;
	}

	public void setNombreColonneSurvivor(Integer nombreColonneSurvivor) {
		this.nombreColonneSurvivor = nombreColonneSurvivor;
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
	
	public Integer getNombrelignearene() {
		return nombreLigneArene;
	}


	public Integer getNombrecolonnearene() {
		return nombreColonneArene;
	}

	public Integer getNumberMap() {
		return numberMap;
	}

	public void setNumberMap(Integer numberMap) {
		this.numberMap = numberMap;
	}
	
	public Creatures[] getListMonster() {
		return listMonster;
	}

	public void setListMonster(Creatures[] listMonster) {
		this.listMonster = listMonster;
	}
	
	

}
