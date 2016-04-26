package Model;

import java.util.ArrayList;

public class Map implements IMap {
	

	private Integer nombreLigne;
	private Integer nombreColonne;
	private Integer NumberOfDoor;
	private Integer numberMap;
	private PlateauObject holeMap;
	private Creatures[] listMonster;
	
	


	public Map(Integer nombrLigne,Integer nombreColonne,Integer numberMap){
		this.nombreLigne = nombrLigne;
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
	}

	public Creatures[] getListMonster() {
		ArrayList<Monster> ArrayListMonster = new ArrayList<Monster>();
		ArrayListMonster = createMonster();
		Creatures[] listMonster = new Creatures[ArrayListMonster.size()];
		for(Integer i = 0; i < ArrayListMonster.size();i++){
			listMonster[i] = ArrayListMonster.get(i); 
		}
		return listMonster;
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
			for (Integer posY = 0; posY < nombreLigne; posY++){
				for (Integer posX = 0; posX < nombreColonne; posX++){
					listTerrain[posX][posY] = new Sol(posX, posY, true, numberMap);
					
					if(isWall(posX,posY)){
						listTerrain[posX][posY] = new Wall(posX,posY,false, 0);
					}
					if(isDoor(posX, posY)){
						listTerrain[posX][posY] = new Door(posX,posY,false,i);
						i++;
					}	
					}
					/*
					else if( posX == h*10 || posY == h*10 ){
						listTerrain[posX][posY] = new Wall(posX,posY,false, 0);
					}
					else if (checkInWall(posX, posY, h)){
						listTerrain[posX][posY] = new Wall(posX,posY,false, 0);
					}
					
					if (posX.equals(0) || posY.equals(0) || posX.equals(nombreColonne-1) || posY.equals(nombreLigne-1)){
						listTerrain[posX][posY] = new Wall(posX, posY, false, numberMap);
					}
					*/
			}	
		NumberOfDoor = i;
		return listTerrain;
	}
	
	


	private boolean isDoor(Integer posX, Integer posY){
		return posX > 0 && posY > 0 && posY < nombreLigne-1 && posX < nombreColonne-1  && 
				((posX % 20 == 0 && posY==10) || (posX % 20 == 0 && posY==30)||
				(posX % 20 == 0 && posY==50) || (posX % 20 == 0 && posY==70) ||
				(posX % 20 == 0 && posY==90)) || ((posY % 20 == 0 && posX==10) || 
					(posY % 20 == 0 && posX==30)||(posY % 20 == 0 && posX==50) || 
					(posY % 20 == 0 && posX==70) || (posY % 20 == 0 && posX==90));
	}
	
	private boolean isWall(Integer posX, Integer posY){
		return posX % 20 == 0 || posY % 20 == 0 ;
	}
	
	private boolean checkInMonster(Integer posX, Integer posY){
		boolean res = 	((posX % 10 == 0 && posY==10) || (posX % 20 == 0 && posY==30)||
				(posX % 20 == 0 && posY==50) || (posX % 20 == 0 && posY==70) ||
				(posX % 20 == 0 && posY==90)) || ((posY % 20 == 0 && posX==10) || 
					(posY % 20 == 0 && posX==30)||(posY % 20 == 0 && posX==50) || 
					(posY % 20 == 0 && posX==70) || (posY % 20 == 0 && posX==90));
		return res;
	}
	
	public ArrayList<Monster> createMonster() {
		ArrayList<Monster> list = new ArrayList<Monster>(); 
		Integer i = 0;
			for(Integer y = 5; y < nombreColonne-5; y++){
				for(Integer x = 5; x < nombreLigne-5; x++){
					if(x == 10 && y == 10){
						
					}
					else if(x == 90 && y == 90 ){
						
						
					}
					else if ((x % 10 == 0 && y % 10 == 0) && !(x %20 == 0 || y % 20 == 0) ) 
					{
						list.addAll(createGroupeMonster(x,y,1,0,0,0,0));
					}
		
				}
			}
		return list;
	}


	private ArrayList<Monster> createGroupeMonster(Integer posX,Integer posY,Integer n,Integer a,Integer b,Integer c,Integer d){
		ArrayList<Monster> list = new ArrayList<Monster>();
		for( Integer i = -n+a; i <= n+b ; i++){
			for ( Integer j = -n+c; j<= n+d;j++) {
				if(posX %10 ==0 && posY % 10 == 0){
					list.add(new KeyHolder(posX+i,posY+j, new KeyDoor(posX+i, posY+j), numberMap));
				}else{	
					list.add(new Monster(posX+i,posY+j, null, numberMap));
				}
			}
		}	
		return list;
	}


}
