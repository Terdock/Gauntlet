package Model;

public interface IMap {
	
	public PlateauObject[][] createListTerrain(Integer nombreLigne, Integer nombreColonne, PlateauObject[][] listTerrain);
	public Creatures[] getListMonster();
	public PlateauObject newSol(Integer posX,Integer posY);
	public void createBattallons(Integer numberMap,Integer nombreColonneArene, Integer nombreLigneArene);
	public Exit getExit();

}