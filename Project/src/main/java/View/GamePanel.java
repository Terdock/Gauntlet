package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import Controller.AbstractController;
import Model.Creatures;
import Model.Heros;
import Model.Monster;
import Model.PlateauObject;
import Model.WorldEntity;
import observer.Observer;



public class GamePanel extends Panel implements Observer {
	private WorldEntity[][] listTerrain;
	private WorldEntity[] listHeros;
	private AbstractController controller;
	private Keyboard listener;
	private LoadImage imageClasse;
	private Integer numberMap, divided, playerNumber;
	private String modeDeJeu;
	private String[] typeHeros = {"Warrior", "Dwarf", "Wizzard", "Elf"};
	private Integer size = 30;
	
	public GamePanel(Panel panel, AbstractController controller){
		super(panel);
		this.controller = controller;
		this.setBounds(0, 0, 720, 600);
		this.setSize(new Dimension(720,600));
		imageClasse = new LoadImage();
		imageClasse.chargerImage();
		divided = 1;
	}
	
	
         
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		setBackground(Color.BLACK);
		if (modeDeJeu.equals("Mode Quête")){
			showModeStory(g);
		}
		loadLand(g);
		actionCreatures();
		repaint();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	

	private void showModeStory(Graphics g){
		Integer offsetMaxX = (listTerrain[0].length*size - 720);
		Integer offsetMaxY = (listTerrain.length*size - 600);
		Integer offsetMinX = 0;
		Integer offsetMinY = 0;
		
		Integer camX = listHeros[0].getPosX()*size - 720 / 2;
		Integer camY = listHeros[0].getPosY()*size - 600 / 2;

		if(camX > offsetMaxX) camX = offsetMaxX;
		else if(camX < offsetMinX) camX = offsetMinX;
		if(camX > offsetMaxY) camY = offsetMaxY;
		else if(camX < offsetMinY) camY = offsetMinY;
		
		g.translate(-camX, -camY);
	}
	
	private void loadLand(Graphics g){
		for(Integer numberLine = 0; numberLine < listTerrain.length; numberLine++){
			for(Integer numberColumn = 0; numberColumn < listTerrain[numberLine].length; numberColumn++){
				WorldEntity ground = listTerrain[numberColumn][numberLine];
				Image imageGround;
				Creatures creature = ((PlateauObject) ground).getCreature();
				Creatures deadCreature = ((PlateauObject) ground).getDead();
				if(ground.getClass().getName().equals("Model.Wall")){
					imageGround = imageClasse.getImagesWall()[numberMap][ground.getForm()];
				}else if (ground.getClass().getName().equals("Model.Door")){
					imageGround = imageClasse.getImageDoor();
				}else{
					imageGround = imageClasse.getImagesGround()[numberMap];
				}
				g.drawImage(imageGround,ground.getPosX()*30/divided, ground.getPosY()*30/divided, size/divided, size/divided, null);
				showCreatures(creature, deadCreature, g);
			}
		}
	}

<<<<<<< HEAD
	private void showCreatures(Creatures creature, Graphics g){
		if (!(creature == null)){
			if (creature.isLife()){
				isHeros(creature, g);
				isMonster(creature, g);
			}
=======
	private void showCreatures(Creatures creature, Creatures deadCreature, Graphics g){
		if(!(deadCreature == null)){
			deadHeros(deadCreature, g);
			deadMonster(deadCreature, g);
		}if (!(creature == null)){
			isHeros(creature, g);
			isMonster(creature, g);
>>>>>>> refs/remotes/origin/master
		}
	}
	
	private void isHeros(Creatures creature, Graphics g){
		Image imageHeros = null;
		for (Integer i = 0; i<4; i++){
			if(creature.name().equals(typeHeros[i])){
				imageHeros = imageClasse.getImagesHeros()[i][creature.getDirection()][creature.getMoveContinue()];
				g.drawImage(imageHeros, creature.getPosX()*30/divided, creature.getPosY()*30/divided, size/divided, size/divided, null);
			}
		}
	}
	
	private void isMonster(Creatures creature, Graphics g){
		Image imageMonster = null;
		if(creature.isLife()){
			if(creature.name().equals("Monster")){
				imageMonster = imageClasse.getImagesMonsters()[numberMap][((Creatures) creature).getDirection()][((Creatures) creature).getMoveContinue()];
				if (numberMap.equals(4)){
					imageMonster = imageClasse.getImagesMonsters()[numberMap-4][((Monster) creature).getDirection()][((Monster) creature).getMoveContinue()];
					g.drawImage(imageMonster, creature.getPosX()*30/divided, creature.getPosY()*30/divided, (size+10)/divided, (size+10)/divided, null);
				}else{
					g.drawImage(imageMonster, creature.getPosX()*30/divided, creature.getPosY()*30/divided, size/divided, size/divided, null);
				}
			}
		}		
	}
	
	private void deadHeros(Creatures heros, Graphics g){
		if (heros.nameType().equals("Heros")){
			Image imageDead = imageClasse.getImageDeathHeros();
			g.drawImage(imageDead, heros.getPosX()*30/divided, heros.getPosY()*30/divided, size/divided, size/divided, null);
		}
	}
	
	private void deadMonster(Creatures monster, Graphics g){
		if (monster.nameType().equals("Monster")){
			Image imageDead = imageClasse.getImageDeathMonsters();
			g.drawImage(imageDead, monster.getPosX()*30/divided, monster.getPosY()*30/divided, size/divided, size/divided, null);
		}
	}
	
	
	public void addKeyboard(Integer playerNumber){
		this.playerNumber = playerNumber;
		listener = new Keyboard(playerNumber, this);
	}
	
	private void actionCreatures(){
		controller.doActionMonsters();
		for(Integer player = 0; player < playerNumber; player++){
			Integer state = listener.state(player);
			String action = listener.stateToString(state);
			if (!action.equals("Action Stop") && !action.equals("Action Attack")){
				controller.doActionHeros(action, state, player);
			}else if(action.equals("Action Attack")){
				controller.attackHeros(player);
			}
		}
	}

	public void setModeDeJeu(String modeDeJeu) {
		this.modeDeJeu = modeDeJeu;
	}
	
	public void update(Integer numberMap) {
		this.numberMap = numberMap;
	}

	public void update(WorldEntity[][] listTerrain) {
		this.listTerrain = listTerrain;
	}

	public void update(WorldEntity[] listHeros) {
		this.listHeros = listHeros;
	}


}
