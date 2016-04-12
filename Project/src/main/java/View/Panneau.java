/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package View;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
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
public class Panneau extends JPanel {
	
	private ArrayList<WorldEntity> listHero =  new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listMonster = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listTerrain = new ArrayList<WorldEntity>();
	private ArrayList<WorldEntity> listObject = new ArrayList<WorldEntity>();
	

	public void setEntities(ArrayList<WorldEntity> entities) {
		if(entities.get(0).nameType() == "Terrain")
			this.listTerrain = entities;
		else if(entities.get(0).nameType() == "Hero")
			this.listHero = entities;
		else if(entities.get(0).nameType() == "Monster")
			this.listMonster= entities;
		else if(entities.get(0).nameType() == "Object");
			this.listObject = entities;
	}

	
	

}
