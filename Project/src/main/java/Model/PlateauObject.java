package Model;

public abstract class PlateauObject extends WorldEntity {
	
	private boolean passable;
	private Creatures creature;
<<<<<<< HEAD
	private WorldObject Objet;
	

	private boolean dead;
=======
	private WorldObject objet;
	private Creatures dead;
>>>>>>> refs/remotes/origin/master

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
<<<<<<< HEAD
	
	
	
=======

>>>>>>> refs/remotes/origin/master
	public WorldObject getObjet() {
		return objet;
	}

<<<<<<< HEAD
	public void setObjet(WorldObject Objet) {
		this.Objet = Objet;
=======
	public void setObjet(WorldObject objet) {
		this.objet = objet;
>>>>>>> refs/remotes/origin/master
	}

	
}
