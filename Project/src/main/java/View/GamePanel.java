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
	
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listTerrain = new ArrayList<WorldEntity>();
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
		divided = 2;
	}
	
	
         
	public void paintComponent(Graphics g){
		for (WorldEntity ground : listTerrain ){
			Image imageGround = null;
			imageGround = edgeImage(ground);
			if(ground.getClass().getName().equals("Model.Wall")){
				imageGround = imageClasse.getImagesWall()[numberMap][ground.getForm()];
			}else if(ground.getClass().getName().equals("Model.Sol")){
				imageGround = imageClasse.getImagesGround()[numberMap];
				Creatures creature = ((PlateauObject) ground).getCreature();
				if (!creature.equals(null)){
					if (creature.isLife()){
						isHeros(creature, g);
						isMonster(creature, g);
					}
				}
			}else if (ground.getClass().getName().equals("Model.Door")){
				imageGround = imageClasse.getImageDoor();
			}
			g.drawImage(imageGround,ground.getPosX()/divided, ground.getPosY()/divided, size/divided, size/divided, null);	
		}
		setPosMonster();
		setPosHeros();
		repaint();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Image edgeImage(WorldEntity terre){
		Image image = null;
		checkEdgeCondition(terre);
		if(upLeftCondition){
			image = imageClasse.getImagesWall()[numberMap][2];
		}else if(upDownCondition){
			image = imageClasse.getImagesWall()[numberMap][1];
		}else if (downLeftCondition){
			image = imageClasse.getImagesWall()[numberMap][5];
		}else if(leftRightCondition){
			image = imageClasse.getImagesWall()[numberMap][0];
		}else if(downRightCondition){
			image = imageClasse.getImagesWall()[numberMap][4];
		}else if(upRightCondition){
			image = imageClasse.getImagesWall()[numberMap][3];
		}
		return image;
	}
	
	private void checkEdgeCondition(WorldEntity terre){
		upLeftCondition = terre.getPosX().equals(0) && terre.getPosY().equals(0);
		upDownCondition = (terre.getPosX().equals(0) && !terre.getPosY().equals(0)
				&& !terre.getPosY().equals(listTerrain.get(listTerrain.size()-1).getPosY())) 
				|| (terre.getPosX().equals(listTerrain.get(listTerrain.size()-1).getPosX()) 
				&& !terre.getPosY().equals(0) && !terre.getPosY().equals(listTerrain.get(listTerrain.size()-1).getPosY()));
		downLeftCondition = (terre.getPosX().equals(0) && terre.getPosY().equals(listTerrain.get(listTerrain.size()-1).getPosY()));
		leftRightCondition = (terre.getPosY().equals(0) && !terre.getPosX().equals(0) && 
				!terre.getPosX().equals(listTerrain.get(listTerrain.size()-1).getPosX())) 
				|| (terre.getPosY().equals(listTerrain.get(listTerrain.size()-1).getPosY()) 
				&& !terre.getPosX().equals(0) && !terre.getPosX().equals(listTerrain.get(listTerrain.size()-1).getPosX()));
		downRightCondition = terre.getPosX().equals(listTerrain.get(listTerrain.size()-1).getPosX()) 
				&& terre.getPosY().equals(listTerrain.get(listTerrain.size()-1).getPosY());
		upRightCondition = terre.getPosY().equals(0) && terre.getPosX().equals(listTerrain.get(listTerrain.size()-1).getPosX());
		allConditionEdge = !upLeftCondition && !upDownCondition && !downLeftCondition && !leftRightCondition && 
				!downRightCondition && !upRightCondition;
	}
	
	private void isHeros(Creatures creature, Graphics g){
		for (Integer i = 0; i<4; i++){
			if(creature.name().equals(typeHeros[i])){
				Image imageHeros = imageClasse.getImagesHeros()[i][creature.getDirection()][creature.getMoveContinue()];
				g.drawImage(imageHeros,creature.getPosX()/divided, creature.getPosY()/divided, size/divided, size/divided, null);
			}
		}
	}
	
	private void isMonster(Creatures creature, Graphics g){
		if(creature.name().equals("Monster")){
			Image imageMonster = imageClasse.getImagesMonsters()[numberMap][((Creatures) creature).getDirection()][((Creatures) creature).getMoveContinue()];
			if (numberMap.equals(4)){
				imageMonster = imageClasse.getImagesMonsters()[numberMap-4][((Monster) creature).getDirection()][((Monster) creature).getMoveContinue()];
				g.drawImage(imageMonster, creature.getPosX()/divided, creature.getPosY()/divided, (size+10)/divided, (size+10)/divided, null);
			}else{
				g.drawImage(imageMonster, creature.getPosX()/divided, creature.getPosY()/divided, size/divided, size/divided, null);
			}
		}
	}
	
	public void addKeyboard(Integer playerNumber){
		this.playerNumber = playerNumber;
		listener = new Keyboard(playerNumber, this);
	}
	
	private void setPosMonster(){
		controller.doActionMonsters();
	}
	
	private void setPosHeros(){
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

	public void setEntities(ArrayList<WorldEntity> entities) {
		if(entities.get(0).nameType().equals("Terrain"))
			this.listTerrain = entities;
		else if(entities.get(0).nameType().equals("Monster"))
			this.listMonster= entities;
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
