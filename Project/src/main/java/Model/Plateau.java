package Model;

public class Plateau implements IPlateau {
	private Integer numberLine;
	private Integer numberColumn;
	private Integer numberLineMode;
	private Integer numberColumnMode;
	private Integer numberMap;
	private IMap map;
	private PlateauObject[][] listTerrain;
	private Creatures[] listHeros;
	private Creatures[] listMonster;

	public Plateau(Integer numberLine, Integer numberColumn, Integer numberMap) {
		this.numberLine = numberLine;
		this.numberColumn = numberColumn;
		this.numberMap = numberMap;
	}	
	
	public void Initialisation(String mode, Creatures[] listHeros){
		this.map = new Map(this, numberLine, numberColumn, numberMap);
		if (mode.equals("Mode Quête")){
			this.listTerrain = new PlateauObject[numberColumn][numberLine];
			this.listTerrain = map.createListTerrain(numberLine,numberColumn,listTerrain);
			listMonster = map.getListMonster();
			for (Creatures mob: listMonster){
				listTerrain[mob.getPosX()][mob.getPosY()].setCreature(mob);
			}
		}else if(mode.equals("Mode Arène") || (mode.equals("Mode Survivor"))){
			this.listTerrain = new PlateauObject[numberColumnMode][numberLineMode];
			this.listTerrain = map.createListTerrainArene(numberLineMode,numberColumnMode,listTerrain);
			if(mode.equals("Mode Survivor")){
				battallons(0);
			}
		}
		for (Creatures player : listHeros){
			listTerrain[player.getPosX()][player.getPosY()].setCreature(player); 
		}
	}

	public void battallons(Integer numberOfBattallons){
		map.createBattallons(numberOfBattallons,numberColumnMode, numberLineMode);
		listMonster = map.getListMonster();
		for (Creatures mob: listMonster){
			if (mob.getPosX() > 0 && mob.getPosY() > 0 && mob.getPosX()< numberColumnMode-1 && mob.getPosY() < numberLineMode-1){
				if(listTerrain[mob.getPosX()][mob.getPosY()].getClass().getName().equals("Model.Sol") 
						&& listTerrain[mob.getPosX()][mob.getPosY()].getCreature() == null ){
					listTerrain[mob.getPosX()][mob.getPosY()].setCreature(mob);
				}
				else{
					mob.setLife(false);	
				}
			}
			else{
				mob.setLife(false);
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

	
	
	public void checkAttackMonster(Integer nombreColonne,Integer nombreLigne){
		for(Heros heros : (Heros[])listHeros){
			if(heros.isLife()){
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
			}}
		}	
	}
	
	public void isAttack(Creatures mob, Heros heros, Integer i, Integer j){	
		if(((Heros) heros).isVisibility() && !(mob == null) && mob.getImAEnemy() && (mob.isLife())){
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

	public void setNumberLineMode(Integer numberLineMode) {
		this.numberLineMode = numberLineMode;
	}

	public void setNumberColumnMode(Integer numberColumnMode) {
		this.numberColumnMode = numberColumnMode;
	}

	public void setListHeros(Creatures[] listHeros) {
		this.listHeros = listHeros;
	}
	
	
	
	

}
