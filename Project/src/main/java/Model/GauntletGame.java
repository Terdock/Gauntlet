package Model;

public class GauntletGame extends AbstractModel {
	
	private Integer numberMap; 
	private Integer nombreLigne = 101;
	private Integer nombreColonne = 101;
	private Integer nombreLigneSurvivor;
	private Integer nombreColonneSurvivor;
	IPlateau plateau;
	private WorldEntity[][] listTerrain = new WorldEntity[nombreColonne][nombreLigne];
	private String gameMode;
	private Integer playerNumber; 
	private Heros[] listHeros;
	private boolean GameOver;
	private Exit exit;
	private Integer numberOfBattallons = 0;
	private boolean replay;

	public GauntletGame() {
		this.numberMap = 0;
	}
	
	public void createPlateau(String[][] playerRegister){
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,playerNumber);
		this.plateau.setNombreColonneSurvivor(nombreColonneSurvivor);
		this.plateau.setNombreLigneSurvivor(nombreLigneSurvivor);
		this.plateau.Initialisation(gameMode, playerRegister);
		this.exit = plateau.getMap().getExit();
		this.listTerrain = plateau.getListTerrain();
		this.listHeros = plateau.getListHeros();
		notifyObserver(numberMap);
		notifyObserver(listTerrain);
		notifyObserver(listHeros);
		}
	
	public void createPlateau(Creatures[] listHeros){
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,playerNumber);
		this.plateau.setNombreColonneSurvivor(nombreColonneSurvivor);
		this.plateau.setNombreLigneSurvivor(nombreLigneSurvivor);
		this.plateau.Initialisation(gameMode, listHeros);
		this.listTerrain = plateau.getListTerrain();
		this.listHeros = plateau.getListHeros();
		notifyObserver(numberMap);
		notifyObserver(listTerrain);
		notifyObserver(listHeros);
	}

	public final void checkAttackMonster(){	
		if(gameMode.equals("Mode Quête")){
			plateau.checkAttackMonster(nombreColonne,nombreLigne);
		}if(gameMode.equals("Mode Survivor")){
			plateau.checkAttackMonster(nombreColonneSurvivor,nombreLigneSurvivor);
		}
	}
	

    public void doActionHeros(String action, Integer state, Integer player) {
    	listHeros[player].setDirection(state);
    	listHeros[player].doAction(action, plateau, listTerrain);
	}
    
    
    public void attackHeros(Integer player){
    	Heros heros = listHeros[player];
    	for(Integer direction = 0; direction < 4; direction++){
			if (heros.getDirection().equals(direction)){
				heros.attack((PlateauObject[][]) listTerrain, direction);
			}
		}
    }
	
    public void checkModeEnd(){
    	if(gameMode.equals("Mode Quête")){
    		Heros player = listHeros[0];
    		if(player.isLife()){
    			if(exit.next(player.getPosX(),player.getPosY())){
    				this.numberMap+=1;
    				
    				for(Creatures heros : listHeros){
    					heros.setHp(true,1000+numberMap*1000);
        				heros.setPosX(3);heros.setPosY(3);
    					heros.setDefense(heros.getDefense()+5);
    					((Heros) heros).setPower(((Heros) heros).getPower()+10);
    				}
    				createPlateau(listHeros);
    			}
    		}else{
    			replay = true;
    		}
    	}
    	if(gameMode.equals("Mode Arène")){
    		if(numberMap.equals(2)){
    			numberMap = 0;
    		}
    		if(!listHeros[0].isLife() || !listHeros[1].isLife()){
    			replay = true;
    		}
    	}
    	if(gameMode.equals("Mode Survivor")){
    		boolean dead = false;
    		if(playerNumber.equals(1)){
    			if(!listHeros[0].isLife()){
    				replay = true;
    			}
    		}else{
    			if(!listHeros[0].isLife() && !listHeros[1].isLife()){
    				replay = true;
    			}
    		}

    		for(Creatures mob : plateau.getListMonster()){
    			if(mob.isLife()){
    				dead = true;
    			}
    			
    		}
    		if(!dead){
    			if(numberOfBattallons.equals(5)){
    				numberOfBattallons =0;
    				numberMap += 1;
    				for(Creatures heros : listHeros){
    					heros.setLife(true);
    					heros.setDefense(heros.getDefense()+5);
    					((Heros) heros).setPower(((Heros) heros).getPower()+10);
    				}
    				createPlateau(listHeros);
    			}
    			numberOfBattallons +=1;
    			plateau.battallons(numberOfBattallons);
    		}
    	}
    	notifyObserver(replay);
    }
    
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

	public void setNombreLigneSurvivor(Integer nombreLigneSurvivor) {
		this.nombreLigneSurvivor = nombreLigneSurvivor;
	}

	public void setNombreColonneSurvivor(Integer nombreColonneSurvivor) {
		this.nombreColonneSurvivor = nombreColonneSurvivor;
	}
	
	public Creatures[] getListHeros() {
		return listHeros;
	}

	public void setListHeros(Heros[] listHeros) {
		this.listHeros = listHeros;
	}
	
	


}
