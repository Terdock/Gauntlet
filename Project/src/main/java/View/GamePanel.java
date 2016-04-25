package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Controller.AbstractController;
import Model.Creatures;
import Model.Monster;
import Model.PlateauObject;
import Model.WorldEntity;


public class GamePanel extends Panel {
	private WorldEntity[][] listTerrain;
	private AbstractController controller;
	private Keyboard listener;
	private boolean upLeftCondition, upDownCondition, downLeftCondition, leftRightCondition, downRightCondition, upRightCondition, allConditionEdge;
	private LoadImage imageClasse;
	private Integer numberMap, divided, playerNumber;
	private String[] typeHeros = {"Warrior", "Dwarf", "Wizzard", "Elf"};
	private Integer size = 30;
	
	public GamePanel(Panel panel, AbstractController controller){
		super(panel);
		this.controller = controller;
		this.setBounds(0, 0, 700, 600);
		this.setSize(new Dimension(700,600));
		imageClasse = new LoadImage();
		imageClasse.chargerImage();
		divided = 5;
	}
	
	
         
	public void paintComponent(Graphics g){
			for(Integer numberLine = 0; numberLine < listTerrain.length; numberLine++){
				for(Integer numberColumn = 0; numberColumn < listTerrain[numberLine].length; numberColumn++){
				WorldEntity ground = listTerrain[numberColumn][numberLine];
				Image imageGround = edgeImage(numberColumn, numberLine);
				Creatures creature = null;
				if (allConditionEdge){
					if(ground.getClass().getName().equals("Model.Wall")){
						imageGround = imageClasse.getImagesWall()[numberMap][7];
					}else if(ground.getClass().getName().equals("Model.Sol")){
						imageGround = imageClasse.getImagesGround()[numberMap];
						creature = ((PlateauObject) ground).getCreature();
					}else if (ground.getClass().getName().equals("Model.Door")){
						imageGround = imageClasse.getImageDoor();
					}
				}
				g.drawImage(imageGround,ground.getPosX()*30/divided, ground.getPosY()*30/divided, size/divided, size/divided, null);
				showCreatures(creature, g);
			}
		}
		actionMonster();
		actionHeros();
		repaint();
		/*try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}

	private Image edgeImage(Integer numberColumn, Integer numberLine){
		Image imageGround = null;
		checkEdgeCondition(numberColumn, numberLine);
		if(upLeftCondition){
			imageGround = imageClasse.getImagesWall()[numberMap][2];
		}else if(upDownCondition){
			imageGround = imageClasse.getImagesWall()[numberMap][0];
		}else if (downLeftCondition){
			imageGround = imageClasse.getImagesWall()[numberMap][5];
		}else if(leftRightCondition){
			imageGround = imageClasse.getImagesWall()[numberMap][1];
		}else if(downRightCondition){
			imageGround = imageClasse.getImagesWall()[numberMap][4];
		}else if(upRightCondition){
			imageGround = imageClasse.getImagesWall()[numberMap][3];
		}
		return imageGround;
	}
	
	private void checkEdgeCondition(Integer numberColumn, Integer numberLine){
		upLeftCondition = numberColumn.equals(0) && numberLine.equals(0);
		upRightCondition = numberColumn.equals(listTerrain.length-1) && numberLine.equals(0);
		downLeftCondition = numberColumn.equals(0) && numberLine.equals(listTerrain.length-1);
		downRightCondition = numberColumn.equals(listTerrain.length-1) && numberLine.equals(listTerrain.length-1);
		upDownCondition = (!numberColumn.equals(0) && !numberColumn.equals(listTerrain.length-1) 
				&& (numberLine.equals(0) || numberLine.equals(listTerrain.length-1)));
		leftRightCondition = (!numberLine.equals(0) && !numberLine.equals(listTerrain.length-1) 
				&& (numberColumn.equals(0) || numberColumn.equals(listTerrain.length-1)));
		allConditionEdge = !upLeftCondition && !upDownCondition && !downLeftCondition && !leftRightCondition && 
				!downRightCondition && !upRightCondition;
	}
	
	private void showCreatures(Creatures creature, Graphics g){
		if (!(creature == null)){
			if (creature.isLife()){
				isHeros(creature, g);
				isMonster(creature, g);
			}
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
	
	public void addKeyboard(Integer playerNumber){
		this.playerNumber = playerNumber;
		listener = new Keyboard(playerNumber, this);
	}
	
	private void actionMonster(){
		controller.doActionMonsters();
	}
	
	private void actionHeros(){
		for(Integer i = 0; i < playerNumber; i++){
			String action = listener.state(i);
			if (!action.equals("Action Stop") && !action.equals("Action Attack")){
				controller.doActionHeros(action, i);
			}else if(action.equals("Action Attack")){
				controller.attackMonster();
			}
		}
	}

	public void setNumberMap(int numberMap) {
		this.numberMap = numberMap;
	}
	
	public void setTerrain(WorldEntity[][] entities){
		this.listTerrain = entities;
	}
	
	
	
	
	
		/**
			
		for (WorldEntity player : listHero )
		{	if(player.getVisible()){
				Image img = afficheImage.images(player.nameImage());
				g.drawImage(img, player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null);
			}
		}
		for (WorldEntity obj : listObject )
		{
			if(obj.getVisible()){
				Image img = afficheImage.images(obj.nameImage());
				g.drawImage(img,obj.getPosX(), obj.getPosY(), obj.getWidth(), obj.getHeight(), null);
			}
		}
		**/

}
