package Model;

public abstract class Heros extends Creatures{
	private String playerName;
	private Integer force = 15;
	private Integer direction = 0;
	private Integer power = 10;
	private Integer dexterity = 0;
	private Integer hp = 100;
	private boolean pasDeGeant = false; 

	public Heros(Integer posX, Integer posY) {
		super(posX,posY,100, 5,null);
		}

	
	public void doAction(String action, IPlateau plateau, WorldEntity[][] listTerrain){
		if ((plateau.isMoveValide(getPosX(), getPosY(), action)|| pasDeGeant) ){
				Integer previousPosX = getPosX(); Integer previousPosY = getPosY();
				move(action);
				Integer nextPosX = getPosX();Integer nextPosY = getPosY();
				((PlateauObject) listTerrain[nextPosX][nextPosY]).setCreature(((PlateauObject) listTerrain[previousPosX][previousPosY]).getCreature());
				((PlateauObject) listTerrain[previousPosX][previousPosY]).setCreature(null);
				if(((PlateauObject) listTerrain[nextPosX][nextPosY]).getObject() != null ){
					takeObjet(((PlateauObject) listTerrain[nextPosX][nextPosY]).getObject());
					((PlateauObject) listTerrain[nextPosX][nextPosY]).setObject(null);
				}
		}
	}
	

	private void takeObjet( WorldObject objet) {
		objet.useObject();
		
	}


	public abstract void Distanc_Attack();
	public abstract void Special_Attack();
	

	public void attack(Creatures creature){
		creature.receiveAttack(force*power, creature.getDefense());
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
	
	

}
