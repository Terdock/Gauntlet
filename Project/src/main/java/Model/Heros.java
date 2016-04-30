package Model;

public abstract class Heros extends Creatures{
	
	private String playerName;
	private Integer force = 15;
	private Integer direction = 0;
	private Integer power = 10;
	private Integer dexterity = 0;
	private Integer hp = 100;
	private Integer score = 0;
	private boolean pasDeGeant = false;
	protected Weapon weapon;

	public Heros(Integer posX, Integer posY) {
		super(posX,posY,100, 5,null);
	}
	
	public void doAction(String action, IPlateau plateau, WorldEntity[][] listTerrain){
		if ((plateau.isMoveValide(getPosX(), getPosY(), action)|| pasDeGeant) ){
			Integer previousPosX = getPosX(); Integer previousPosY = getPosY();
			move(action);
			Integer nextPosX = getPosX();Integer nextPosY = getPosY();
			PlateauObject groundPrevious = ((PlateauObject) listTerrain[previousPosX][previousPosY]);
			PlateauObject groundNext = ((PlateauObject) listTerrain[nextPosX][nextPosY]);
			groundNext.setCreature(groundPrevious.getCreature());
			groundPrevious.setCreature(null);
			if(!(groundNext.getObject() == null)){
				takeObjet(groundNext.getObject());
				groundNext.setObject(null);
			}
		}
	}
	
	private void takeObjet( WorldObject objet) {
		objet.useObject();
	}
	
	public abstract void specialAttack();

	public void attack(Creatures creature){
		creature.receiveAttack(force*power, creature.getDefense());
		setScore(getScore() + force*power - creature.getDefense());
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public String nameType(){
		return "Heros";
	}
	
	public void rangeAttack(PlateauObject[][] listTerrain, Integer posX, Integer posY, Integer direction,Integer numberMap) {
		weapon = new Weapon(name(), direction);
		System.out.println("weapon");
		if(direction.equals(0)){
			Integer i = 0;
			while((listTerrain[posX][posY-i].getCreature() ==  null) && (listTerrain[posX][posY-i].isPassable())){
				listTerrain[posX][posY-i].setWeapon(null);
				i++;
				listTerrain[posX][posY-i].setWeapon(weapon);
				System.out.println(listTerrain[posX][posY-i]);
			}	
			if(!(listTerrain[posX][posY-i].getCreature() ==  null)){
				attack(listTerrain[posX][posY-i].getCreature());
				if( ! listTerrain[posX][posY-i].getCreature().isLife()){
					if(! (listTerrain[posX][posY-i].getCreature().getObject() ==null)){
						listTerrain[posX][posY-i].setObject((listTerrain[posX][posY-i].getCreature()).getObject());
					}
					listTerrain[posX][posY-i].setCreature(null);
				}
				listTerrain[posX][posY-i].setWeapon(null);
			}
			else if(!listTerrain[posX][posY-i].isPassable()){
				listTerrain[posX][posY-i].setWeapon(null);
			}
		}
		if(direction.equals(1)){
			Integer i = 0;
			while((listTerrain[posX+i][posY].getCreature() ==  null) && (listTerrain[posX+i][posY].isPassable())){
				listTerrain[posX+i][posY].setWeapon(null);
				i++;
				listTerrain[posX+i][posY].setWeapon(weapon);
			}	
			if(listTerrain[posX+i][posY].getCreature() !=  null){
				attack(listTerrain[posX+i][posY].getCreature());
				if( ! listTerrain[posX+i][posY].getCreature().isLife() ){
					if(!(listTerrain[posX+i][posY].getCreature().getObject() == null)){
						listTerrain[posX+i][posY].setObject((listTerrain[posX+i][posY].getCreature()).getObject());
					}
					listTerrain[posX+i][posY].setCreature(null);
				}
				listTerrain[posX+i][posY].setWeapon(null);
			}
			else if(!listTerrain[posX+i][posY].isPassable()){
				listTerrain[posX+i][posY].setWeapon(null);
			}
		}
		if(direction.equals(2)){
			Integer i = 0;
			while((listTerrain[posX][posY+i].getCreature() ==  null) && (listTerrain[posX][posY+i].isPassable())){
				listTerrain[posX][posY+i].setWeapon(null);
				i++;
				listTerrain[posX][posY+i].setWeapon(weapon);
			}	
			if((listTerrain[posX][posY+i].getCreature() !=  null)){
				attack(listTerrain[posX][posY+i].getCreature());
				if( ! listTerrain[posX][posY+i].getCreature().isLife()){
					if(! (listTerrain[posX][posY+i].getCreature().getObject() ==null)){
						listTerrain[posX][posY+i].setObject((listTerrain[posX][posY+i].getCreature()).getObject());
					}
					listTerrain[posX][posY+i].setCreature(null);
				}
				listTerrain[posX][posY+i].setWeapon(null);
			}
			else if(!listTerrain[posX][posY+i].isPassable()){
				listTerrain[posX][posY+i].setWeapon(null);
			}
		}
		if(direction.equals(3)){
			Integer i = 0;
			while((listTerrain[posX-i][posY].getCreature() ==  null) && (listTerrain[posX-i][posY].isPassable())){
				listTerrain[posX-i][posY].setWeapon(null);
				i++;
				listTerrain[posX-i][posY].setWeapon(weapon);
			}	
			if(!(listTerrain[posX-i][posY].getCreature() ==  null)){
				attack(listTerrain[posX-i][posY].getCreature());
				if( ! listTerrain[posX-i][posY].getCreature().isLife()){
					if(! (listTerrain[posX-i][posY].getCreature().getObject() ==null)){
						listTerrain[posX-i][posY].setObject((listTerrain[posX-i][posY].getCreature()).getObject());
					}
					listTerrain[posX-i][posY].setCreature(null);
				}
				listTerrain[posX-i][posY].setWeapon(null);
			}
			else if(!listTerrain[posX-i][posY].isPassable()){
				listTerrain[posX-i][posY].setWeapon(null);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
