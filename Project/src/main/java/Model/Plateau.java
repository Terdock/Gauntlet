package Model;

import java.util.ArrayList;

public class Plateau implements IPlateau {
	private int nombreLigne;
	private int nombreColonne;
	private final static int nombreLigneArene = 50;
	private final static int nombreColonneArene = 50;
	private static int width = 30;
	private static int height = 30;
	private ArrayList<Monster> listMonster = new ArrayList<Monster>(); 
	private ArrayList<PlateauObject> listTerrain = new ArrayList<PlateauObject>();
	private ArrayList<PlateauObject> listTerrainArene = new ArrayList<PlateauObject>();
	private ArrayList<Wall> listWallMap = new ArrayList<Wall>();
	private ArrayList<Door> listDoor = new ArrayList<Door>();
	private Staircase staircaseMap = new Staircase(true);
	private Hole holeMap = new Hole(nombreLigne-60,nombreColonne-60,true);
	private int numberMap;
	private Map mapParLevel;
	
	
	
	public ArrayList<Monster> getListMonster() {
		return listMonster;
	}


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
		else if (mode == "Mode Arène"){
			Initialisation(nombreLigne,nombreColonne,listTerrainArene,mode);
			listTerrain = listTerrainArene;
		}
		else if (mode == "Mode Survivor"){
			Initialisation(nombreLigne,nombreColonne,listTerrainArene,mode);
			listTerrain = listTerrainArene;
		}
	}	
	

	public Plateau() {
		// TODO Auto-generated constructor stub
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
				if (posX==0 || posY == 0 || posX == nombreColonne + 1|| posY == nombreLigne + 1){
					listTerrain.add(new Wall(posX, posY, false, numberMap));
				}
				else {
					listTerrain.add(new Sol(posX, posY, true, numberMap));
				}
			}	
		}
	}
	
	private void Wall_replace_sol(){
		for (Wall wallMap : listWallMap){
				int posX = wallMap.getPosX();
				int posY = wallMap.getPosY();
				listTerrain.remove(indiceTerrain(posX,posY));
				listTerrain.add(indiceTerrain(posX,posY),wallMap);
			}
		}
		
	private void Door_replace_Wall(){
		for (Door door : listDoor){
				int posX = door.getPosX();
				int posY = door.getPosY();
				listTerrain.remove(indiceTerrain(posX,posY));
				listTerrain.add(indiceTerrain(posX,posY),door);
			}
		}
	
	private void Staircase_replace_Wall(){
		int posX = staircaseMap.getPosX();
		int posY = staircaseMap.getPosY();
		listTerrain.remove(indiceTerrain(posX,posY));
		listTerrain.add(indiceTerrain(posX,posY),staircaseMap);
	}
	
	
	private void Hole_replace_Wall(){
		int posX = holeMap.getPosX();
		int posY = holeMap.getPosY();
		listTerrain.remove(indiceTerrain(posX,posY));
		listTerrain.add(indiceTerrain(posX,posY),holeMap);
		 
	}
	
	public int indiceTerrain(int posX,int posY){
		return (posY)/30*(nombreColonne+2)+(posX)/30;
	}
	
	
	
	private void create_MAP(){
		Map map = new Map(nombreLigne, nombreColonne);
		staircaseMap = map.create_Staircase0();
		if(numberMap == 0){
			this.listWallMap = map.create_MAP0();
			this.listDoor = map.create_Door0();
			this.holeMap = map.create_Hole0();
			this.listMonster = map.create_Monster0();
		}
		else if(numberMap == 1){
			this.listWallMap = map.create_MAP1();
			this.listDoor = map.create_Door1();
			this.holeMap = map.create_Hole1();
			this.listMonster = map.create_Monster1();
		}
		else if(numberMap == 2){
			this.listWallMap = map.create_MAP2();
		 	this.listDoor = map.create_Door2();
		 	this.holeMap = map.create_Hole2();
		 	this.listMonster = map.create_Monster2();
		}
		 else if(numberMap == 3){
			listWallMap = map.create_MAP3();
			listDoor = map.create_Door3();
			holeMap = map.create_Hole3();
			this.listMonster = map.create_Monster3();
		 }
		else if(numberMap == 4){
			listWallMap = map.create_MAP4();
			listDoor = map.create_Door4();
			holeMap = map.create_Hole4();
			this.listMonster = map.create_Monster4();
		}
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


	public boolean isMoveValide(int posX, int posY) {
		listTerrain.get(indiceTerrain(posX,posY)).isPassable();
		return listTerrain.get(indiceTerrain(posX,posY)).isPassable();
	}


}
