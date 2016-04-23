package Model;

import java.util.ArrayList;

public abstract class Heros extends Creatures{
	private String playerName;
	private Integer step = 30;
	private Integer force = 0;
	private Integer defense = 5;
	private Integer direction = 0;
	private Integer speed = 0;
	private Integer power = 0;
	private Integer dexterity = 0;

	public Heros(Integer posX, Integer posY) {
		super(posX,posY);
	}
	
	public void createHero(String[][] playerRegister) {
		List_Hero = convertListHero(playerRegister);
		for(Heros hero : List_Hero)
			listHero.add(hero);
		notifyObserver(listHero);
	}
	

	
	public ArrayList<Heros> convertListHero(String[][] playerRegister){
		for (Integer i = 0; i < playerRegister.length; i++ ){
			if(playerRegister[i][1] == "Sorcier"){
				Wizzard W = new Wizzard(1,1);
				W.setPlayerName(playerRegister[i][0]);
				List_Hero.add(W);
			}else if(playerRegister[i][1] == "Guerrier"){
				Warrior W = new Warrior(60,60);
				W.setPlayerName(playerRegister[i][0]);
				List_Hero.add(W);
			}else if( playerRegister[i][1] == "Nain"){
				Dwarf D = new Dwarf(1,1);
				D.setPlayerName(playerRegister[i][0]);
				List_Hero.add(D);
			}else if(playerRegister[i][1] == "Elfe"){
				Elf E = new Elf(1,1);
				E.setPlayerName(playerRegister[i][0]);
				List_Hero.add(E);
			}
		}
		return List_Hero;
	}
	
	
	public void move(){
		
	}
	
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

	public void receiveAttack(Integer attack) {
		if(attack-defense>0)
			setHp(attack-defense);
	}
	
	

}
