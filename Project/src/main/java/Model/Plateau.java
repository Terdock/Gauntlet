package Model;

public class Plateau implements IPlateau {
	private Integer nombreLigne;
	private Integer nombreColonne;
	private final static Integer nombreLigneArene = 23;
	private final static Integer nombreColonneArene = 19;
	private Integer numberMap;
	private IMap map;
	private PlateauObject[][] listTerrain;
	private PlateauObject[][] listTerrain2;
	private Heros[] listHeros;
	private Creatures[] listMonster;
	private Integer playerNumber;
	
	public void setListTerrain(PlateauObject[][] listTerrain) {
		this.listTerrain = listTerrain;
	}

	public Plateau(Integer nombreLigne, Integer nombreColonne,Integer numberMap, Integer playerNumber) {
		this.nombreLigne = nombreLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
		this.playerNumber = playerNumber;
		this.listTerrain = new PlateauObject[nombreColonne][nombreLigne];
		this.listTerrain2 = new PlateauObject[nombreColonneArene][nombreLigneArene];
		}	
	


	public void Initialisation(Integer nombreLigne,Integer nombreColonne, String mode,String[][] playerRegister){
		this.map = new Map(this,nombreLigne, nombreColonne,numberMap);
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
		for (Creatures player : listHeros ){
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
		this.listHeros = new Heros[playerNumber];
		for (Integer i = 0; i < playerNumber; i++ ){
			if(playerRegister[i][1] == "Sorcier"){
				listHeros[i] = new Wizzard(3,4);
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Guerrier"){
				listHeros[i] = new Warrior(3,3);
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if( playerRegister[i][1] == "Nain"){
				listHeros[i] = new Dwarf(4,3);
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Elfe"){
				listHeros[i] = new Elf(4,4);
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}
		}
	}
	
	public void checkAttackMonster(){
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
		if(!(mob == null) && !(mob.equals(heros) && mob.isLife())){
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
	
	public void attacHeros(Integer player){
		Heros heros = listHeros[player];
		Integer[][] posHerosDirection = {{heros.getPosX(), heros.getPosY()-1},{heros.getPosX()+1, heros.getPosY()},
										 {heros.getPosX(), heros.getPosY()+1},{heros.getPosX()-1, heros.getPosY()}};
		for(Integer direction = 0; direction < 4; direction++){
			if (heros.getDirection().equals(direction)){
				heros.rangeAttack(listTerrain, posHerosDirection[direction][0],posHerosDirection[direction][1], direction, numberMap);
			}
		}
	
/*		PlateauObject[] creaturesAround = {listTerrain[heros.getPosX()][heros.getPosY()-1], 
									   	   listTerrain[heros.getPosX()+1][heros.getPosY()],
									       listTerrain[heros.getPosX()][heros.getPosY()+1],
									       listTerrain[heros.getPosX()-1][heros.getPosY()]};
		for(Integer direction = 0; direction < 4; direction++){
			if (heros.getDirection().equals(direction)){
				if (!(creaturesAround[direction].getCreature() == null) && 
						((Monster)creaturesAround[direction].getCreature()).nameType().equals("Monster")){
					heros.attack(creaturesAround[direction].getCreature());
					if (!creaturesAround[direction].getCreature().isLife()){
						creaturesAround[direction].setObject(((Creatures) creaturesAround[direction].getCreature()).getObject());
						creaturesAround[direction].setDead(creaturesAround[direction].getCreature());
						creaturesAround[direction].setCreature(null);
					}
				}else{
					//heros.rangeAttack();
				}
			}
		}*/
		
	}


	@Override
	public WorldEntity[][] getListTerrain() {
		return listTerrain;
	}

	
	public Heros[] getListHeros() {
		return listHeros;
	}

	@Override
	public void setListTerrain(WorldEntity[][] listTerrain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openDoor(Integer posX,Integer posY) {
		listTerrain[posX][posY] = map.newSol(posX,posY);
		
	}
}
