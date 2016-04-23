package Model;

public interface IMap {

	Integer getNumberOfDoor();

	void setNumberOfDoor(Integer numberOfDoor);

	PlateauObject[][] createListTerrain(Integer nombreLigne, Integer nombreColonne, PlateauObject[][] listTerrain);

	Creatures[] getListMonster();

}