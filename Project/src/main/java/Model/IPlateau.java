package Model;

public interface IPlateau {

	public Integer getNumberMap();
	
	public void setListTerrain(WorldEntity[][] listTerrain) ;

	public boolean isMoveValide(Integer posX, Integer posY, String action);

	public WorldEntity[][] getListTerrain();
	
	public abstract Heros[] getListHeros();
	
	public abstract void checkAttackMonster(Integer nombreColonne,Integer nombreLgien);

	public void Initialisation(Integer nombreLigne, Integer nombreColonne,Integer nombreColonneSurvivor, Integer nombreLigneSurvivor, String gameMode, String[][] playerRegister);

	public void Initialisation(Integer nombreLigne,Integer nombreColonne,Integer nombreColonneSurvivor, Integer nombreLigneSurvivor, String mode,Creatures[] listHeros);

	public void openDoor(Integer posX, Integer posY);

	public void battallons(Integer numberOfBattallons);

	public Creatures[] getListMonster();

	public void setNumberMap(Integer numberMap);
	
	public IMap getMap(); 
	
	public void setNombreLigneSurvivor(Integer nombreLigneSurvivor);

	public void setNombreColonneSurvivor(Integer nombreColonneSurvivor);

}