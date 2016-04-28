package Model;

public abstract class PlateauObject extends WorldEntity {
	
	private boolean passable;
	private Creatures creature;
	

	private boolean dead;

	public PlateauObject(Integer posX, Integer posY, boolean passable) {
		super(posX, posY);
		this.dead = false;
		this.passable = passable;
	}

	boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		this.passable = passable;
	}
	
	public String nameType(){
		return "Terrain";
	}

	public Creatures getCreature() {
		return creature;
	}

	public void setCreature(Creatures creature) {
		this.creature = creature;
		if(creature == null){
			setPassable(true);	
		}
		else{
			setPassable(false);
		}
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
private WorldObject Objet;
	
	
	public WorldObject getObjet() {
		return Objet;
	}

	public void setwObject(WorldObject Objet) {
		this.Objet = Objet;
	}

	
	
	

	

	
}
