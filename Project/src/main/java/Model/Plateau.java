package Model;

import java.util.ArrayList;

public class Plateau implements IPlateau {
	private int nombreLigne;
	private int nombreColonne;
	private final static int nombreLigneArene = 50;
	private final static int nombreColonneArene = 50;
	private static int width = 30;
	private static int height = 30;
	private ArrayList<PlateauObject> listTerrain = new ArrayList<PlateauObject>();
	private ArrayList<PlateauObject> listTerrainArene = new ArrayList<PlateauObject>();
	private ArrayList<Wall> listWallMap = new ArrayList<Wall>();
	private ArrayList<Door> listDoor = new ArrayList<Door>();
	private Staircase staircaseMap = new Staircase(true);
	private Hole holeMap = new Hole(nombreLigne-60,nombreColonne-60,true);
	private int numberMap;
	
	
	
	public Plateau(int nombreLigne, int nombreColonne,int numberMap,String mode) {
		this.nombreLigne = nombreLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
		if (mode == "Mode Quête"){
			Initialisation(nombreLigne,nombreColonne,listTerrain,mode);
			create_MAP();
			Hole_replace_Wall();
			Staircase_replace_Wall();
			}
		else if (mode == "Mode Arène")
			Initialisation(nombreLigne,nombreColonne,listTerrainArene,mode);
		else if (mode == "Mode Survivor")
			Initialisation(nombreLigne,nombreColonne,listTerrainArene,mode);
			
	}	
	

	private void Initialisation(int nombreLigne,int nombreColonne, ArrayList<PlateauObject> listTerrain,String mode){
		if (mode == "Mode Quête"){
			create_list_terrain(nombreLigne,nombreColonne,listTerrain);
			Wall_replace_sol();
			Door_replace_Wall();
		}
		create_list_terrain(nombreLigneArene,nombreColonneArene,listTerrainArene);
		
		
	}
	
	/**
	 * Initialisation des types blocs incassables autour et terrain à l'intérieur du plateau
	 * Dans la LIST_TERRAIN
	 */
	private void create_list_terrain(int nombreLigne, int nombreColonne,ArrayList<PlateauObject> listTerrain){
		for (int posY = 0; posY <= nombreLigne + 1; posY++){
			for (int posX = 0; posX<= nombreColonne + 1; posX++){
				if (posX==0 || posY == 0 || posX == nombreColonne + 1|| posY == nombreLigne + 1)
				{
					listTerrain.add(new Wall(posX, posY, false, numberMap));
				}
				else 
				{
					listTerrain.add(new Sol(posX, posY, true, numberMap));
				}
			}	
		}
	}
	
	private void Wall_replace_sol(){
		for (Wall wallMap : listWallMap){
				int wallPosX = wallMap.getPosX();
				int wallPosY = wallMap.getPosY();
				int indiceTerrain = (wallPosY)/30*(nombreColonne+2)+(wallPosX)/30;
				listTerrain.remove(indiceTerrain);
				listTerrain.add(indiceTerrain,wallMap);
			}
		}
		
	private void Door_replace_Wall(){
		for (Door door : listDoor){
				int doorPosX = door.getPosX();
				int doorPosY = door.getPosY();
				int indiceTerrain = (doorPosY)/30*(nombreColonne+2)+(doorPosX)/30;
				listTerrain.remove(indiceTerrain);
				listTerrain.add(indiceTerrain,door);
			}
		}
	
	private void Staircase_replace_Wall(){
		int staircasePosX = staircaseMap.getPosX();
		int staircasePosY = staircaseMap.getPosY();
		int indiceTerrain = (staircasePosY)/30*(nombreColonne+2)+(staircasePosX)/30;
		listTerrain.remove(indiceTerrain);
		listTerrain.add(indiceTerrain,staircaseMap);
	}
	
	
	private void Hole_replace_Wall(){
		int holePosX = holeMap.getPosX();
		int holePosY = holeMap.getPosY();
		int indiceTerrain = (holePosY)/30*(nombreColonne+2)+(holePosX)/30;
		listTerrain.remove(indiceTerrain);
		listTerrain.add(indiceTerrain,holeMap);
		 
	}
	
	
	
	
	private void create_MAP(){
		Map map = new Map();
		staircaseMap = map.create_Staircase0();
		if(numberMap == 0)
			listWallMap = map.create_MAP0();
			listDoor = map.create_Door0();
			holeMap = map.create_Hole0();
		if(numberMap == 1)
			listWallMap = map.create_MAP1();
			listDoor = map.create_Door1();
			holeMap = map.create_Hole1();
		if(numberMap == 2)
			listWallMap = map.create_MAP2();
		 	listDoor = map.create_Door2();
		 	holeMap = map.create_Hole2();
		if(numberMap == 3)
			listWallMap = map.create_MAP3();
			listDoor = map.create_Door3();
			holeMap = map.create_Hole3();
		if(numberMap == 4)
			listWallMap = map.create_MAP4();
			listDoor = map.create_Door4();
			holeMap = map.create_Hole4();
	}
	
	

	public int getNombreLigne() {
		return nombreLigne;
	}

	public void setNombreLigne(int nombreLigne) {
		this.nombreLigne = nombreLigne;
	}

	public int getNombreColonne() {
		return nombreColonne;
	}

	public void setNombreColonne(int nombreColonne) {
		this.nombreColonne = nombreColonne;
	}
	

	public ArrayList<Wall> getListWallMap() {
		return listWallMap;
	}

	public void setListWallMap(ArrayList<Wall> listWallMap) {
		this.listWallMap = listWallMap;
	}

	public ArrayList<Door> getListDoor() {
		return listDoor;
	}

	public void setListDoor(ArrayList<Door> listDoor) {
		this.listDoor = listDoor;
	}

	public int getNumberMap() {
		return numberMap;
	}

	public void setNumberMap(int numberMap) {
		this.numberMap = numberMap;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public ArrayList<PlateauObject> getLIST_TERRAIN() {
		return listTerrain;
	}

	public void setLIST_TERRAIN(ArrayList<PlateauObject> listTerrain) {
		this.listTerrain = listTerrain;
	}

	public ArrayList<PlateauObject> getLIST_TERRAIN_Arene() {
		return listTerrainArene;
	}

	public void setLIST_TERRAIN_Arene(ArrayList<PlateauObject> listTerrainArene) {
		this.listTerrainArene = listTerrainArene;
	}


}
