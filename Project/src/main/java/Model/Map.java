package Model;

import java.util.ArrayList;

public class Map {
	
	ArrayList<Monster> listMonster = new ArrayList<Monster>();
	ArrayList<PlateauObject> listWallHoleDoor = new ArrayList<PlateauObject>(); 
	
	public Map(){

	}


	public ArrayList<Wall> create_MAP0(){
		
		
		
		return null;
	}


	public ArrayList<Wall> create_MAP1(){
		return null;
		//LIST_Wall_MAP1.add(new Wall())
	}
	public ArrayList<Wall> create_MAP2(){
		return null;
		//LIST_Wall_MAP2.add(new Wall())
	}
	public ArrayList<Wall> create_MAP3(){
		return null;
		//LIST_Wall_MAP3.add(new Wall())
	}
	public ArrayList<Wall> create_MAP4(){
		return null;
		//LIST_Wall_MAP4.add(new Wall())
	}
	

	public ArrayList<Door> create_Door0(){
		return null;
		//LIST_Door0.add(new Door())
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

	
	private ArrayList<Monster> createGroupeMonster(int posX,int posY,int n){
		ArrayList<Monster> list = new ArrayList<Monster>();
		for( int i = -n; i < n ; i++)
			list.add(new Monster(posX+n*new Plateau().getWidth(),posY+n*new Plateau().getHeight(), null));
		return list;
		
	}




}
