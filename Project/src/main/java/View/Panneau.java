/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package View;

import java.util.ArrayList;

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
	
	private ArrayList<WorldEntity> listHero;
	private ArrayList<WorldEntity> listMonster;
	private ArrayList<WorldEntity> listTerrain;
	private ArrayList<WorldEntity> listObject;
	

	public void setEntities(ArrayList<WorldEntity> entities) {
		if(entities.get(0).nameType() == "Terrain")
			this.listTerrain = entities;
		else if(entities.get(0).nameType() == "Hero")
			this.listHero = entities;
		else if(entities.get(0).nameType() == "Monster")
			this.listMonster= entities;
		else if(entities.get(0).nameType() == "Object");
	}
	
	

}
