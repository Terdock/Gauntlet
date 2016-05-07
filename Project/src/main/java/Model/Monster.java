package Model;
 
import java.util.ArrayList;
 
import Model.Creatures;

public class Monster extends Creatures {
    private Integer degat = 6;
	private int dommage;
	private String type;

	public Monster(Integer posX,Integer posY,WorldObject Object,Integer numberMap, String type){
        super(posX, posY, 10*(numberMap+1), numberMap, Object, true);
        this.type = type;
        setLevel(numberMap+1);
        if(type.equals("Boss")){
        	setHp(true,10000*(numberMap+1));
        }
    }
    
    public Integer getDegat() {
		return degat;
	}

	public void setDegat(Integer degat) {
		this.degat = degat;
	}
    
    public String nameType(){
		return "Monster";
	}

	public int getDommage() {
		return dommage;
	}

	public void setLife(boolean life) {
		this.life = life;
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

	
	public void attack(PlateauObject[][] listTerrain, Integer direction) {
		
	}
 
}



