package Model;

public abstract class Creatures extends WorldEntity {
	protected boolean life = true;
	protected Integer hp;
	private Integer defense;
	private Integer level;
	private Integer direction = 2;
    private Integer moveContinue = 0;
    private Integer step = 1;
	private boolean Visible;
    private WorldObject object;
	private boolean imAEnemy; 


	public Creatures(Integer posX,Integer posY, Integer hp, Integer defense, WorldObject object, boolean imAEnemy) {
		super(posX,posY);
		this.hp = hp;
		this.defense = defense;
		this.object = object;
		this.imAEnemy = imAEnemy;
	}
	
	//Mouvement de toutes les créatures (Héros et Monstres) en fonction d'un paramètre
	//(action de l'utilisateur, action de l'IA)
	public  void move(String action){
		if(action.equals("Action Up")){
			setPosY(getPosY() - step);
			gestionImage(0);
		}else if(action.equals("Action Down")){
			setPosY(getPosY() + step);
			gestionImage(2);
		}else if(action.equals("Action Right")){
			setPosX(getPosX() + step);
			gestionImage(1);
		}else if(action.equals("Action Left")){
			setPosX(getPosX() - step);
			gestionImage(3);
		}
	}
	
	
	//Gestion de l'image pour simuler un déplacement des créatures
	public void gestionImage(Integer action){
		if(direction.equals(action)){
			if(moveContinue.equals(2)){
				moveContinue = 1;
			}
			else{
				moveContinue++;
			}
		}
		else{
			setDirection(action);
		}
	}
	
	//Les conséquences des attaques recus par les créatures
	public void receiveAttack(Integer attack, Integer defense) {
		if(attack-defense>0)
			setHp(attack-defense);
	}
	
	public abstract void attack(PlateauObject[][] listTerrain, Integer direction);
	public abstract void attack(Creatures creature);
	
	
	public Integer getMoveContinue() {
		return moveContinue;
	}

	public void setMoveContinue(Integer moveContinue) {
		this.moveContinue = moveContinue;
	}

	public Integer getDirection() {
		return direction;
	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}
	
	public Integer getHp() {
		return hp;
	}

	private void setHp(Integer dommage) {
		this.hp = hp - dommage;
		if(hp <= 0){
			hp = 0;
			setLife(false);
		}
	}
	
	public void setHp(boolean guerrir,Integer hp) {
		this.hp = hp;
	}
	
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}
	
	public WorldObject getObject() {
		return object;
	}

	public void setObject(WorldObject object) {
		this.object = object;
	}

	public boolean isVisible() {
		return Visible;
	}

	public void setVisible(boolean visible) {
		Visible = visible;
	}

	public Integer getDefense() {
		return defense;
	}

	public boolean getImAEnemy() {
		return imAEnemy;
	}
	
	public void setDefense(Integer defense) {
		this.defense = defense;
	}
	
	
}

