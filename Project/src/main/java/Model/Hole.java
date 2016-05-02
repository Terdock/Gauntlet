package Model;

import java.util.ArrayList;

public class Hole extends PlateauObject {
	
	public Hole(Integer posX, Integer posY,boolean passable, boolean weaponPassable) {
		super(posX, posY, passable, weaponPassable);
	}
	
	public String name(){
		return this.getClass().getName();
	}

	public void tomber(AbstractModel game,ArrayList<Heros> listHero){
		for( Heros player : listHero){
			if(getPosX().equals(player.getPosX()) & getPosY().equals(player.getPosY())){
				player.setPosX(getPosX());
				player.setPosX(getPosX());
			
			}	
		}
	}
}
