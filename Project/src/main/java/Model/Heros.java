package Model;

public abstract class Heros extends Creatures{
	
	private String playerName;
	private Integer direction = 0;
	private Integer power = 150;
	private Integer score = 0;
	private Integer pas = 0;
	private boolean pasDeGeant = false;
	protected Weapon weapon;
	private boolean visibility = true;

	public Heros(Integer posX, Integer posY) {
		super(posX,posY,10,5,null,false);
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
			}
				groundNext.setObject(null);
			if(!(getObject() == null)){
				if(pas.equals(40) || getObject().name().equals("KeyDoor") || getObject().name().equals("Health Potion") ){
					visibility = true;
					pasDeGeant = false;
					setStep(1);
					setObject(null);
					this.pas = 0;
				}
				else{
					this.pas+=1;
				}
			}
		}
	}
	
	private void takeObjet( WorldObject objet) {
		setObject(objet);
		objet.useObject(this);
	}
	
	public abstract void attack(PlateauObject[][] listTerrain, Integer direction);
	public abstract void specialAttack();

	public void attack(Creatures creature){
		creature.receiveAttack(power, creature.getDefense());
		setScore(getScore() + power - creature.getDefense());
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

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}


	
}
