package View;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import Model.WorldEntity;


public class GamePanel extends Panel {
	
	private ArrayList<WorldEntity> listHero =  new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listTerrain = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listObject = new ArrayList<WorldEntity>();
	private boolean upLeftCondition, upDownCondition, downLeftCondition, leftRightCondition, downRightCondition, upRightCondition, allConditionEdge;
	private LoadImage imageClasse;
	private Integer numberMap;
	
	public GamePanel(Panel panel){
		super(panel);
		this.setBounds(0, 0, 700, 600);
		this.setSize(new Dimension(700,600));
		imageClasse = new LoadImage();
		imageClasse.chargerImage();
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
         
	public void paintComponent(Graphics g){
		for (WorldEntity terre : listTerrain ){
			if(terre.getVisible()){
				checkCondition(terre);
				Image image = null;
				System.out.println(numberMap);
				if(upLeftCondition){
					image = imageClasse.getImagesWall()[numberMap-1][2];
				}else if(upDownCondition){
					image = imageClasse.getImagesWall()[numberMap-1][1];
				}else if (downLeftCondition){
					image = imageClasse.getImagesWall()[numberMap-1][5];
				}else if(leftRightCondition){
					image = imageClasse.getImagesWall()[numberMap-1][0];
				}else if(downRightCondition){
					image = imageClasse.getImagesWall()[numberMap-1][4];
				}else if(upRightCondition){
					image = imageClasse.getImagesWall()[numberMap-1][3];
				}else if(terre.getClass().getName().equals("Model.Wall")){
					image = imageClasse.getImagesWall()[numberMap-1][7];
				}else if(terre.getClass().getName().equals("Model.Sol")){
					image = imageClasse.getImagesGround()[numberMap-1];
				}else {
					image = imageClasse.getImagesWall()[numberMap-1][3];
				}
				g.drawImage(image,terre.getPosX(), terre.getPosY(), terre.getWidth(), terre.getHeight(), null);
			}
		}
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

	public void setNumberMap(int numberMap) {
		this.numberMap = numberMap;
	}
	
	
	
	
	
	
		/**
		for (WorldEntity mob : listMonster )
		{
			if(mob.getVisible()){
				Image img = afficheImage.images(mob.nameImage());
				g.drawImage(img,mob.getPosX(), mob.getPosY(), mob.getWidth(), mob.getHeight(), null);
			}
		}
			
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
