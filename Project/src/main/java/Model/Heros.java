package Model;

public abstract class Heros extends Creatures{
	private String playerName;
	private Integer force = 0;
	private Integer defense = 0;
	private Integer direction = 0;
	private Integer speed = 0;
	private Integer magie = 0;
	private Integer power = 0;
	private Integer dexterity = 0;

	public Heros(Integer posX, Integer posY) {
		super(posX,posY);
	}
	
	public  void move(){
		//From Keyboard move
		//if(actionUp){
		//		setPosY(getPosY + step);
		//}
		//else if(actionDown){
		//		setPosY(getPosY - step);
		//}
		//else if(actionRight){
		//		setPosX(getPosX + step);
		//}
		//else if(actionLeft){
		//		setPosX(getPosX - step);
		//}
	}
	
	public abstract void attack();
	public abstract void Distanc_Attack();
	public abstract void Special_Attack();
	
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
