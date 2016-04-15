/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package View;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Model.WorldEntity;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Panneau.
 * 
 * @author Edith
 */
public class GamePanel extends Panel {
	
	private ArrayList<WorldEntity> listHero =  new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listTerrain = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listObject = new ArrayList<WorldEntity>();
	private afficheImage ImageClasse = new afficheImage();
	
	
	

	public void setEntities(ArrayList<WorldEntity> entities) {
		if(entities.get(0).nameType() == "Terrain")
			this.listTerrain = entities;
		else if(entities.get(0).nameType() == "Hero")
			this.listHero = entities;
		else if(entities.get(0).nameType() == "Monster")
			this.listMonster= entities;
		else if(entities.get(0).nameType() == "Object")
			this.listObject = entities;
			
		
	}

	
	
         
	public void paintComponent(Graphics g)
	{
		for (WorldEntity terre : listTerrain )
		{
			if(terre.getVisible()){
				Image img = afficheImage.images(terre.nameImage());
				g.drawImage(img, terre.getWidth(), terre.getHeight(),terre.getPosX()*terre.getWidth(), terre.getPosY()*terre.getHeight(), null);
			}
		}
		
		/**
		for (WorldEntity mob : listMonster )
		{
			if(mob.getVisible()){
				Image img = afficheImage.images(mob.nameImage());
				g.drawImage(img, mob.getWidth(), mob.getHeight(),mob.getPosX()*mob.getWidth(), mob.getPosY()*mob.getHeight(), null);
			}
		}
			
		for (WorldEntity player : listHero )
		{	if(player.getVisible()){
				Image img = afficheImage.images(player.nameImage());
				g.drawImage(img, player.getWidth(), player.getHeight(),player.getPosX()*player.getWidth(), player.getPosY()*player.getHeight(), null);
			}
		}
		for (WorldEntity obj : listObject )
		{
			if(obj.getVisible()){
				Image img = afficheImage.images(obj.nameImage());
				g.drawImage(img, obj.getWidth(), obj.getHeight(),obj.getPosX()*obj.getWidth(), obj.getPosY()*obj.getHeight(), null);
			}
		}
		**/
		repaint();
	}

}
