package Model;

public class GauntletGame extends AbstractModel {
	
	private Integer numberMap; 
	private static Integer nombreLigne = 101;
	private static Integer nombreColonne = 101;
	private final static Integer nombreLigneArene = 20;
	private final static Integer nombreColonneArene = 24;
	IPlateau plateau;
	private WorldEntity[][] listTerrain = new WorldEntity[nombreColonne][nombreLigne];
	private String gameMode;
	private Integer playerNumber; 
	private Heros[] listHeros;
	private boolean GameOver;
	private boolean Exit;

	public GauntletGame() {
		this.numberMap = 0;
	}
	
	
	public void createPlateau(String[][] playerRegister){
		notifyObserver(numberMap);
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,playerNumber);
		this.plateau.Initialisation(nombreLigne,nombreColonne,gameMode, playerRegister);

		this.listTerrain = plateau.getListTerrain();
		this.listHeros = plateau.getListHeros();
		notifyObserver(listTerrain);
		notifyObserver(listHeros);
		}
	
	public void createPlateau(Creatures[] listHeros){
		notifyObserver(numberMap);
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,playerNumber);
		this.plateau.Initialisation(nombreLigne,nombreColonne,gameMode, listHeros);
		this.listTerrain = plateau.getListTerrain();
		this.listHeros = plateau.getListHeros();
		notifyObserver(listTerrain);
		notifyObserver(listHeros);
		}
    
	public Creatures[] getListHeros() {
		return listHeros;
	}


	public void setListHeros(Heros[] listHeros) {
		this.listHeros = listHeros;
	}


	public final void checkAttackMonster(){	
		if(gameMode.equals("Mode Quete"))
			plateau.checkAttackMonster(nombreColonne,nombreLigne);
		if(gameMode.equals("Mode Survivor"))
			plateau.checkAttackMonster(nombreColonneArene,nombreLigneArene);

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
    	if(gameMode.equals("Mode Quete")){
    		for (Creatures player : listHeros ){
    			if(player.isLife()){
    				if(Exit){
    					numberMap+=1;
    					 createPlateau(listHeros);	
    				}
    			}
    			else{
    				System.out.println("GameOver");
    			}
    		}
    	}
    	if(gameMode.equals("Mode Arene")){
    		if(!listHeros[0].isLife()){
    			System.out.println("Tu es nul "+listHeros[0].getPlayerName());
    		}
    		if(!listHeros[1].isLife()){
    			System.out.println("Tu es le grand gagnant "+listHeros[1].getPlayerName());
    		}
    	}
    	if(gameMode.equals("Mode Survivor")){
    		boolean dead = false;
    		if(!listHeros[0].isLife()){
    			System.out.println("Tu es nul "+listHeros[0].getPlayerName());
    		}
    		if(!listHeros[1].isLife()){
    			System.out.println("Tu es le grand gagnant "+listHeros[1].getPlayerName());
    		}
  

    		for(Creatures mob : plateau.getListMonster()){
    			if(mob.isLife()){
    				dead = true;
    			}
    			
    		}
    		if(!dead){
    			numberMap+=1;
    			plateau.battallons();
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


}
