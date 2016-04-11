package Model;

import Model.Creatures;

public abstract class Hero extends Creatures {
	private String playerName;
	private int force = 0;
	private int defense = 0;
	private int direction = 0;
	private int speed = 0;
	private int magie = 0;
	private int power = 0;
	private int dexterity = 0;

	public Hero(int posX, int posY) {
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
	