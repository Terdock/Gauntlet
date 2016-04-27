package Model;
 
import java.util.ArrayList;
 
import Model.Creatures;

public class Monster extends Creatures {
    private Integer posMove;
    private boolean iSeeHero;
    private static Integer degat = 0;
	private Integer typeMonster = 1;
    private WorldObject wObject; 
	private boolean verify;
	private int dommage;
     
	

 

	public Monster(Integer posX,Integer posY,WorldObject wObject,Integer numberMap){
        super(posX, posY, 10*(numberMap+1), 0);
        iSeeHero = false;
        this.wObject = wObject;
        setLevel(numberMap+1);
    }
    

    
    public static Integer getDegat() {
		return degat;
	}




	public static void setDegat(Integer degat) {
		Monster.degat = degat;
	}
 
    
  

    public void Distanc_Attack(){
    	
    }
 
    public void Special_Attack(){
    	
    }
    
    public String nameType(){
		return "Monster";
	}

    
    public WorldObject getwObject() {
		return wObject;
	}




	public void setwObject(WorldObject wObject) {
		this.wObject = wObject;
	}




	public int getDommage() {
		return dommage;
	}

	public void setLife(boolean life) {
		//à arranger
		this.life = life;
		if(!(wObject == null)){
			wObject.setPosX(getPosX());
			wObject.setPosY(getPosY());
		}
	}



	public void setDommage(int dommage) {
		this.dommage = dommage;
	}



	public String name() {
		return "Monster";
	}

	
	
	public String doAction(Integer xPosPlayer, Integer yPosPlayer){
		String move=  "Action Stop";
		if( Math.abs(getPosX() -  xPosPlayer) <= Math.abs(getPosY() - yPosPlayer)){
			if (getPosY() - yPosPlayer < 0){
				move = "Action Down";
			}else{
            	move = "Action Up";
            }
		}else{
            if(getPosX() - xPosPlayer < 0){
            	move = "Action Right";
            }else{
                move = "Action Left";
            }
		}
		return move;
	}
	
	
	 public boolean creatureIsntInPlace(ArrayList<WorldEntity> list) {
		 boolean res = true;
	    	for( WorldEntity monster : list){
	    		if(monster.getPosX() == getPosX() && monster.getPosX() == getPosY()){
	    			res = false;
	    		}
	    	}	
			return res;
		}



	
	public void attack(Creatures creature) {
		creature.receiveAttack(degat*getLevel(), creature.getDefense());
	}


	public void setHp(Integer dommage) {
		
	}
 
}



