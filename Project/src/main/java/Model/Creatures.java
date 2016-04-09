/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;

import Model.WorldEntity;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Creatures.
 * 
 * @author Edith
 */
public abstract class Creatures extends WorldEntity {
	
	private int pas = 30;

	public int getPas() {
		return pas;
	}

	public void setPas(int pas) {
		this.pas = pas;
	}

	private boolean Life = true;

	/**
	 * Description of the property HP.
	 */
	private int HP;

	/**
	 * Description of the property Level.
	 */
	private int Level;


	/**
	 * The constructor.
	 */
	public Creatures(int Pos_x,int Pos_y) {
		super( Pos_x,Pos_y);
		
	}

	public boolean isLife() {
		return Life;
	}

	public void setLife(boolean life) {
		Life = life;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}
	
	public boolean isMoveValide() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Description of the method Distanc_Attack.
	 */
	public abstract void Distanc_Attack();

	/**
	 * Description of the method Special_Attack.
	 */
	public abstract void Special_Attack();

	/**
	 * Description of the method move.
	 */
	public abstract void move();

	/**
	 * Description of the method attack.
	 */
	public abstract void attack();

	/**
	 * Description of the method getHP.
	 * @return 
	 */
	
}
