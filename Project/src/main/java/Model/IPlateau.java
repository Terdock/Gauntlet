package Model;

public interface IPlateau {

	//Carte visite des classes implémentant l'interface IPlateau
	public Integer getNumberMap();
	public void setListTerrain(WorldEntity[][] listTerrain) ;
	public boolean isMoveValide(Integer posX, Integer posY, String action);
	public WorldEntity[][] getListTerrain();
	public abstract void checkAttackMonster(Integer nombreColonne,Integer nombreLigne);
	public void Initialisation(String mode, Creatures[] listHeros);
	public void openDoor(Integer posX, Integer posY);
	public void battallons(Integer numberOfBattallons);
	public Creatures[] getListMonster();
	public void setListHeros(Creatures[] listHeros);
	public void setNumberMap(Integer numberMap);
	public IMap getMap(); 
	public void setNumberLineMode(Integer numberLineMode);
	public void setNumberColumnMode(Integer numberColumnMode);
}