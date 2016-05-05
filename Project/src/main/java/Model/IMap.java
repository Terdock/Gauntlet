package Model;

public interface IMap {

	public Integer getNumberOfDoor();

	public void setNumberOfDoor(Integer numberOfDoor);

	public PlateauObject[][] createListTerrain(Integer nombreLigne, Integer nombreColonne, PlateauObject[][] listTerrain);

	public PlateauObject[][] createListTerrainArene(Integer nombreLigne, Integer nombreColonne,PlateauObject[][] listTerrain);
	
	public Creatures[] getListMonster();
	
	public PlateauObject newSol(Integer posX,Integer posY);

	public void createBattallons(Integer numberMap,Integer nombreColonneArene, Integer nombreLigneArene);
	
	public Exit getExit();

}