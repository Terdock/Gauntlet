package Model;

public abstract class Creatures extends WorldEntity {
	private boolean life = true;
	private Integer hp = 100;
	private Integer level;
	private Integer direction = 0;
    private Integer moveContinue = 0;
    private Integer step =1;
    public boolean isVisible() {
		return Visible;
	}



	public void setVisible(boolean visible) {
		Visible = visible;
	}

	private boolean Visible;


	public Creatures(Integer posX,Integer posY) {
		super(posX,posY);
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
	public abstract void attack(Creatures creature);

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
		if(!life){
			
		}
	}




	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer dommage) {
		this.hp = hp - dommage;
		if(hp <= 0){
			hp = 0;
			setLife(false);
		}
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

}

