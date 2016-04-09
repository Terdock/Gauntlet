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
	
	ArrayList<WorldEntity> list_Terrain;
	ArrayList<WorldEntity> list_Terrain_arene;
	ArrayList<WorldEntity> list_Hero;
	ArrayList<WorldEntity> list_Monster;
	public Panneau() {

		
		
	}
	public void setList_Terrain(ArrayList<WorldEntity> list_Terrain) {
		this.list_Terrain = list_Terrain;
	}
	public void setList_Terrain_arene(ArrayList<WorldEntity> list_Terrain_arene) {
		this.list_Terrain_arene = list_Terrain_arene;
	}
	public void setList_Hero(ArrayList<WorldEntity> list_Hero) {
		this.list_Hero = list_Hero;
	}
	public void setList_Monster(ArrayList<WorldEntity> list_Monster) {
		this.list_Monster = list_Monster;
	}
	
	
	public void afficheEntities(ArrayList<WorldEntity> list_entity){
		for (int i = 0; i < list_entity.size(); i++ )
			afficheImage.image(list_entity.get(i).nameImage(),list_entity.get(i).getPos_x(),list_entity.get(i).getPos_y());
		
		
	}

}
