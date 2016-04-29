package Model;

import java.util.ArrayList;

public interface IPlateau {

	public Integer getNumberMap();
	
	public void setListTerrain(WorldEntity[][] listTerrain) ;

	public boolean isMoveValide(Integer posX, Integer posY, String action);

	public WorldEntity[][] getListTerrain();
	
	public abstract Heros[] getListHeros();
	
	public void attacHeros(Integer player);
	
	public abstract void checkAttackMonster();

	public void Initialisation(Integer nombreLigne, Integer nombreColonne, String gameMode, String[][] playerRegister);

	public void openDoor(Integer posX, Integer posY);

}