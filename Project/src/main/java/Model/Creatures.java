package Model;

public abstract class Creatures extends WorldEntity {
	private int pas = 30;
	private boolean life = true;
	private int hp;
	private int level;


	public Creatures(int posX,int posY) {
		super(posX,posY);
	}
	
	public abstract void Distanc_Attack();
	public abstract void Special_Attack();
	public abstract void move();
	public abstract void attack();


	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPas() {
		return pas;
	}

	public void setPas(int pas) {
		this.pas = pas;
	}
}

