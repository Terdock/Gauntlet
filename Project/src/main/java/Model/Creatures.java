package Model;

public abstract class Creatures extends WorldEntity {
	private Integer pas = 30;
	private boolean life = true;
	protected Integer hp;
	private Integer level;


	public Creatures(Integer posX,Integer posY) {
		super(posX,posY);
	}
	
	public abstract void Distanc_Attack();
	public abstract void Special_Attack();
	public abstract Integer attack();


	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

	public Integer getHp() {
		return hp;
	}

	public abstract void setHp(Integer dommage) ;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getPas() {
		return pas;
	}

	public void setPas(Integer pas) {
		this.pas = pas;
	}


}

