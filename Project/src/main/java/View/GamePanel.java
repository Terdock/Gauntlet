package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Controller.AbstractController;
import Model.Creatures;
import Model.Heros;
import Model.Monster;
import Model.PlateauObject;
import Model.Weapon;
import Model.WorldEntity;
import Model.WorldObject;
import observer.Observer;

public class GamePanel extends Panel implements Observer {
	private WorldEntity[][] listTerrain;
	private WorldEntity[] listHeros;
	private AbstractController controller;
	private CardLayout card;
	private Panel panel;
	private Keyboard listener;
	private LoadImage imageClasse;
	private Integer numberMap, divided, playerNumber;
	private String modeDeJeu;
	private String[] typeHeros = {"Warrior", "Dwarf", "Wizzard", "Elf"};
	private Integer size = 30;
	private ArrayList<WorldEntity> groundWeapons;
	
	public GamePanel(CardLayout card, Panel panelContainer, Panel panel, AbstractController controller){
		super(panel);
		this.panel = panelContainer;
		this.card = card;
		this.controller = controller;
		this.setBounds(0, 0, 720, 600);
		this.setSize(new Dimension(720,600));
		imageClasse = new LoadImage();
		imageClasse.chargerImage();
		divided = 1;
	}
	
	
         
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.requestFocus(true);
		setBackground(Color.BLACK);
		if (modeDeJeu.equals("Mode Quête")){
			showModeStory(g);
			actionMonsters();
		}
		loadLand(g);
//		for(Integer i=0; i<2; i++){
//			showAndActionWeapon(g);
//			try {
//				Thread.sleep(80);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		if (modeDeJeu.equals("Mode Survivor")){
			actionMonsters();
		}
		actionHeros();
		showPlayAgain();
		controller.checkModeEnd();
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
		groundWeapons = new ArrayList<WorldEntity>();
		for(Integer numberColumn = 0; numberColumn < listTerrain.length; numberColumn++){
			for(Integer numberLine = 0; numberLine < listTerrain[numberColumn].length; numberLine++){
				WorldEntity ground = listTerrain[numberColumn][numberLine];
				Image imageGround;
				Creatures creature = ((PlateauObject) ground).getCreature();
				Creatures deadCreature = ((PlateauObject) ground).getDead();
				WorldObject object = ((PlateauObject) ground).getObject();
				Weapon weapon = ((PlateauObject) ground).getWeapon();
				if (!(weapon == null)){
					groundWeapons.add(ground);
				}
				if(ground.getClass().getName().equals("Model.Wall")){
					imageGround = imageClasse.getImagesWall()[numberMap][ground.getForm()];
				}else if (ground.getClass().getName().equals("Model.Door")){
					imageGround = imageClasse.getImageDoor();
				}else{
					imageGround = imageClasse.getImagesGround()[numberMap];
				}
				g.drawImage(imageGround,ground.getPosX()*30/divided, ground.getPosY()*30/divided, size/divided, size/divided, null);
				showCreatures(creature, deadCreature, g);
				showObject(ground, object, g);
			}
		}
		
//		for(Integer numberLine = 0; numberLine < listTerrain.length; numberLine++){
//			for(Integer numberColumn = 0; numberColumn < listTerrain.length; numberColumn++){
//			}
//		}
	}


	private void showCreatures(Creatures creature, Creatures deadCreature, Graphics g){
		if(!(deadCreature == null)){
			deadHeros(deadCreature, g);
			deadMonster(deadCreature, g);
		}if (!(creature == null)){
			isHeros(creature, g);
			isMonster(creature, g);
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
	
	private void showObject(WorldEntity ground, WorldObject object, Graphics g){
		if (!(object == null)){
			if (object.name().equals("KeyDoor")){
				Image imageKey = imageClasse.getImageKey();
				g.drawImage(imageKey, ground.getPosX()*30/divided, ground.getPosY()*30/divided, size/divided, size/divided, null);
			}
		}
	}
	
	private void showWeapon(WorldEntity ground, Weapon weapon, Graphics g){
		if (!(weapon == null)){
			for (Integer i = 0; i < 4; i++){
				if (weapon.name().equals(typeHeros[i])){
					for (Integer direction = 0; direction < 4; direction++){
						if (weapon.getDirection().equals(direction)){
							Image imageWeapon = imageClasse.getImagesWeapons()[i][direction];
							g.drawImage(imageWeapon, ground.getPosX()*30/divided, ground.getPosY()*30/divided, size/divided, size/divided, null);
						}
					}
				}
			}
		}
	}
	
	
	public void addKeyboard(Integer playerNumber){
		this.playerNumber = playerNumber;
		listener = new Keyboard(playerNumber, this);
	}
	
	private void actionMonsters(){
		controller.doActionMonsters();
	}
	
	private void showAndActionWeapon(Graphics g){
		if(!(groundWeapons.isEmpty())){
			for(Integer i = 0; i < groundWeapons.size(); i++){
				PlateauObject ground = (PlateauObject) groundWeapons.get(i);
				Weapon weapon = ground.getWeapon();
				showWeapon(ground, weapon, g);
				Creatures creature = ground.getCreature();
				if ((ground.getCreature() ==  null) && ((ground.isPassable()))){
					ground.setWeapon(null);
				}
				if(!(creature ==  null)){
					weapon.getCreature().attack(creature);
					if(!creature.isLife()){
						if(!(creature.getObject() == null)){
							ground.setObject(creature.getObject());
							ground.getCreature().setObject(null);
						}
						ground.setCreature(null);
					}
					ground.setWeapon(null);
				}
				if(!(weapon == null)){
					if(weapon.getCreature().name().equals("Elf") || 
							weapon.getCreature().name().equals("Wizzard")){
						PlateauObject nextGround = dependingDirection(weapon.getDirection(), ground.getPosX(), ground.getPosY());
						if ((ground.getCreature() ==  null) && ((ground.isPassable()))){
							nextGround.setWeapon(weapon);
						}
						if(!nextGround.isWeaponPassable()){
							nextGround.setWeapon(null);
						}
					}
				}
			}
		}
	}
//			if (!(((PlateauObject)groundWeapon).getWeapon()==null)){
//				if(((PlateauObject)groundWeapon).getWeapon().getCreature().name().equals("Elf") || 
//						((PlateauObject)groundWeapon).getWeapon().getCreature().name().equals("Wizzard")){
//					PlateauObject ground = (PlateauObject)groundWeapon;
//					Weapon weapon = ((PlateauObject)groundWeapon).getWeapon();
//					Creatures creature = ground.getCreature();
//					PlateauObject nextGround = dependingDirection(weapon.getDirection(), ground.getPosX(), ground.getPosY());
//					if ((ground.getCreature() ==  null) && ((ground.isPassable()))){
//						ground.setWeapon(null);
//						nextGround.setWeapon(weapon);
//					}
//					if(!(creature ==  null)){
//						weapon.getCreature().attack(creature);
//						if(!creature.isLife()){
//							if(!(creature.getObject() == null)){
//								ground.setObject(creature.getObject());
//								ground.getCreature().setObject(null);
//							}
//							ground.setCreature(null);
//						}
//						ground.setWeapon(null);
//					}
//					if(!nextGround.isWeaponPassable()){
//						nextGround.setWeapon(null);
//					}
//				}
//			}
//		}
//		if(!(groundWeapons == null)){
//			System.out.println(groundWeapons);
//			System.out.println(groundWeapons[0]);
//			if (!(((PlateauObject)groundWeapons[0]).getWeapon()==null)){
//				if(((PlateauObject)groundWeapon).getWeapon().getCreature().name().equals("Warrior") || 
//						((PlateauObject)groundWeapon).getWeapon().getCreature().name().equals("Dwarf")){
//					for(Integer i = 0; i < 4; i++){
//						PlateauObject ground = (PlateauObject)groundWeapons[i];
//						Weapon weapon = ((PlateauObject)groundWeapons[i]).getWeapon();
//						Creatures creature = ground.getCreature();
//						if(!(creature ==  null)){
//							weapon.getCreature().attack(creature);
//							if(!creature.isLife()){
//								if(!(creature.getObject() == null)){
//									ground.setObject(creature.getObject());
//									ground.getCreature().setObject(null);
//								}
//								ground.setCreature(null);
//							}
//							ground.setWeapon(null);
//						}
//					}
//				}
//			}
//		}
		
		
		
		
		
//		if(!(groundWeapon == null) && !(((PlateauObject)groundWeapon[0]).getWeapon()==null)){
//			if(((PlateauObject)groundWeapon[0]).getWeapon().getCreature().name().equals("Elf") || 
//				((PlateauObject)groundWeapon[0]).getWeapon().getCreature().name().equals("Wizzard")){
//				PlateauObject ground = (PlateauObject)groundWeapon[0];
//				Weapon weapon = ((PlateauObject)groundWeapon[0]).getWeapon();
//				Creatures creature = ground.getCreature();
//				PlateauObject nextGround = dependingDirection(weapon.getDirection(), ground.getPosX(), ground.getPosY());
//				if ((ground.getCreature() ==  null) && ((ground.isPassable()))){
//					ground.setWeapon(null);
//					nextGround.setWeapon(weapon);
//				}
//				if(!(creature ==  null)){
//					weapon.getCreature().attack(creature);
//					if(!creature.isLife()){
//						if(!(creature.getObject() == null)){
//							ground.setObject(creature.getObject());
//							ground.getCreature().setObject(null);
//						}
//						ground.setCreature(null);
//					}
//					ground.setWeapon(null);
//				}
//				if(!nextGround.isWeaponPassable()){
//					nextGround.setWeapon(null);
//				}
//			}
//		}
		//else if(!(groundWeapon[] == null) && !(((PlateauObject)groundWeapon).getWeapon()==null) && 
			//		  (((PlateauObject)groundWeapon).getWeapon().getCreature().name().equals("Dwarf") || 
				//	  ((PlateauObject)groundWeapon).getWeapon().getCreature().name().equals("Warrior"))){
			
		//}
//	}
	
	private PlateauObject dependingDirection(Integer directionAttack, Integer posX, Integer posY){
		WorldEntity ground = null;
		if (directionAttack.equals(0)){
			ground = listTerrain[posX][posY - 1];
		}else if (directionAttack.equals(1)){
			ground = listTerrain[posX + 1][posY];
		}else if (directionAttack.equals(2)){
			ground = listTerrain[posX][posY + 1];
		}else if (directionAttack.equals(3)){
			ground = listTerrain[posX - 1][posY];
		}
		return (PlateauObject)ground; 
	}
	
	private void actionHeros(){
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
	
	private void showPlayAgain(){
		boolean[] isLife = new boolean[playerNumber];
		Integer i = 0;
		for(WorldEntity heros : listHeros){
			isLife[i] = ((Heros)heros).isLife();
			i++;
		}
		if(playerNumber.equals(1)){
			if(!isLife[0]){
				card.show(panel, "Play Again");
			}
		}else{
			if(!isLife[0] && !isLife[1]){
				card.show(panel, "Play Again");
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
