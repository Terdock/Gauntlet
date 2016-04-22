package Model;

public abstract class Creatures extends WorldEntity {
	private Integer pas = 30;
	private boolean life = true;
	protected Integer hp;
	private Integer level;
	private Integer direction = 0;
    private Integer moveContinue = 0;
    private Integer step = 30;


	public Creatures(Integer posX,Integer posY) {
		super(posX,posY);
		hp = 100;
	}
	
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
	
	public void gestionImage(Integer action){
		if(direction == action)
			if(moveContinue == 2){
				moveContinue = 1;
			}
			else{
				moveContinue++;
			}
		else{
			setDirection(action);
		}
	}
		

    
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
	
	public abstract void Distanc_Attack();
	public abstract void Special_Attack();
	public abstract Integer attack();


	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
		if(!life){
			setVisible(false);
		}
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

