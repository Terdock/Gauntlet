package Model;

public abstract class Hero extends Creatures {
	private String playerName;
	private Integer force = 0;
	private Integer defense = 0;
	private Integer direction = 0;
	private Integer speed = 0;
	private Integer magie = 0;
	private Integer power = 0;
	private Integer dexterity = 0;

	public Hero(Integer posX, Integer posY) {
		super(posX,posY);
	}
	
	public  void move(){
		
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
	