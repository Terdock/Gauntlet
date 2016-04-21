package Model;

import java.util.ArrayList;

public interface IPlateau {

	public Integer getNumberMap();
	
	public ArrayList<Monster> getListMonster();

	public ArrayList<PlateauObject> getLIST_TERRAIN();

	public ArrayList<PlateauObject> getLIST_TERRAIN_Arene();

	public boolean isMoveValide(Integer i, Integer j);
	
	public boolean isMoveValide(Integer posX, Integer posY, String action);


}