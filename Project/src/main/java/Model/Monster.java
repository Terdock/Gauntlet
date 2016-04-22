package Model;
 
import java.util.ArrayList;
 
import Model.Creatures;

public class Monster extends Creatures {
    private Integer posMove;
    private boolean iSeeHero;
    private Integer step = 30;
    private static Integer degat = 10;
    

	private Integer typeMonster = 1;
    private WorldObject wObject; 
	private Integer direction = 0;
    private Integer moveContinue = 0;
	private boolean verify;
	private int dommage;
     
	

 

	public Monster(Integer posX,Integer posY,WorldObject wObject,Integer numberMap){
        super(posX,posY);
        iSeeHero = false;
        setPas(30); //fixons le pas à 30 pour tout les mob
        this.wObject = wObject;
        setLevel(numberMap+1);
    }
    

    
    public static Integer getDegat() {
		return degat;
	}




	public static void setDegat(Integer degat) {
		Monster.degat = degat;
	}
 
     
    public Integer getMoveContinue() {
		return moveContinue;
	}


	public void setMoveContinue(Integer moveContinue) {
		this.moveContinue = moveContinue;
	}


	public Integer getDirection() {
		return direction;
	}


	public void setDirection(Integer direction) {
		this.direction = direction;
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




	public void setDommage(int dommage) {
		this.dommage = dommage;
	}



	@Override
	public String nameImage() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public  void move(String action){
		if(action.equals("Action Up")){
			setPosY(getPosY() - step);
			gestionImage(0);
		}else if(action.equals("Action Down")){
			setPosY(getPosY() + step);
			gestionImage(2);
		}else if(action.equals("Action Right")){
			setPosX(getPosX() + step);
			gestionImage(1);
		}else if(action.equals("Action Left")){
			setPosX(getPosX() - step);
			gestionImage(3);
		}
	}
	
	public String doAction(Integer xPosPlayer, Integer yPosPlayer){
		String move=  "Action Stop";
		if( Math.abs(getPosX() -  xPosPlayer) <= Math.abs(getPosY() - yPosPlayer)){
			if (getPosY() - yPosPlayer < 0){
				move = "Action Down";
			}else if(getPosY() - yPosPlayer >= 0){
            	move = "Action Up";
            }
		}else if(Math.abs(getPosX() -  xPosPlayer) > Math.abs(getPosY() - yPosPlayer)){
            if(getPosX() - xPosPlayer < 0){
            	move = "Action Right";
            }else if(getPosY() - yPosPlayer >= 0){
                move = "Action Left";
            }
		}
		return move;
	}
	
	public void gestionImage(Integer action){
		if(direction == action)
			if(moveContinue == 2){
				moveContinue = 1;
			}
			else{
				moveContinue++;
			}
		else{
			setDirection(action);
		}
	}
		
  



	
	@Override
	public Integer attack() {
		return degat*getLevel();
	}

	@Override
	public void setHp(Integer dommage) {
		// TODO Auto-generated method stub
		
	}
 
}



