package Model;

public class Warrior extends Heros{
	
	public Warrior(Integer posX, Integer posY) {
		super(posX,posY);
	}

	public void attack(PlateauObject[][] listTerrain, Integer direction) {
		Integer[][] posHerosDirection = {{this.getPosX(), this.getPosY()-1, 0},{this.getPosX()+1, this.getPosY(), 1},
					 					 {this.getPosX(), this.getPosY()+1, 2},{this.getPosX()-1, this.getPosY(), 3}};
		for (Integer[] elem : posHerosDirection){
			weapon = new Weapon(name(), elem[2], this);
			listTerrain[elem[0]][elem[1]].setWeapon(weapon);
		}
	}

	public String name() {
		return "Warrior";
	}

}
