package Model;

import java.util.ArrayList;
import observer.Observable;

public class GauntletGame extends AbstractModel {
	
	private Integer numberMap; 
	private static Integer nombreLigne = 100;
	private static Integer nombreColonne = 100;
	IPlateau plateau;
	private WorldEntity[][] listTerrain = new WorldEntity[nombreLigne][nombreColonne];
	private String gameMode;
	private Integer playerNumber; 
	
	public GauntletGame() {
		this.numberMap = 0;
		
	}
	
	
	public void createPlateau(){
		notifyObserver(numberMap);
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,gameMode);
		this.listTerrain = plateau.getListTerrain();
		notifyObserver(listTerrain);
		/**
		this.List_Monster = plateau.getListMonster();
		for(Monster mob : List_Monster)
			listMonster.add(mob);
		notifyObserver(listMonster);
		**/
		}
	


  
/*
    
	public final void checkAttackMonster(){
		for (Monster mob : List_Monster){	
			if(mob.isLife()){
				ArrayList<Double> distanceList = new ArrayList<Double>();
				for (Heros player : List_Hero){
					if(player.isLife()){
						distanceList.add(distance(mob.getPosX(),mob.getPosY(),player.getPosX(),player.getPosY()));
					}
				}
				if(distanceList.size() > 0){
					Integer proche = closestHero(distanceList);
					WorldEntity player = listHero.get(proche);
					boolean isHeroVisible = Math.abs(mob.getPosX()-player.getPosX())<20*Plateau.getWidth() 
							&& Math.abs(mob.getPosY()-player.getPosY()) < 20*Plateau.getHeight();
					if(isHeroVisible){
						if(plateau.isMoveValide(mob.getPosX(),mob.getPosY(), mob.doAction( player.getPosX(),player.getPosY()))){
							if(Math.abs(mob.getPosX() -  player.getPosX()) > 30 || Math.abs(mob.getPosY()-player.getPosY())> 30 ){
								if( MonsterPositionList.size() < 1 || mob.creatureIsntInPlace(MonsterPositionList)){
									MonsterPositionList.add(mob);
									mob.move(mob.doAction( player.getPosX(),player.getPosY()));
								}
							}
							else{
								mob.attack(List_Hero.get(proche));
							}
						}
					}
				}
				else{
					System.out.println("Game Over");
				}
			}
		}
	}
    


    public void doActionHeros(String action, Integer player) {
		Heros hero = List_Hero.get(player);
		if(plateau.isMoveValide(hero.getPosX(),hero.getPosY(), action)){
			hero.move(action);
		}
	}*/


	/*
    public Integer closestHero(ArrayList<Double> normList){
    	Integer HeroClose = 0; //attaquer le hero le plus proche
        for (Integer i = 0; i < listHero.size(); i++)
            for(Integer j = 0; j < listHero.size(); j++)
                if(normList.get(i) < normList.get(j))
                    HeroClose = i;
    	return HeroClose; 
    }
 */
	
	
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}


	public Integer getNumberMap() {
		return numberMap;
	}

	public void setNumberMap(Integer numberMap) {
		this.numberMap = numberMap;
	}


	public void setPlayerNumber(Integer playerNumber) {
		this.playerNumber = playerNumber;
		
	}


	public void doActionHeros(String action, Integer player) {
		// TODO Auto-generated method stub
		
	}
	
	public void checkAttackMonster() {
		// TODO Auto-generated method stub
		
	}

}
