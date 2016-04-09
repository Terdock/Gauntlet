/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package View;

import Controler.*;
import Model.WorldEntity;
import observer.*;

import java.util.ArrayList;

import javax.swing.JFrame;


public class Fenetre extends JFrame implements Observer {
	
	private  String Mode;
	private  ArrayList<ArrayList<String>> PlayerRegister;
	public Panneau panneaus  = new Panneau();
	AbstractControler controle;
	ArrayList<WorldEntity> List_Terrain;
	ArrayList<WorldEntity> List_Terrain_arene;
	ArrayList<WorldEntity> List_Hero;
	ArrayList<WorldEntity> List_Monster;


	/**
	 * The constructor.
	 */
	public Fenetre(AbstractControler controle) {
		this.controle = controle;
		controle.initComposant(Mode,PlayerRegister);

	}

	public Panneau getPanneaus() {
		return this.panneaus;
	}

	
	public void afficherWorldEntity(){
		
		
	}

	public void update(ArrayList<WorldEntity> List_Hero, ArrayList<WorldEntity> List_Monster) {
		// TODO Auto-generated method stub
		
	}



}
