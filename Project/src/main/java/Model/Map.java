package Model;

import java.util.ArrayList;

public class Map {
	
	
	
	ArrayList<Monster> listMonster = new ArrayList<Monster>();
	ArrayList<PlateauObject> listWallHoleDoor = new ArrayList<PlateauObject>();
	private Integer nombreLigne;
	private Integer nombreColonne;
	private ArrayList<Door> listDoor;
	
	public Map(Integer nombrLigne,Integer nombreColonne){
		this.nombreLigne = nombrLigne;
		this.nombreColonne = nombreColonne;
	}


	public ArrayList<Wall> create_MAP0(){
		listDoor = new ArrayList<Door>(); 
		ArrayList<Wall> list  = new ArrayList<Wall>();
		Integer i= 0;
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					
					
					if (x == h*20 + 10 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (x == h*20 +30 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (x == h*20 +50 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (x == h*20 +70 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (y == h*20 +10 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (y == h*20 +30 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (y == h*20 +50 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (y == h*20 +70 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (x == h*20 -10 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (x == h*20 -30 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (x == h*20 -50 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (x == h*20 -70 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (y == h*20 -10 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (y == h*20 -30 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (y == h*20 -50 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					else if (y == h*20 -70 ){listDoor.add(new Door(x*Plateau.getWidth(),y*Plateau.getHeight(),false,i));i++;}
					
					else if( x == h*20 || y == h*20 ){
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		return list;
	}


	public ArrayList<Door> getListDoor() {
		return listDoor;
	}


	public void setListDoor(ArrayList<Door> listDoor) {
		this.listDoor = listDoor;
	}


	public ArrayList<Wall> create_MAP1(){
		ArrayList<Wall> list  = new ArrayList<Wall>();
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if( x == h*20 || y == h*20)
					{
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		return list;
	}
	public ArrayList<Wall> create_MAP2(){
		ArrayList<Wall> list  = new ArrayList<Wall>();
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if( x == h*20 || y == h*20)
					{
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		return list;
	}
	public ArrayList<Wall> create_MAP3(){
		ArrayList<Wall> list  = new ArrayList<Wall>();
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if( x == h*20 || y == h*20)
					{
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		return list;
	}
	public ArrayList<Wall> create_MAP4(){
		ArrayList<Wall> list  = new ArrayList<Wall>();
		for(Integer h = 0; h < 5; h++){
			for(Integer y = 0; y < nombreColonne+1; y++){
				for(Integer x = 0; x < nombreLigne+1; x++){
					if( x == h*20 || y == h*20)
					{
						list.add(new Wall(x*Plateau.getWidth(),y*Plateau.getHeight(),false, 0));
					}
				}
			}
		}
		return list;
	}
	

	public ArrayList<Door> create_Door0(){
		return listDoor ;
	}
	
	public ArrayList<Door> create_Door1(){
		return null;
		//LIST_Door1.add(new Door())
	}
	public ArrayList<Door> create_Door2(){
		return null;
		//LIST_Door2.add(new Door())
	}
	public ArrayList<Door> create_Door3(){
		return null;
		//LIST_Door3.add(new Door())
	}
	public ArrayList<Door> create_Door4(){
		return null;
		//LIST_Door4.add(new Door())
	}




	public Staircase create_Staircase0(){
		return new Staircase(true);
	}




	public Hole create_Hole0(){
		return new Hole(0, 0,true);
	}
	
	public Hole create_Hole1() {
		return new Hole(0, 0,true);
	}
	public Hole create_Hole2() {
		return new Hole(0, 0,true);
	}
	public Hole create_Hole3() {
		return new Hole(0, 0,true);
	}
	public Hole create_Hole4() {
		return new Hole(0, 0,true);
	}

	public ArrayList<Monster> create_Monster0() {
		ArrayList<Monster> list = new ArrayList<Monster>(); 
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		return list;
	}
	public ArrayList<Monster> create_Monster1() {
		ArrayList<Monster> list  = new ArrayList<Monster>(); 
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		return list;
	}
	public ArrayList<Monster> create_Monster2() {
		ArrayList<Monster> list  = new ArrayList<Monster>(); 
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		return list;
	}
	public ArrayList<Monster> create_Monster3() {
		ArrayList<Monster> list  = new ArrayList<Monster>(); 
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		return list;
	}
	public ArrayList<Monster> create_Monster4() {
		ArrayList<Monster> list  = new ArrayList<Monster>(); 
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		//list.addAll(createGroupeMonster(heros,posX,posY,n));
		return list;
	}

	
	private ArrayList<Monster> createGroupeMonster(Integer posX,Integer posY,Integer n){
		ArrayList<Monster> list = new ArrayList<Monster>();
		for( Integer i = -n; i < n ; i++)
			list.add(new Monster(posX+n*Plateau.getWidth(),posY+n*Plateau.getHeight(), null));
		return list;
		
	}




}
