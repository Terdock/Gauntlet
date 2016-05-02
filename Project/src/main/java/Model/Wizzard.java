package Model;


public class Wizzard extends Heros {
	public Wizzard(Integer posX, Integer posY) {
		super(posX,posY);
	}
	
	public void attack(PlateauObject[][] listTerrain, Integer direction) {
		weapon = new Weapon(name(), direction, this);
		Integer[][] posHerosDirection = {{this.getPosX(), this.getPosY()-1},{this.getPosX()+1, this.getPosY()},
		 			 					 {this.getPosX(), this.getPosY()+1},{this.getPosX()-1, this.getPosY()}};
		listTerrain[posHerosDirection[direction][0]][posHerosDirection[direction][1]].setWeapon(weapon);
	}
	
	public void specialAttack() {
		
	}

	public String name() {
		return "Wizzard";
	}


}
