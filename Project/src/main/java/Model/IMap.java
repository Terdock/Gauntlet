package Model;

public interface IMap {

	public Integer getNumberOfDoor();

	public void setNumberOfDoor(Integer numberOfDoor);

	public PlateauObject[][] createListTerrain(Integer nombreLigne, Integer nombreColonne, PlateauObject[][] listTerrain);

	public Creatures[] getListMonster();

	public void openDoor(Integer posX, Integer posY);


}