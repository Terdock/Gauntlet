package Model;

import java.util.ArrayList;

public interface IPlateau {

	public Integer getNumberMap();
	

	public void setListTerrain(ArrayList<PlateauObject> listTerrain) ;

	public boolean isMoveValide(Integer i, Integer j);
	
	public boolean isMoveValide(Integer posX, Integer posY, String action);

	public WorldEntity[][] getListTerrain();


}