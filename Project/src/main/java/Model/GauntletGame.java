package Model;

public class GauntletGame extends AbstractModel {
	
	private Integer numberMap; 
	private Integer numberLine = 101;
	private Integer numberColumn = 101;
	private Integer numberLineMode;
	private Integer numberColumnMode;
	private IPlateau plateau;
	private WorldEntity[][] listTerrain = new WorldEntity[numberColumn][numberLine];
	private String gameMode;
	private Integer playerNumber; 
	private Heros[] listHeros;
	private Exit exit;
	private Integer numberOfBattallons = 0;
	private boolean gameOver;

	public GauntletGame() {
		this.numberMap = 0;
	}
	
	//Création du jeu avec les informations nécessaire du controller. 
	public void createGame(String[][] playerRegister){
		if(gameMode.equals("Mode Quête")){
			createHero(playerRegister, numberLine, numberColumn);
		}else if ((gameMode.equals("Mode Arène"))||(gameMode.equals("Mode Survivor"))){
			createHero(playerRegister, numberLineMode, numberColumnMode);
		}
		createPlateau(listHeros);
	}
	
	//Création du (ou des) héros
	public void createHero(String[][] playerRegister,Integer nombreLigne,Integer nombreColonne){
		listHeros = new Heros[playerNumber];
		for (Integer i = 0; i < playerNumber; i++ ){
			if(playerRegister[i][1] == "Sorcier"){
				listHeros[i] = new Wizzard(3+i*(nombreColonne-8),4+i*(nombreLigne-8));
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Guerrier"){
				listHeros[i] = new Warrior(3+i*(nombreColonne-7),3+i*(nombreLigne-7));
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if( playerRegister[i][1] == "Nain"){
				listHeros[i] = new Dwarf(4+i*(nombreColonne-8),3+i*(nombreLigne-7));
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}else if(playerRegister[i][1] == "Elfe"){
				listHeros[i] = new Elf(4+i*(nombreColonne-8),4+i*(nombreLigne-8));
				((Heros) listHeros[i]).setPlayerName(playerRegister[i][0]);
			}
		}
	}
	
	//Creation du plateau de jeu pour positionner chaque élément 
	public void createPlateau(Creatures[] listHeros){
		this.plateau = new Plateau(numberLine,numberColumn,numberMap);
		this.plateau.setListHeros(listHeros);
		this.plateau.setNumberColumnMode(numberColumnMode);
		this.plateau.setNumberLineMode(numberLineMode);
		this.plateau.Initialisation(gameMode, listHeros);
		this.exit = plateau.getMap().getExit();
		this.listTerrain = plateau.getListTerrain();
		notifyObserver(numberMap);
		notifyObserver(listTerrain);
		notifyObserver(listHeros);
	}

	//Attaques des monstres contre les héros s'ils sont dans le périmètre
	public void checkAttackMonster(){	
		if(gameMode.equals("Mode Quête")){
			plateau.checkAttackMonster(numberColumn,numberLine);
		}if(gameMode.equals("Mode Survivor")){
			plateau.checkAttackMonster(numberColumnMode,numberLineMode);
		}
	}
	
	//Action de l'utilisateur pour changer la position du héros
    public void doActionHeros(String action, Integer state, Integer player) {
    	listHeros[player].setDirection(state);
    	listHeros[player].doAction(action, plateau, listTerrain);
	}
    
    //Action de l'utilisateur pour attaquer
    public void attackHeros(Integer player){
    	Heros heros = listHeros[player];
    	for(Integer direction = 0; direction < 4; direction++){
			if (heros.getDirection().equals(direction)){
				heros.attack((PlateauObject[][]) listTerrain, direction);
			}
		}
    }
	
    
    //Vérification de la fin du jeu et de changement de niveau
    public void checkModeEnd(){
    	if(gameMode.equals("Mode Quête")){
    		Heros player = listHeros[0];
    		if(player.isLife()){
    			if(exit.next(player.getPosX(),player.getPosY())){
    				this.numberMap+=1;
    				for(Creatures heros : listHeros){
    					heros.setHp(true,heros.getHp()+numberMap*1000);
        				heros.setPosX(3);heros.setPosY(3);
    					heros.setDefense(heros.getDefense()+5);
    					((Heros) heros).setPower(((Heros) heros).getPower()+10);
    				}
    				createPlateau(listHeros);
    			}
    		}else{
    			gameOver = true;
    		}
    	}
    	if(gameMode.equals("Mode Arène")){
    		if(numberMap.equals(2)){
    			numberMap = 0;
    		}
    		if(!listHeros[0].isLife() || !listHeros[1].isLife()){
    			gameOver = true;
    		}
    	}
    	if(gameMode.equals("Mode Survivor")){
    		boolean dead = false;
    		if(playerNumber.equals(1)){
    			if(!listHeros[0].isLife()){
    				gameOver = true;
    			}
    		}else{
    			if(!listHeros[0].isLife() && !listHeros[1].isLife()){
    				gameOver= true;
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
    	notifyObserver(gameOver);
    }
    
	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	
	public void setPlayerNumber(Integer playerNumber) {
		this.playerNumber = playerNumber;	
	}	

	public void setNumberLineMode(Integer numberLineMode) {
		this.numberLineMode = numberLineMode;
	}

	public void setNumberColumnMode(Integer numberColumnMode) {
		this.numberColumnMode = numberColumnMode;
	}

	public Creatures[] getListHeros() {
		return listHeros;
	}
	
	


}
