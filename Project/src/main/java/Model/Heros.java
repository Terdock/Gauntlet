package Model;

public abstract class Heros extends Creatures{
	private String playerName;
	private Integer force = 15;
	private Integer direction = 0;
	private Integer power = 10;
	private Integer dexterity = 0;
	private Integer hp = 100;
	private boolean pasDeGeant = true; 

	public Heros(Integer posX, Integer posY) {
		super(posX,posY,100, 5);
		}

	
	public void doAction(String action, IPlateau plateau, WorldEntity[][] listTerrain){
		if ((plateau.isMoveValide(getPosX(), getPosY(), action)|| pasDeGeant) ){
			if( getPosX() > 0 && getPosY() > 0 && getPosX()   <  listTerrain[0].length - 1 && getPosY() < listTerrain.length - 1){
				Integer previousPosX = getPosX(); Integer previousPosY = getPosY();
				move(action);
				Integer nextPosX = getPosX();Integer nextPosY = getPosY();
				((PlateauObject) listTerrain[nextPosX][nextPosY]).setCreature(((PlateauObject) listTerrain[previousPosX][previousPosY]).getCreature());
				((PlateauObject) listTerrain[previousPosX][previousPosY]).setCreature(null);
			}
		}
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
		return "Hero";
	}
	
	

}
