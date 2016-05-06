package Model;

public class PlateauObject extends WorldEntity {
	
	private boolean passable;
	private boolean weaponPassable;
	private Creatures creature;
	private WorldObject object;
	private Creatures dead;
	private Weapon weapon;
	private String type;
	private Integer numberMap;

	public PlateauObject(Integer posX, Integer posY, boolean passable, boolean weaponPassable) {
		super(posX, posY);
		this.weaponPassable = weaponPassable;
		this.passable = passable;
	}
	
	public PlateauObject(Integer posX, Integer posY, boolean passable, boolean weaponPassable, String type, Integer numberMap){
		super(posX, posY);
		this.weaponPassable = weaponPassable;
		this.passable = passable;
		this.type = type;
		this.numberMap = numberMap;
	}
	
	public String nameType(){
		return "Terrain";
	}
	
	public String name(){
		return type + Integer.toString(numberMap);
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
	
	public boolean isPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		this.passable = passable;
	}

	public boolean isWeaponPassable() {
		return weaponPassable;
	}
	

	
}
