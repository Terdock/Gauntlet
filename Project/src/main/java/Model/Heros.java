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
		for(Integer directionAttack = 0; directionAttack < 4; directionAttack++){
			if(direction.equals(directionAttack)){
				Integer nextPos = 0;
				PlateauObject ground = dependingDirection(listTerrain, directionAttack, nextPos, posX, posY);
				while((ground.getCreature() ==  null) && (ground.isPassable())){
					ground.setWeapon(null);
					nextPos++;
					ground = dependingDirection(listTerrain, directionAttack, nextPos, posX, posY);
					ground.setWeapon(weapon);
				}
				if(!(ground.getCreature() ==  null)){
					attack(ground.getCreature());
					if(!ground.getCreature().isLife()){
						if(!(ground.getCreature().getObject() == null)){
							ground.setObject((ground.getCreature()).getObject());
						}
						ground.setCreature(null);
					}
					ground.setWeapon(null);
				}
				else if(!ground.isPassable()){
					ground.setWeapon(null);
				}
			}
		}
	}
	
	private PlateauObject dependingDirection(PlateauObject[][] listTerrain, Integer directionAttack, Integer nextPos, Integer posX, Integer posY){
		PlateauObject ground = null;
		if (directionAttack.equals(0)){
			ground = listTerrain[posX][posY - nextPos];
		}else if (directionAttack.equals(1)){
			ground = listTerrain[posX + nextPos][posY];
		}else if (directionAttack.equals(2)){
			ground = listTerrain[posX][posY + nextPos];
		}else if (directionAttack.equals(3)){
			ground = listTerrain[posX - nextPos][posY];
		}
		return ground; 
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
