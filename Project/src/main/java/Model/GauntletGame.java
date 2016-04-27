package Model;

public class GauntletGame extends AbstractModel {
	
	private Integer numberMap; 
	private static Integer nombreLigne = 101;
	private static Integer nombreColonne = 101;
	IPlateau plateau;
	private WorldEntity[][] listTerrain = new WorldEntity[nombreColonne][nombreLigne];
	private String gameMode;
	private Integer playerNumber; 
	private Heros[] listHeros;
	
	public GauntletGame() {
		this.numberMap = 0;
	}
	
	
	public void createPlateau(String[][] playerRegister){
		notifyObserver(numberMap);
		this.plateau = new Plateau(nombreLigne,nombreColonne,numberMap,gameMode,playerRegister,playerNumber);
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
		plateau.checkAttackMonster();
	};
	

    public void doActionHeros(String action, Integer state, Integer player) {
    	listHeros[player].setDirection(state);
    	listHeros[player].doAction(action, plateau, listTerrain);
	}
    
    
    public void attackHeros(Integer player){
    	plateau.attacHeros(player);
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
