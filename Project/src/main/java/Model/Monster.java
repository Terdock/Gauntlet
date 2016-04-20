package Model;
 
import java.util.ArrayList;
 
import Model.Creatures;

public class Monster<WoldObject> extends Creatures {
    private Integer posMove;
    private boolean iSeeHero;
    private static Integer degat = 10;
    private Integer typeMonster = 1;
    private WoldObject wObject; 
    private Integer direction = 0;
    private Integer moveContinue = 0;
	private boolean verify;
	private int dommage;
     
  


	public void setiSeeHero(boolean iSeeHero) {
		this.iSeeHero = iSeeHero;
	}


	public Monster(Integer posX,Integer posY,WoldObject wObject ){
        super(posX,posY);
        iSeeHero = false;
        setPas(30); //fixons le pas à 30 pour tout les mob
        this.wObject = wObject;
    }
    
    
    public void move(Integer xPosPlayer,Integer yPosPlayer){
        if(iSeeHero){
            if( Math.abs(getPosX() -  xPosPlayer) < Math.abs(getPosY() - yPosPlayer)){
                if (getPosY() - yPosPlayer < 0){
                    if(new Plateau().isMoveValide(getPosX(),getPosY()+ getPas())){
                        setPosY(getPosY()+ getPas());
                		if(direction == 0)
                			if(moveContinue == 2){
                				moveContinue = 0;
                			}
                			else{
                				moveContinue++;
                			}
                		else{
                			setDirection(0);
                		}
                    }
                }
                
                else{
                    if(new Plateau().isMoveValide(getPosX(),getPosY()- getPas())){
                        setPosY(getPosY()- getPas());
                		if(direction == 2)
                			if(moveContinue == 2){
                				moveContinue = 0;
                			}
                			else{
                				moveContinue++;
                			}
                		else{
                			setDirection(2);
                		}
                    }
            else{
                if(getPosX() - xPosPlayer < 0){
                    if(new Plateau().isMoveValide(getPosX()+ getPas(),getPosY())){
                        setPosX(getPosX()+ getPas());
                        if(direction == 1){
                        	if(moveContinue == 2) moveContinue = 0;
                        	else moveContinue++;
                        }
                        else {setDirection(1);}
                    }
                else{
                    if(new Plateau().isMoveValide(getPosX()- getPas(),getPosY())){
                        setPosX(getPosX()- getPas());
                        if(direction == 4)
                        	if(moveContinue == 2){
                        		moveContinue = 0;
                        	}
                        	else{
                        		moveContinue++;
                        	}
                        else{
                        	setDirection(4);
                        }
                    }
                }
               }
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
    
   
    public void attack(){
    	if(verify)
    		move();
    	else {
    		dommage = degat*getLevel()*typeMonster;
    	}
    }
 

    public void Distanc_Attack(){
    	
    }
 
    public void Special_Attack(){
    	
    }
    
    public String nameType(){
		return "Monster";
	}


	@Override
	public String nameImage() {
		// TODO Auto-generated method stub
		return null;
	}
 
 
}



