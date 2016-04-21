package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Controller.AbstractController;
import Model.Monster;
import Model.WorldEntity;


public class GamePanel extends Panel {
	
	private ArrayList<WorldEntity> listHero =  new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listTerrain = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listObject = new ArrayList<WorldEntity>();
	private AbstractController controller;
	private Keyboard listener;
	private boolean upLeftCondition, upDownCondition, downLeftCondition, leftRightCondition, downRightCondition, upRightCondition, allConditionEdge;
	private LoadImage imageClasse;
	private Integer numberMap, divided, playerNumber;
	
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
		for (WorldEntity terre : listTerrain ){
			if(terre.getVisible()){
				checkCondition(terre);
				Image image = null;
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
				}else if(terre.getClass().getName().equals("Model.Wall")){
					image = imageClasse.getImagesWall()[numberMap][terre.getForm()];
				}else if(terre.getClass().getName().equals("Model.Sol")){
					image = imageClasse.getImagesGround()[numberMap];
				}else if (terre.getClass().getName().equals("Model.Door")){
					image = imageClasse.getImageDoor();
				}else {
					image = imageClasse.getImagesWall()[numberMap][terre.getForm()];
				}
				g.drawImage(image,terre.getPosX()/divided, terre.getPosY()/divided, terre.getWidth()/divided, terre.getHeigth()/divided, null);
			}
		}
		for (WorldEntity mob : listMonster ){
			if(mob.getVisible()){
					
				if(numberMap.equals(3)){
				Image image = imageClasse.getImagesMonsters()[numberMap-2][((Monster) mob).getDirection()][((Monster) mob).getMoveContinue()];
				g.drawImage(image,mob.getPosX()/divided, mob.getPosY()/divided, (mob.getWidth()+5)/divided, (mob.getHeigth()+5)/divided, null);
				}
				else if (numberMap.equals(4)){
					Image image = imageClasse.getImagesMonsters()[numberMap-4][((Monster) mob).getDirection()][((Monster) mob).getMoveContinue()];
					g.drawImage(image,mob.getPosX()/divided, mob.getPosY()/divided, (mob.getWidth()+10)/divided, (mob.getHeigth()+10)/divided, null);
				}
				else{
					Image image = imageClasse.getImagesMonsters()[numberMap][((Monster) mob).getDirection()][((Monster) mob).getMoveContinue()];
					g.drawImage(image,mob.getPosX()/divided, mob.getPosY()/divided, mob.getWidth()/divided, mob.getHeigth()/divided, null);
				
				}
			}
		}
		for (WorldEntity heros : listHero){
			if(heros.getVisible()){
				if (heros.nameImage().equals("Warrior")){
					Image image = imageClasse.getImagesHeros()[0][0][0];
					g.drawImage(image,heros.getPosX()/divided, heros.getPosY()/divided, heros.getWidth()/divided, heros.getHeigth()/divided, null);
				}
			}
		}
		setPosHeros();
		setPosMonsters();
		repaint();
	}

	private void checkCondition(WorldEntity terre){
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
		allConditionEdge = !upLeftCondition && !upDownCondition && !downLeftCondition && !leftRightCondition && !downRightCondition && !upRightCondition;
	}
	
	public void addKeyboard(Integer playerNumber){
		this.playerNumber = playerNumber;
		listener = new Keyboard(playerNumber, this);
	}
	
	private void setPosMonsters(){
		//controller.
	}
	
	private void setPosHeros(){
		for(Integer i = 0; i < playerNumber; i++){
			String action = listener.state(i);
			if (!action.equals("Action Stop")){
				controller.doActionHeros(action, i);
			}
		}
	}
	

	public void setNumberMap(int numberMap) {
		this.numberMap = numberMap;
	}

	public void setEntities(ArrayList<WorldEntity> entities) {
		if(entities.get(0).nameType().equals("Terrain"))
			this.listTerrain = entities;
		else if(entities.get(0).nameType().equals("Hero"))
			this.listHero = entities;
		else if(entities.get(0).nameType().equals("Monster"))
			this.listMonster= entities;
		else if(entities.get(0).nameType().equals("Object"))
			this.listObject = entities;
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
