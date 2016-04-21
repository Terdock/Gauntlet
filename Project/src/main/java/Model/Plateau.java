package Model;

import java.util.ArrayList;

public class Plateau implements IPlateau {
	private Integer nombreLigne;
	private Integer nombreColonne;
	private final static Integer nombreLigneArene = 23;
	private final static Integer nombreColonneArene = 19;
	private static Integer width = 30;
	private static Integer height = 30;
	private ArrayList<Monster> listMonster = new ArrayList<Monster>(); 
	private ArrayList<PlateauObject> listTerrain = new ArrayList<PlateauObject>();
	private ArrayList<PlateauObject> listTerrainArene = new ArrayList<PlateauObject>();
	private ArrayList<PlateauObject> listWallMap = new ArrayList<PlateauObject>();
	private ArrayList<PlateauObject> listDoor = new ArrayList<PlateauObject>();
	private PlateauObject staircaseMap;
	private PlateauObject holeMap;
	private Integer numberMap;
	private Map mapParLevel;
	
	
	
	public ArrayList<Monster> getListMonster() {
		return listMonster;
	}


	public Plateau(Integer nombreLigne, Integer nombreColonne,Integer numberMap,String mode) {
		this.nombreLigne = nombreLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
		
		if (mode == "Mode Quête"){
			Initialisation(nombreLigne,nombreColonne,listTerrain,mode);
			create_MAP();
			wallReplaceGround();
			doorReplaceGround();
			//holeMap = new Hole((nombreLigne-5)*width,(nombreColonne-5)*height,true);
			//Hole_replace_Wall();
			//staircaseMap = new Staircase(true);
			//Staircase_replace_Wall();
				
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


	private void Initialisation(Integer nombreLigne,Integer nombreColonne, ArrayList<PlateauObject> listTerrain,String mode){
		if (mode == "Mode Quête"){
			create_list_terrain(nombreLigne,nombreColonne,listTerrain);
		}
		create_list_terrain(nombreLigneArene,nombreColonneArene,listTerrainArene);
		
		
	}
	
	/**
	 * Initialisation des types blocs incassables autour et terrain à l'Integerérieur du plateau
	 * Dans la LIST_TERRAIN
	 */
	private void create_list_terrain(Integer nombreLigne, Integer nombreColonne,ArrayList<PlateauObject> listTerrain){
		for (Integer posY = 0; posY <= nombreLigne + 1; posY++){
			for (Integer posX = 0; posX<= nombreColonne + 1; posX++){
				if (posX==0 || posY == 0 || posX == nombreColonne + 1|| posY == nombreLigne + 1){
					listTerrain.add(new Wall(posX*width, posY*height, false, numberMap));
				}
				else {
					listTerrain.add(new Sol(posX*width, posY*height, true, numberMap));
				}
			}	
		}
	}
	
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
		System.out.println(nombreColonne);
		return ((posY)*(nombreColonne+2)+(posX))/height;
	}
	
	
	private void create_MAP(){
		Map map = new Map(nombreLigne, nombreColonne);
		staircaseMap = map.create_Staircase0();
		if(numberMap == 0){
			this.listWallMap = map.create_MAP0();
			this.holeMap = map.create_Hole0();
			this.listMonster = map.create_Monster0();
		}
		else if(numberMap == 1){
			this.listWallMap = map.create_MAP1();
			this.holeMap = map.create_Hole1();
			this.listMonster = map.create_Monster1();
		}
		else if(numberMap == 2){
			this.listWallMap = map.create_MAP2();
		 	this.holeMap = map.create_Hole2();
		 	this.listMonster = map.create_Monster2();
		}
		 else if(numberMap == 3){
			listWallMap = map.create_MAP3();
			holeMap = map.create_Hole3();
			this.listMonster = map.create_Monster3();
		 }
		else if(numberMap == 4){
			listWallMap = map.create_MAP4();
			holeMap = map.create_Hole4();
			this.listMonster = map.create_Monster4();
		}
		listDoor = map.create_Door();
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

	@Override
	public boolean isMoveValide(Integer posX, Integer posY) {
		listTerrain.get(indiceTerrain(posX,posY)).isPassable();
		return listTerrain.get(indiceTerrain(posX,posY)).isPassable();
	}

	public boolean isMoveValide(Integer posX, Integer posY, String action) {
		boolean passable = false;
		if (action.equals("Action Up")){
			passable = listTerrain.get(indiceTerrain(posX,posY+1)).isPassable();
		}else if(action.equals("Action Down")){
			passable = listTerrain.get(indiceTerrain(posX,posY-1)).isPassable();
		}else if(action.equals("Action Right")){
			passable = listTerrain.get(indiceTerrain(posX+1,posY)).isPassable();
		}else if(action.equals("Action Left")){
			passable = listTerrain.get(indiceTerrain(posX-1,posY)).isPassable();
		}
		return passable;
	}
}
