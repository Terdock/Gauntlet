package Model;

import java.util.ArrayList;
import observer.Observable;

public class GauntletGame extends AbstractModel {
	
	private Integer numberMap; 
	private static Integer nombreLigne = 100;
	private static Integer nombreColonne = 100;
	IPlateau plateau;
	private ArrayList<Heros> List_Hero = new ArrayList<Heros>();
	private ArrayList<WorldEntity> listHero = new ArrayList<WorldEntity>();
	private ArrayList<Monster> List_Monster = new ArrayList<Monster>();
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<PlateauObject> List_Terrain =  new ArrayList<PlateauObject>();
	private ArrayList<WorldEntity> listTerrain =  new ArrayList<WorldEntity>();
	private String mode; 
	private Integer multiplayer;
	
	public GauntletGame() {
		this.numberMap = 0;
		
	}
	


	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	
	public void createPlateau(String Mode){
		
		setMode(Mode);
		notifyObserver(numberMap);
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,Mode);
		this.List_Terrain = this.plateau.getLIST_TERRAIN();
		for(PlateauObject obj : List_Terrain)
			listTerrain.add(obj);
		notifyObserver(listTerrain);
		this.List_Monster = plateau.getListMonster();
		for(Monster mob : List_Monster)
			listMonster.add(mob);
		notifyObserver(listMonster);
		}
	
	public void createHero(String[][] playerRegister) {
		List_Hero = convertListHero(playerRegister);
		for(Heros hero : List_Hero)
			listHero.add(hero);
		multiplayer = List_Hero.size(); 
		notifyObserver(listHero);
	}
	
	public ArrayList<Heros> convertListHero(String[][] playerRegister){
		for (Integer i = 0; i < playerRegister.length; i++ ){
			if(playerRegister[i][1] == "Sorcier"){
				Wizzard W = new Wizzard(1,1);
				W.setPlayerName(playerRegister[i][0]);
				List_Hero.add(W);
			}else if(playerRegister[i][1] == "Guerrier"){
				Warrior K = new Warrior(1,1);
				K.setPlayerName(playerRegister[i][0]);
				List_Hero.add(K);
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
	
	
    public Integer closestHero(ArrayList<Double> normList){
    	Integer HeroClose = 0; //attaquer le hero le plus proche
        for (Integer i = 0; i < listHero.size(); i++)
            for(Integer j = 0; j < listHero.size(); j++)
                if(normList.get(i) < normList.get(j))
                    HeroClose = i;
    	return HeroClose; 
    }
     

	public void Where_is_Hero(Monster Mob,Integer iHero){
            setISeeHero(false);
            if(Math.abs(Mob.getPosX()) < Math.abs(listHero.get(iHero).getPosX()+50*listHero.get(iHero).getWidth()))
                setISeeHero(true);
            else if(Math.abs(Mob.getPosX()) < Math.abs(listHero.get(iHero).getPosX()-50*listHero.get(iHero).getWidth()))
                setISeeHero(true);
            if(Math.abs(Mob.getPosY()) < Math.abs(listHero.get(iHero).getPosY()+50*listHero.get(iHero).getHeight()))
                setISeeHero(true);
            else if(Math.abs(Mob.getPosY()) < Math.abs(listHero.get(iHero).getPosY()-50*listHero.get(iHero).getHeight()))
                setISeeHero(true);             
    }
	
	public void checkAttackMonster(){
		ArrayList<Double> normList = new ArrayList<Double>();
	 	for (Heros player : List_Hero){
	 		for (Monster mob : List_Monster){	
	 				normList.add(norm(mob.getPosX(),mob.getPosY(),player.getPosX(),player.getPosY()));
	 				Where_is_Hero(mob,closestHero(normList));
	 				if(normList.get(closestHero(normList)) > Math.sqrt(mob.getPas()^2+mob.getPas()^2)){
	 					mob.setiSeeHero(true);
	 					mob.attack();
		    		 
		    	}
	 		}
	 	
	 	}
	}
    

 
    public double norm(Integer vMonster,Integer wMonster,Integer xHero,Integer yHero){
        return Math.sqrt((vMonster-xHero)^2+(wMonster-yHero)^2);
    }

    
     
    public boolean isISeeHero() {
        return iSeeHero;
    }
 
    public void setISeeHero(boolean iSeeHero) {
        this.iSeeHero = iSeeHero;
    }
	
	
	

	public Integer getNumberMap() {
		return numberMap;
	}

	public void setNumberMap(Integer numberMap) {
		this.numberMap = numberMap;
	}
}
