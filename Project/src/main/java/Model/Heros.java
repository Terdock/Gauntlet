package Model;

public abstract class Heros extends Creatures{
	private String playerName;
	private Integer step = 30;
	private Integer force = 0;
	private Integer defense = 0;
	private Integer direction = 0;
	private Integer speed = 0;
	private Integer power = 0;
	private Integer dexterity = 0;

	public Heros(Integer posX, Integer posY) {
		super(posX,posY);
	}
	
	public void move(){
		
	}
	
	public abstract Integer attack();
	public abstract void Distanc_Attack();
	public abstract void Special_Attack();
	
	public void setHp(Integer dommage){
		this.hp = hp - (dommage-defense);
		if(hp <= 0){
			hp = 0;
			setLife(false);
		}
}
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
