package Model;

import java.util.ArrayList;

public class Map implements IMap {
	

	private Integer nombreLigne;
	private Integer nombreColonne;
	private Integer NumberOfDoor;
	private Integer numberMap;
	private PlateauObject holeMap;
	private Creatures[] listMonster;
	private ArrayList<Monster> list_Monster = new ArrayList<Monster>();
	private IPlateau plateau;
	
	


	public Map(IPlateau plateau,Integer nombrLigne,Integer nombreColonne,Integer numberMap){
		this.nombreLigne = nombrLigne;	
		this.nombreColonne = nombreColonne;
		this.numberMap = numberMap;
	}

	public Creatures[] getListMonster() {
		ArrayList<Monster> ArrayListMonster = new ArrayList<Monster>();
		ArrayListMonster = list_Monster;
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
					
					if(((posX % 20 == 0 && posY == 10)  && !(posX %20 == 0 && posY % 20 == 0) && posX > 0 && posY>0 &&posX<nombreColonne-1&&posY<nombreLigne-1)||(posX == 10 && posY == 20)){
						listTerrain[posX][posY] = new Sol(posX, posY, true, numberMap);
						if(posX == 10 && posY == 20){
							createGroupeMonster(30,10,listTerrain,1,null,null);
							createGroupeMonster(70,10,listTerrain,2,null,null);
							listTerrain[posX][posY] = new Wall(posX,posY,false,0);
							gestionImage(posX,posY,listTerrain);
						}
					}
					else if(isDoor(posX, posY)){
						if( posX % 20 == 0 && posY == 30 ){
							createGroupeMonster(posX+10,posY,listTerrain,(numberMap+1)*2,new KeyDoor(plateau,posX,posY,i),i);
							listTerrain[posX][posY] = new Door(posX,posY,false,i);i++;
							
						}else if( posX % 20 == 0 && posY == 50){
							createGroupeMonster(posX-10,posY,listTerrain,(numberMap+1)*2,new KeyDoor(plateau,posX,posY,i),i);
							listTerrain[posX][posY] = new Door(posX,posY,false,i);i++;
								
						}else if( posX % 20 == 0 && posY == 70 ){
							createGroupeMonster(posX+10,posY,listTerrain,(numberMap+1)*2,new KeyDoor(plateau,posX,posY,i),i);
							listTerrain[posX][posY] = new Door(posX,posY,false,i);i++;
									
						}else if( posX % 20 == 0 && posY == 90){
							createGroupeMonster(posX-10,posY,listTerrain,(numberMap+1)*2,new KeyDoor(plateau,posX,posY,i),i);
							listTerrain[posX][posY] = new Door(posX,posY,false,i);i++;
	
						}else{
							if(map(numberMap,posX,posY)){
								listTerrain[posX][posY] = new Door(posX,posY,false,i);
								createGroupeMonster(posX,posY-10,listTerrain,(numberMap+1)*2,new KeyDoor(plateau,posX,posY,i),i);
								i++;
							}else{
								listTerrain[posX][posY] = new Wall(posX,posY,false,0);
								gestionImage(posX,posY,listTerrain);
							}
						}
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
	

	
	private void gestionImage(Integer posX,Integer posY, PlateauObject[][] listTerrain){
		listTerrain[posX][posY].setForm(7);
		if( posX.equals(0) && posY % 20 == 0 )
			listTerrain[posX][posY].setForm(2) ;
		else if( posX.equals(nombreColonne-1) && posY % 20 ==0) 
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
	
	public boolean map(Integer numberMap,Integer posX,Integer posY){
		boolean res = false;
		if(numberMap == 0){
			res = posX % 20 == 0 || (posX == 90 && posY == 20) || (posX == 10 && posY == 40) || (posX == 90 && posY == 60) || (posX == 10 && posY == 80) ;
		}else if(numberMap == 1){

		}else if(numberMap == 2){
			
		}else if(numberMap == 3){
			
		}else if(numberMap == 4){
			
		}
		return res;
	}
	
	
	private void createGroupeMonster(Integer posX,Integer posY,PlateauObject[][] listTerrain, Integer n, WorldObject wObject,Integer numberOfDoor){
		ArrayList<Monster> list = new ArrayList<Monster>();
		for( Integer i = -n; i <= n ; i++){
			for ( Integer j = -n; j<= n;j++) {
				if(posX %10 ==0 && posY % 10 == 0){
					list_Monster .add(new KeyHolder(posX+i,posY+j, wObject, numberMap,numberOfDoor));
				}else{	
					list_Monster.add(new Monster(posX+i,posY+j, null, numberMap));
				}
			}
		}	
	}
	
	public PlateauObject newSol(Integer posX,Integer posY){
		return new Sol(posX,posY,false,0);
		
	}

}
