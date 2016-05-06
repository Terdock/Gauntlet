package Model;

public abstract class Heros extends Creatures{
	
	private String playerName;
	private Integer force = 15;
	private Integer direction = 0;
	private Integer power = 10;
	private Integer score = 0;
	private boolean pasDeGeant = false;
	protected Weapon weapon;

	public Heros(Integer posX, Integer posY) {
		super(91,90,100,5,null,false);
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
	
	public abstract void attack(PlateauObject[][] listTerrain, Integer direction);
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
	
	public void setHp(Integer newHp, Potion potion){
		this.hp = newHp;
	}
	
	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public void setPasDeGeant(boolean pasDeGeant) {
		this.pasDeGeant = pasDeGeant;
	}

	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
}
