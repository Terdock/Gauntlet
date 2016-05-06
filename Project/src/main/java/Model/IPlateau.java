package Model;

public interface IPlateau {

	//Carte visite des classes implémentant l'interface IPlateau
	public boolean isMoveValide(Integer posX, Integer posY, String action);
	public void checkAttackMonster(Integer nombreColonne,Integer nombreLigne);
	public void Initialisation(String mode, Creatures[] listHeros);
	public void openDoor(Integer posX, Integer posY);
	public void battallons(Integer numberOfBattallons);
	public void setListHeros(Creatures[] listHeros);
	public void setNumberLineMode(Integer numberLineMode);
	public void setNumberColumnMode(Integer numberColumnMode);
	public Creatures[] getListMonster();
	public IMap getMap(); 
	public WorldEntity[][] getListTerrain();
}