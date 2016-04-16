package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.WorldEntity;


public class GamePanel extends Panel {
	
	private ArrayList<WorldEntity> listHero =  new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listTerrain = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listObject = new ArrayList<WorldEntity>();
	private afficheImage imageClasse;
	
	public GamePanel(Panel panel, String type){
		super(panel, type);
		imageClasse = new afficheImage();
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
				Image img = imageClasse.images(terre.nameImage());
				g.drawImage(img,terre.getPosX(), terre.getPosY(), terre.getWidth(), terre.getHeight(), null);
			}
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
		repaint();
	}

}
