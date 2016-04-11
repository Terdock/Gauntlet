/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

import Model.Creatures;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Hero.
 * 
 * @author Edith
 */
public abstract class Hero extends Creatures {
	
	private String PlayerName;

	/**
	 * Description of the property Force.
	 */
	private int Force = 0;

	/**
	 * Description of the property Defense.
	 */
	private int Defense = 0;

	/**
	 * Description of the property Direction.
	 */
	private int Direction = 0;

	/**
	 * Description of the property Speed.
	 */
	private int Speed = 0;

	/**
	 * Description of the property Magie.
	 */
	private int Magie = 0;

	/**
	 * Description of the property Power.
	 */
	private int Power = 0;

	/**
	 * Description of the property Dexterity.
	 */
	private int Dexterity = 0;

	// Start of user code (user defined attributes for Hero)

	// End of user code

	/**
	 * The constructor.
	 */
	public Hero(int pos_x, int pos_y) {
		// Start of user code constructor for Hero)
		super(pos_x,pos_y);
		// End of user code
	}

	/**
	 * Description of the method move.
	 */
	public  void move(){
		
	}

	/**
	 * Description of the method attack.
	 */
	public abstract void attack();

	/**
	 * Description of the method Distanc_Attack.
	 */
	public abstract void Distanc_Attack();

	/**
	 * Description of the method Special_Attack.
	 */
	public abstract void Special_Attack();

	/**
	 * Description of the method getPower.
	 * @return 
	 */
	
	public String getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}
	
	public String nameType(){
		return "Hero";
	}
}
	