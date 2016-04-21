package Model;
 
import java.util.ArrayList;
 
import Model.Creatures;

public class Monster extends Creatures {
    private Integer posMove;
    private boolean iSeeHero;
    private Integer step = 15;
    private static Integer degat = 10;
    public static Integer getDegat() {
		return degat;
	}




	public static void setDegat(Integer degat) {
		Monster.degat = degat;
	}

	private Integer typeMonster = 1;
    private WorldObject wObject; 
	private Integer direction = 0;
    private Integer moveContinue = 0;
	private boolean verify;
	private int dommage;
     
	

 

	public Monster(Integer posX,Integer posY,WorldObject wObject ){
        super(posX,posY);
        iSeeHero = false;
        setPas(30); //fixons le pas à 30 pour tout les mob
        this.wObject = wObject;
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
			setPosY(getPosY() + step);
			gestionImage(0);
		}else if(action.equals("Action Down")){
			setPosY(getPosY() - step);
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
		String move;
		System.out.println(Math.abs(getPosX() -  xPosPlayer)); 
		System.out.println(Math.abs(getPosY() -  yPosPlayer)); 
		if( Math.abs(getPosX() -  xPosPlayer) < Math.abs(getPosY() - yPosPlayer)){
			if (getPosY() - yPosPlayer < 0){
				move = "Action Up";
			}else{
            	move = "Action Down";
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
	
	public void gestionImage(Integer a){
		if(direction == a)
			if(moveContinue == 2){
				moveContinue = 0;
			}
			else{
				moveContinue++;
			}
		else{
			setDirection(a);
		}
	}
		
  


    public double distance(Integer v,Integer w,Integer x,Integer y){
        return Math.sqrt((v-x)*(v-x)+(w-y)*(w-y));
    }

    

	public boolean iSeeHero(Integer xPosPlayer, Integer yPosPlayer) {
		boolean res = false;
		if(distance(getPosX(),getPosY(),xPosPlayer,yPosPlayer) >= distance(step,step,0,0)){
			move(doAction(xPosPlayer,yPosPlayer));
		}
		else{
			res = true;
		}
		return res; 
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



