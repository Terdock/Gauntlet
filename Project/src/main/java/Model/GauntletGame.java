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

	public GauntletGame() {
		this.numberMap = 0;
	}
	
	public void createPlateau(String[][] playerRegister){
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,playerNumber);
		this.plateau.Initialisation(gameMode, playerRegister);
		this.plateau.setNombreColonneSurvivor(nombreColonneSurvivor);
		this.plateau.setNombreLigneSurvivor(nombreLigneSurvivor);
		this.exit = plateau.getMap().getExit();
		this.listTerrain = plateau.getListTerrain();
		this.listHeros = plateau.getListHeros();
		notifyObserver(numberMap);
		notifyObserver(listTerrain);
		notifyObserver(listHeros);
		}
	
	public void createPlateau(Creatures[] listHeros){
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,playerNumber);
		this.plateau.Initialisation(gameMode, listHeros);
		this.plateau.setNombreColonneSurvivor(nombreColonneSurvivor);
		this.plateau.setNombreLigneSurvivor(nombreLigneSurvivor);
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
    				createPlateau(listHeros);
    			}
    		}else{
    			System.out.println("GameOver");
    		}
    	}
    	if(gameMode.equals("Mode Arene")){
    		if(numberMap.equals(2)){
    			numberMap = 0;
    		}
    		if(!listHeros[0].isLife()){
    			System.out.println("Tu es nul "+listHeros[0].getPlayerName());
    		}
    		if(!listHeros[1].isLife()){
    			System.out.println("Tu es le grand gagnant "+listHeros[1].getPlayerName());
    		}
    	}
    	if(gameMode.equals("Mode Survivor")){
    		boolean dead = false;
    		for(Heros Hero : listHeros){
    			if(!Hero.isLife()){
    				System.out.println("Tu es nul "+Hero.getPlayerName());
    			}
    		}

    		for(Creatures mob : plateau.getListMonster()){
    			if(mob.isLife()){
    				dead = true;
    			}
    			
    		}
    		if(!dead){
    			if(numberOfBattallons.equals(10)){
    				numberOfBattallons =0;
    				numberMap += 1;
    				createPlateau(listHeros);
    			}
    			numberOfBattallons +=1;
    			plateau.battallons(numberOfBattallons);
    		}
    	}
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
