package Model;

public abstract class PlateauObject extends WorldEntity {
	
	private boolean passable;
	private Creatures creature;
	private WorldObject object;
	private Creatures dead;
	private Weapon weapon;

	public PlateauObject(Integer posX, Integer posY, boolean passable) {
		super(posX, posY);
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
	
	public Creatures getDead() {
		return dead;
	}

	public void setDead(Creatures dead) {
		this.dead = dead;
	}

	public WorldObject getObject() {
		return object;
	}

	public void setObject(WorldObject object) {
		this.object = object;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;

	}
	
	
	
	

	
}
