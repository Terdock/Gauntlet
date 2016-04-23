package Model;

import java.util.ArrayList;

public class Map implements IMap {
	

	private Integer nombreLigne;
	private Integer nombreColonne;
	private Integer NumberOfDoor;
	private Integer numberMap;
	private ArrayList<PlateauObject> listDoor;
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


	@Override
	public PlateauObject[][] createListTerrain(Integer nombreLigne, Integer nombreColonne,PlateauObject[][] listTerrain){
		Integer i = 0;
		for(Integer h = 0; h < 5; h++){
			for (Integer posY = 0; posY <= nombreLigne + 1; posY++){
				for (Integer posX = 0; posX <= nombreColonne + 1; posX++){
					listTerrain[posX][posY] = new Sol(posX*Plateau.getWidth(), posY*Plateau.getWidth(), true, numberMap);
					
					if (checkInDoor( posX, posY, h)){
						listTerrain[posX][posY] = new Door(posX*Plateau.getWidth(),posY*Plateau.getHeight(),false,i);
						i++;
					}	
					else if (checkInWall(posX, posY, h)){
						
					}
					else if( posX == h*20 || posY == h*20 ){
						listTerrain[posX][posY] = new Wall(posX*Plateau.getWidth(),posY*Plateau.getHeight(),false, 0);
					}
					else if (posX.equals(0) || posY.equals(0) || posX.equals(nombreColonne + 1) || posY.equals(nombreLigne + 1)){
						listTerrain[posX][posY] = new Wall(posX*Plateau.getWidth(), posY*Plateau.getWidth(), false, numberMap);
					}
				}	
			}	
		}
		NumberOfDoor = i;
		return listTerrain;
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
	
	

	
	/**
	 * Initialisation des types blocs incassables autour et terrain à l'Integerérieur du plateau
	 * Dans la LIST_TERRAIN
	 */
	
	


}
