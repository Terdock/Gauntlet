package Model;

public class Elf extends Heros {
	
	public Elf(Integer posX, Integer posY) {
		super(posX,posY);
	}
	
	public void attack(PlateauObject[][] listTerrain, Integer direction) {
		weapon = new Weapon(name(), direction, this);
		Integer[][] posHerosDirection = {{this.getPosX(), this.getPosY()-1},{this.getPosX()+1, this.getPosY()},
		 			 					 {this.getPosX(), this.getPosY()+1},{this.getPosX()-1, this.getPosY()}};
		listTerrain[posHerosDirection[direction][0]][posHerosDirection[direction][1]].setWeapon(weapon);
	}

	public String name() {
		return "Elf";
	}
}