package Model;

import java.util.ArrayList;

public class Plateau implements IPlateau {
	private Integer nombreLigne;
	private Integer nombreColonne;
	private final static Integer nombreLigneArene = 23;
	private final static Integer nombreColonneArene = 19;
	private static Integer width = 30;
	private static Integer height = 30;
	private Integer numberMap;
	private Map mapParLevel;
	private PlateauObject[][] listTerrain;
	private PlateauObject[][] listTerrain2;

	public void setListTerrain(PlateauObject[][] listTerrain) {
		this.listTerrain = listTerrain;
	}

	public Plateau(Integer nombreLigne, Integer nombreColonne,Integer numberMap,String mode) {
		this.nombreLigne = nombreLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
		this.mapParLevel = new Map(nombreLigne, nombreColonne,numberMap);
		this.listTerrain = new PlateauObject[nombreLigne][nombreColonne];
		this.listTerrain2 = new PlateauObject[nombreLigne][nombreColonne];
		Initialisation(nombreLigne,nombreColonne,listTerrain,mode);
	}	
	


	private void Initialisation(Integer nombreLigne,Integer nombreColonne, PlateauObject[][] listTerrain,String mode){
		listTerrain2 = mapParLevel.createListTerrain(nombreLigneArene,nombreColonneArene,listTerrain2);
		if (mode.equals("Mode Quête")){
			listTerrain = mapParLevel.createListTerrain(nombreLigne,nombreColonne,listTerrain);
		}
		else{
			listTerrain = listTerrain2;
		}
		
		//listHero =  
		//listMonster = 
	}
	
	
	

	
	/**
	 * Initialisation des types blocs incassables autour et terrain à l'Integerérieur du plateau
	 * Dans la LIST_TERRAIN
	 */
	
	
	private void wallReplaceGround(){
		for (PlateauObject wallMap : listWallMap){
				Integer posX = wallMap.getPosX();
				Integer posY = wallMap.getPosY();
				listTerrain.set(indiceTerrain(posX,posY), wallMap);
			}
		}
		
	private void doorReplaceGround(){
		for (PlateauObject door : listDoor){
				Integer posX = door.getPosX();
				Integer posY = door.getPosY();
				listTerrain.set(indiceTerrain(posX,posY), door);
			}
	}
	
	private void Staircase_replace_Wall(){
		Integer posX = staircaseMap.getPosX();
		Integer posY = staircaseMap.getPosY();
		listTerrain.set(indiceTerrain(posX,posY),staircaseMap);
	}
	
	
	private void Hole_replace_Wall(){
		Integer posX = holeMap.getPosX();
		Integer posY = holeMap.getPosY();
		listTerrain.set(indiceTerrain(posX,posY),holeMap);
	}
	
	public Integer indiceTerrain(Integer posX,Integer posY){
		return ((posY/height)*(nombreColonne+2)+(posX)/height);
	}
	
	
	private void create_MAP(){
		staircaseMap = mapParLevel.create_Staircase0();
		if(numberMap == 0){
			this.listWallMap = mapParLevel.create_MAP0();
			this.holeMap = mapParLevel.create_Hole0();
			this.listMonster = mapParLevel.create_Monster0();
		}
		else if(numberMap == 1){
			this.listWallMap = mapParLevel.create_MAP1();
			this.holeMap = mapParLevel.create_Hole1();
			this.listMonster = mapParLevel.create_Monster1();
		}
		else if(numberMap == 2){
			this.listWallMap = mapParLevel.create_MAP2();
		 	this.holeMap = mapParLevel.create_Hole2();
		 	this.listMonster = mapParLevel.create_Monster2();
		}
		 else if(numberMap == 3){
			listWallMap = mapParLevel.create_MAP3();
			holeMap = mapParLevel.create_Hole3();
			this.listMonster = mapParLevel.create_Monster3();
		 }
		else if(numberMap == 4){
			listWallMap = mapParLevel.create_MAP4();
			holeMap = mapParLevel.create_Hole4();
			this.listMonster = mapParLevel.create_Monster4();
		}
		listDoor = mapParLevel.create_Door();
	}
	
	

	public Integer getNombreLigne() {
		return nombreLigne;
	}

	public void setNombreLigne(Integer nombreLigne) {
		this.nombreLigne = nombreLigne;
	}

	public Integer getNombreColonne() {
		return nombreColonne;
	}

	public void setNombreColonne(Integer nombreColonne) {
		this.nombreColonne = nombreColonne;
	}
	
	public static Integer getNombrelignearene() {
		return nombreLigneArene;
	}


	public static Integer getNombrecolonnearene() {
		return nombreColonneArene;
	}

	

	public ArrayList<PlateauObject> getListWallMap() {
		return listWallMap;
	}

	public void setListWallMap(ArrayList<PlateauObject> listWallMap) {
		this.listWallMap = listWallMap;
	}

	public ArrayList<PlateauObject> getListDoor() {
		return listDoor;
	}

	public void setListDoor(ArrayList<PlateauObject> listDoor) {
		this.listDoor = listDoor;
	}

	public Integer getNumberMap() {
		return numberMap;
	}

	public void setNumberMap(Integer numberMap) {
		this.numberMap = numberMap;
	}


	public static Integer getWidth() {
		return width;
	}

	public static Integer getHeight() {
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

	public boolean isMoveValide(Integer posX, Integer posY) {
		listTerrain.get(indiceTerrain(posX,posY)).isPassable();
		return listTerrain.get(indiceTerrain(posX,posY)).isPassable();
	}

	public boolean isMoveValide(Integer posX, Integer posY, String action) {
		boolean passable = true;
		if (action.equals("Action Up")){
			passable = listTerrain.get(indiceTerrain(posX,posY-30)).isPassable();
		}else if(action.equals("Action Down")){
			passable = listTerrain.get(indiceTerrain(posX,posY+30)).isPassable();
		}else if(action.equals("Action Right")){
			passable = listTerrain.get(indiceTerrain(posX+30,posY)).isPassable();
		}else if(action.equals("Action Left")){
			passable = listTerrain.get(indiceTerrain(posX-30,posY)).isPassable();
		}
		return passable;
	}


	@Override
	public WorldEntity[][] getListTerrain() {
		// TODO Auto-generated method stub
		return null;
	}
}
