package Model;

import java.util.ArrayList;

public interface IPlateau {

	public Integer getNumberMap();
	
	public void setListTerrain(WorldEntity[][] listTerrain) ;

	public boolean isMoveValide(Integer posX, Integer posY, String action);

	public PlateauObject[][] getListTerrain();
	
	public abstract Heros[] getListHeros();
	
	public void attacHeros(Integer player);
	
	public abstract void checkAttackMonster();

	public void Initialisation(Integer nombreLigne, Integer nombreColonne, String gameMode, String[][] playerRegister);

	public void remplace(PlateauObject sol);

}