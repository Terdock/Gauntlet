/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

import java.util.ArrayList;


// Start of user code (user defined imports)

// End of user code

/**
 * Description of Plateau.
 * 
 * @author Edith
 */
public class Plateau implements IPlateau {


	/**
	 * Description of the property Nombre_ligne.
	 */
	private int Nombre_ligne;

	/**
	 * Description of the property Nombre_colonne.
	 */
	private int Nombre_colonne;


	/**
	 * Description of the property Nombre_ligne.
	 */
	private final static int Nombre_ligne_arene = 50;

	/**
	 * Description of the property Nombre_colonne.
	 */
	private final static int Nombre_colonne_arene = 50;

	
	/**
	 * Description of the property Width.
	 */
	private static int Width = 30;

	/**
	 * Description of the property Height.
	 */
	private static int Height = 30;


	private ArrayList<PlateauObject> LIST_TERRAIN = new ArrayList<PlateauObject>();
	private ArrayList<PlateauObject> LIST_TERRAIN_Arene = new ArrayList<PlateauObject>();
	private ArrayList<Wall> LIST_Wall_MAP = new ArrayList<Wall>();
	private ArrayList<Door> LIST_Door = new ArrayList<Door>();
	private Staircase Staircase_Map;
	private Hole Hole_map;
	
	
	private int Numbermap;
	
	
	
	public Plateau(int nombre_ligne, int nombre_colonne,int Numbermap,String Mode) {
		this.Nombre_ligne = nombre_ligne;
		this.Nombre_colonne = nombre_colonne;
		this.Numbermap = Numbermap;
		if (Mode == "Quest"){
			Initialisation(Nombre_ligne,Nombre_colonne,LIST_TERRAIN,Mode);
			create_MAP();
			Hole_replace_Wall();
			Staircase_replace_Wall();
			}
		else if (Mode == "BattleMode")
			Initialisation(Nombre_ligne,Nombre_colonne,LIST_TERRAIN,Mode);
		else if (Mode == "Zombie")
			Initialisation(Nombre_ligne,Nombre_colonne,LIST_TERRAIN,Mode);
			
	}	
	
	public ArrayList<Wall> getLIST_Wall_MAP() {
		return LIST_Wall_MAP;
	}

	public void setLIST_Wall_MAP(ArrayList<Wall> lIST_Wall_MAP) {
		LIST_Wall_MAP = lIST_Wall_MAP;
	}

	public ArrayList<Door> getLIST_Door() {
		return LIST_Door;
	}

	public void setLIST_Door(ArrayList<Door> lIST_Door) {
		LIST_Door = lIST_Door;
	}

	/* (non-Javadoc)
	 * @see Model.IPlateau#getNumbermap()
	 */
	@Override
	public int getNumbermap() {
		return Numbermap;
	}

	public void setNumbermap(int numbermap) {
		Numbermap = numbermap;
	}

	public static void setWidth(int width) {
		Width = width;
	}

	public static void setHeight(int height) {
		Height = height;
	}

	private void Initialisation(int Nombre_ligne,int Nombre_colonne, ArrayList<PlateauObject> LIST_TERRAIN,String Mode){
		if (Mode == "Quête"){
			create_list_terrain(Nombre_ligne,Nombre_colonne,LIST_TERRAIN);
			Wall_replace_sol();
			Door_replace_Wall();
		}
		create_list_terrain(Nombre_ligne_arene,Nombre_colonne_arene,LIST_TERRAIN_Arene);
		
		
	}
	
	/**
	 * Initialisation des types blocs incassables autour et terrain à l'intérieur du plateau
	 * Dans la LIST_TERRAIN
	 */
	private void create_list_terrain(int Nombre_ligne, int Nombre_colonne,ArrayList<PlateauObject> LIST_TERRAIN){
		for (int Pos_y = 0; Pos_y <= Nombre_ligne + 1; Pos_y++){
			for (int Pos_x = 0; Pos_x <= Nombre_colonne + 1; Pos_x++){
				if (Pos_x==0 || Pos_y == 0 || Pos_x == Nombre_colonne + 1|| Pos_y == Nombre_ligne + 1)
				{
					LIST_TERRAIN.add(new Wall(Pos_x, Pos_y, false, Numbermap));
				}
				else 
				{
					LIST_TERRAIN.add(new Sol(Pos_x, Pos_y, true, Numbermap));
				}
			}	
		}
	}
	
	private void Wall_replace_sol(){
		for (Wall Wall_Map : LIST_Wall_MAP){
				int Wall_Pos_x = Wall_Map.getPos_x();
				int Wall_Pos_y = Wall_Map.getPos_y();
				int indiceTerrain = (Wall_Pos_y)/30*(Nombre_colonne+2)+(Wall_Pos_x)/30;
				 LIST_TERRAIN.remove(indiceTerrain);
				 LIST_TERRAIN.add(indiceTerrain,Wall_Map);
			}
		}
		
	private void Door_replace_Wall(){
		for (Door Door : LIST_Door){
				int Door_Pos_x = Door.getPos_x();
				int Door_Pos_y = Door.getPos_y();
				int indiceTerrain = (Door_Pos_y)/30*(Nombre_colonne+2)+(Door_Pos_x)/30;
				 LIST_TERRAIN.remove(indiceTerrain);
				 LIST_TERRAIN.add(indiceTerrain,Door);
			}
		}
	
	private void Staircase_replace_Wall(){
		int Staircase_Pos_x = Staircase_Map.getPos_x();
		int Staircase_Pos_y = Staircase_Map.getPos_y();
		int indiceTerrain = (Staircase_Pos_y)/30*(Nombre_colonne+2)+(Staircase_Pos_x)/30;
		LIST_TERRAIN.remove(indiceTerrain);
		LIST_TERRAIN.add(indiceTerrain,Staircase_Map);
	}
	
	
	private void Hole_replace_Wall(){
		int Hole_Pos_x = Hole_map.getPos_x();
		int Hole_Pos_y = Hole_map.getPos_y();
		int indiceTerrain = (Hole_Pos_y)/30*(Nombre_colonne+2)+(Hole_Pos_x)/30;
		LIST_TERRAIN.remove(indiceTerrain);
		LIST_TERRAIN.add(indiceTerrain,Hole_map);
		 
	}
	
	
	
	
	private void create_MAP(){
		Map map = new Map();
		Staircase_Map = map.create_Staircase0();
		if(Numbermap == 0)
			LIST_Wall_MAP = map.create_MAP0();
			LIST_Door = map.create_Door0();
			Hole_map = map.create_Hole0();
		if(Numbermap == 1)
			LIST_Wall_MAP = map.create_MAP1();
			LIST_Door = map.create_Door1();
			Hole_map = map.create_Hole1();
		if(Numbermap == 2)
			LIST_Wall_MAP = map.create_MAP2();
			LIST_Door = map.create_Door2();
			Hole_map = map.create_Hole2();
		if(Numbermap == 3)
			LIST_Wall_MAP = map.create_MAP3();
			LIST_Door = map.create_Door3();
			Hole_map = map.create_Hole3();
		if(Numbermap == 4)
			LIST_Wall_MAP = map.create_MAP4();
			LIST_Door = map.create_Door4();
			Hole_map = map.create_Hole4();
				
	}
	
	

	public int getNombre_ligne() {
		return Nombre_ligne;
	}

	public void setNombre_ligne(int nombre_ligne) {
		Nombre_ligne = nombre_ligne;
	}

	public int getNombre_colonne() {
		return Nombre_colonne;
	}

	public void setNombre_colonne(int nombre_colonne) {
		Nombre_colonne = nombre_colonne;
	}

	public static int getWidth() {
		return Width;
	}

	public static int getHeight() {
		return Height;
	}

	/* (non-Javadoc)
	 * @see Model.IPlateau#getLIST_TERRAIN()
	 */
	@Override
	public ArrayList<PlateauObject> getLIST_TERRAIN() {
		return LIST_TERRAIN;
	}

	public void setLIST_TERRAIN(ArrayList<PlateauObject> LIST_TERRAIN) {
		this.LIST_TERRAIN = LIST_TERRAIN;
	}

	/* (non-Javadoc)
	 * @see Model.IPlateau#getLIST_TERRAIN_Arene()
	 */
	@Override
	public ArrayList<PlateauObject> getLIST_TERRAIN_Arene() {
		return LIST_TERRAIN_Arene;
	}

	public void setLIST_TERRAIN_Arene(ArrayList<PlateauObject> LIST_TERRAIN_Arene) {
		this.LIST_TERRAIN_Arene = LIST_TERRAIN_Arene;
	}


}
