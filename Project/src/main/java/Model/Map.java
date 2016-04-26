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
						gestionImage(posX,posY,listTerrain);
					}
					if(isDoor(posX, posY)){
						listTerrain[posX][posY] = new Door(posX,posY,false,i);
						i++;
					}	
				}
			
			}	
		NumberOfDoor = i;
		return listTerrain;
	}
	
	


	private boolean isDoor(Integer posX, Integer posY){
		return ((posX % 10 == 0 && posY % 20 == 0) || (posX %20 == 0 && posY % 10 == 0)) 
				&& !(posX %20 == 0 && posY % 20 == 0) && posX > 0 && posY>0 &&posX<nombreColonne-1&&posY<nombreLigne-1;
	}
	
	private boolean isWall(Integer posX, Integer posY){
		return posX % 20 == 0 || posY % 20 == 0 ;
	}
	
	private boolean isMonster(Integer posX, Integer posY){
		return (posX % 10 == 0 && posY % 10 == 0) && !(posX %20 == 0 || posY % 20 == 0);
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
					else if (isMonster(x,y) ) 
					{
						list.addAll(createGroupeMonster(x,y,(numberMap+1)*2,0,0,0,0));
					}
		
				}
			}
		return list;
	}

	private void gestionImage(Integer posX,Integer posY, PlateauObject[][] listTerrain){
		listTerrain[posX][posY].setForm(7);
		if( posX.equals(0) && posY.equals(0) )
			listTerrain[posX][posY].setForm(2) ;
		else if( posX.equals(nombreColonne-1) && posY.equals(0)) 
			listTerrain[posX][posY].setForm(3);
		else if( posX.equals(0) && posY.equals(nombreLigne-1))
			listTerrain[posX][posY].setForm(5);
		else if(posX.equals(nombreColonne-1) && posY.equals(nombreLigne-1))
			listTerrain[posX][posY].setForm(4);
		else if(posX % 20 == 0 && posY % 20 == 0)
			listTerrain[posX][posY].setForm(6);
		else if(posX % 20 == 0)
			listTerrain[posX][posY].setForm(1);
		else if(posY % 20 == 0)
			listTerrain[posX][posY].setForm(0);
	
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
