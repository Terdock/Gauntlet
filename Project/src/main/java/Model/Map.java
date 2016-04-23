package Model;

import java.util.ArrayList;

public class Map implements IMap {
	

	private Integer nombreLigne;
	private Integer nombreColonne;
	private Integer NumberOfDoor;
	private Integer numberMap;
	private ArrayList<PlateauObject> listDoor;
	private ArrayList<PlateauObject> listTerrainArene = new ArrayList<PlateauObject>();
	private ArrayList<PlateauObject> listWallMap = new ArrayList<PlateauObject>();
	private PlateauObject staircaseMap;
	private PlateauObject holeMap;
	private Creatures[] listMonster;
	
	


	public Map(Integer nombrLigne,Integer nombreColonne,Integer numberMap){
		this.nombreLigne = nombrLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
	}

	public Creatures[] getListMonster() {
		return listMonster;
	}

	public void setListMonster(Creatures[] listMonster) {
		this.listMonster = listMonster;
	}

	
	@Override
	public Integer getNumberOfDoor() {
		return NumberOfDoor;
	}

	@Override
	public void setNumberOfDoor(Integer numberOfDoor) {
		NumberOfDoor = numberOfDoor;
	}


	public ArrayList<PlateauObject> getListDoor() {
		return listDoor;
	}


	public void setListDoor(ArrayList<PlateauObject> listDoor) {
		this.listDoor = listDoor;
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see Model.IMap#createListTerrain(java.lang.Integer, java.lang.Integer, Model.PlateauObject[][])
	 */
	@Override
	public PlateauObject[][] createListTerrain(Integer nombreLigne, Integer nombreColonne,PlateauObject[][] listTerrain){
		for (Integer posY = 0; posY <= nombreLigne + 1; posY++){
			for (Integer posX = 0; posX<= nombreColonne + 1; posX++){
				if (posX.equals(0) || posY.equals(0) || posX.equals(nombreColonne + 1) || posY.equals(nombreLigne + 1)){
					//listTerrain.add(new Wall(posX*width, posY*height, false, numberMap));
				}
				else {
					//listTerrain.add(new Sol(posX*width, posY*height, true, numberMap));
				}
			}	
		}
		return listTerrain;
	}

	public ArrayList<PlateauObject> create_MAP0(){
		listDoor = new ArrayList<PlateauObject>(); 
		ArrayList<PlateauObject> list  = new ArrayList<PlateauObject>();
		Integer i= 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if(x.equals(20) && y.equals(10)){
						
					}
					else if (checkInDoor( x, y, h)){
						listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;						
					}
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
						if(checkInWall( x, y, h)){
							list.get(list.size()-1).setForm(6);
						}
						else if (x.equals(h*20)){
							list.get(list.size()-1).setForm(1);
						}
						else{
							list.get(list.size()-1).setForm(0);	
						}
					}	
				}
			}
		}
		this.NumberOfDoor = i;
		return list;
	}
	
	public ArrayList<PlateauObject> create_MAP1(){
		listDoor = new ArrayList<PlateauObject>(); 
		ArrayList<PlateauObject> list  = new ArrayList<PlateauObject>();
		Integer i= 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if (checkInDoor( x, y, h)){
						listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		this.NumberOfDoor = i;
		return list;
	}
	public ArrayList<PlateauObject> create_MAP2(){
		listDoor = new ArrayList<PlateauObject>(); 
		ArrayList<PlateauObject> list  = new ArrayList<PlateauObject>();
		Integer i= 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if (checkInDoor( x, y, h)){
							listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;
							}
					
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		this.NumberOfDoor = i;
		return list;
	}
	public ArrayList<PlateauObject> create_MAP3(){
		listDoor = new ArrayList<PlateauObject>(); 
		ArrayList<PlateauObject> list  = new ArrayList<PlateauObject>();
		Integer i= 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if (checkInDoor( x, y, h)){
						listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		this.NumberOfDoor = i;
		return list;
		}
	
	public ArrayList<PlateauObject> create_MAP4(){
		listDoor = new ArrayList<PlateauObject>(); 
		ArrayList<PlateauObject> list  = new ArrayList<PlateauObject>();
		Integer i= 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){					
					if (checkInDoor( x, y, h)){
						listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;
					}
					
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		this.NumberOfDoor = i;
		return list;
		}
	

	public ArrayList<PlateauObject> create_Door(){
		return listDoor ;
	}

	public Staircase create_Staircase0(){
		return new Staircase(true);
	}




	public PlateauObject create_Hole0(){
		return new Hole(0, 0,true);
	}
	
	public PlateauObject create_Hole1() {
		return new Hole(0, 0,true);
	}
	public PlateauObject create_Hole2() {
		return new Hole(0, 0,true);
	}
	public PlateauObject create_Hole3() {
		return new Hole(0, 0,true);
	}
	public PlateauObject create_Hole4() {
		return new Hole(0, 0,true);
	}

	
	private boolean checkInDoor(Integer x, Integer y, Integer h){
		boolean res = false;
		if ((x == h*20 + 10 && y == h*20 )  ||(x == h*20 +30 && y == h*20)||(x == h*20 +50 && y == h*20)||
				(x == h*20 +70 && y == h*20)||(x == h*20 -10 && y == h*20 )||(x == h*20 -30 && y == h*20)||
				(x == h*20 -50 && y == h*20)||(x == h*20 -70 && y == h*20)||(y == h*20 + 10 && x == h*20 )||
				(y == h*20 +30 && x == h*20)||(y == h*20 +50 && x == h*20)||(y == h*20 +70 && x == h*20)||
				(y == h*20 -10 && x == h*20 )||(y == h*20 -30 && x == h*20)||(y == h*20 -50 && x == h*20)||
				(y == h*20 -70 && x == h*20))
					res = true;
		return res;
	}
	
	private boolean checkInWall(Integer x, Integer y, Integer h){
		boolean res = false;
		if ((x == h*20 + 20 && y == h*20 )  ||(x == h*20 +40 && y == h*20)||(x == h*20 + 60 && y == h*20)||
				(x == h*20 +80 && y == h*20)||(x == h*20 -20 && y == h*20 )||(x == h*20 -40 && y == h*20)||
				(x == h*20 -60 && y == h*20)||(x == h*20 -80 && y == h*20)||(y == h*20 + 20 && x == h*20 )||
				(y == h*20 +40 && x == h*20)||(y == h*20 +60 && x == h*20)||(y == h*20 +80 && x == h*20)||
				(y == h*20 -20 && x == h*20 )||(y == h*20 -40 && x == h*20)||(y == h*20 -60 && x == h*20)||
				(y == h*20 -80 && x == h*20) || (x == y))
					res = true;
		return res;
	}
	
	private boolean checkInMonster(Integer x, Integer y, Integer h){
		boolean res = false;
		if(
		(x == h*20 + 10 && y == h*20 + 10 )  ||(x == h*20 + 30 && y == h*20 + 30)||
		(x == h*20 +50 && y == h*20 + 50)||(x == h*20 +70 && y == h*20 +70)||
		(x == h*20 -10 && y == h*20 - 10 )||(x == h*20 -30 && y == h*20 - 30)||
		(x == h*20 -50 && y == h*20 - 50)||(x == h*20 - 70 && y == h*20 - 70)||
		(y == h*20 - 10 && x == h*20 + 10)||(y == h*20 - 30 && x == h*20 + 30)||
		(y == h*20 -50 && x == h*20 + 50)||(y == h*20 -70 && x == h*20 + 70)||
		(y == h*20 +10 && x == h*20-10 )||(y == h*20 + 30 && x == h*20 - 30)||
		(y == h*20 + 50 && x == h*20 - 50)||(y == h*20 +70 && x == h*20-70))
			res = true;
		return res;
	}
	
	public ArrayList<Monster> create_Monster0() {
		ArrayList<Monster> list = new ArrayList<Monster>(); 
		Integer i = 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if(x == 10 && y == 10){
						
					}
					else if(x == 4*20 +  70 && y == 4*20 +  70 ){
						
						
					}
					else if (checkInMonster( x, y, h))
					{
						list.addAll(createGroupeMonster(x*Plateau.getWidth(),y*Plateau.getHeight(),1,0,0,0,0));
					}
		
				}
			}
		}
		return list;
	}
	
	
	
	public ArrayList<Monster> create_Monster1() {
		ArrayList<Monster> list = new ArrayList<Monster>(); 
		Integer i = 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if(x == 10 && y == 10){
						
					}
					else if (checkInMonster( x, y, h))
					{
						list.addAll(createGroupeMonster(x*Plateau.getWidth(),y*Plateau.getHeight(),2,0,0,0,0));
					}
		
				}
			}
		}
		return list;
	}
	public ArrayList<Monster> create_Monster2() {
		ArrayList<Monster> list = new ArrayList<Monster>(); 
		Integer i = 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if(x == 10 && y == 10){
						
					}
					else if (checkInMonster( x, y, h)){
						list.addAll(createGroupeMonster(x*Plateau.getWidth(),y*Plateau.getHeight(),4,0,0,0,0));
					}
		
				}
			}
		}
		return list;
	}
	public ArrayList<Monster> create_Monster3() {
		ArrayList<Monster> list = new ArrayList<Monster>(); 
		Integer i = 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if(x == 10 && y == 10){
						
					}
					else if (checkInMonster( x, y, h)){
						list.addAll(createGroupeMonster(x*Plateau.getWidth(),y*Plateau.getHeight(),6,0,0,0,0));
					}
		
				}
			}
		}
		return list;
	}
	
	public ArrayList<Monster> create_Monster4() {
		ArrayList<Monster> list = new ArrayList<Monster>(); 
		Integer i = 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if(x == 10 && y == 10){
						
					}
					
					else if (checkInMonster( x, y, h))
					{
						list.addAll(createGroupeMonster(x*Plateau.getWidth(),y*Plateau.getHeight(),8,0,0,0,0));
					}
		
				}
			}
		}
		return list;
	}

	
	private ArrayList<Monster> createGroupeMonster(Integer posX,Integer posY,Integer n,Integer a,Integer b,Integer c,Integer d){
		ArrayList<Monster> list = new ArrayList<Monster>();
		for( Integer i = -n+a; i <= n+b ; i++){
			for ( Integer j = -n+c; j<= n+d;j++) {
				list.add(new Monster(posX+i*Plateau.getWidth(),posY+j*Plateau.getHeight(), null, numberMap));
			}
		}	
		return list;
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
	



}
