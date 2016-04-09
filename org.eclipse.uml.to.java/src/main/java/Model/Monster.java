/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package Model;
 
import java.util.ArrayList;
 
import Model.Creatures;





public abstract class Monster extends Creatures {
 
    private int pos_move;
     
    private boolean ISeeHero;
    
    private static int Degat = 10;
    
    private int typeMonster = 1;


    /**
     * The constructor.
     */
    ArrayList<Hero> List_Hero;
    WoldObject wObject; 
     
    public Monster(ArrayList<Hero> Hero,int Pos_x,int Pos_y,WoldObject w ) {
        // Start of user code constructor for Monster)
        super(Pos_x,Pos_y);
        ISeeHero = false;
        ArrayList<Hero> List_Hero = Hero;  
        setPas(30); //fixons le pas à 30 pour tout les mob
        wObject = w;
    }
    
    
    public void move(int HeroProche){
    	
   	/**
     * Description of the method move.
     */
        Where_is_Hero(HeroProche);//annonce si le monstre est dans le perimètre visible par l'utilisateur 
        if(isISeeHero()){
            if( Math.abs(getPos_x() - List_Hero.get(HeroProche).getPos_x()) < Math.abs(getPos_y() - List_Hero.get(HeroProche).getPos_y()))
                if (getPos_y() - List_Hero.get(HeroProche).getPos_y() < 0)
                    if(isMoveValide(getPos_x(),getPos_y()+ getPas()))
                        setPos_y(getPos_y()+ getPas());
                else
                    if(isMoveValide(getPos_x(),getPos_y()- getPas()))
                        setPos_y(getPos_y()- getPas());
            else
                if(getPos_x() - List_Hero.get(HeroProche).getPos_x() < 0)
                    if(isMoveValide(getPos_x()+ getPas(),getPos_y()))
                        setPos_x(getPos_x()+ getPas());
                else
                    if(isMoveValide(getPos_x()- getPas(),getPos_y()))
                        setPos_x(getPos_x()- getPas()); 
        }
    }
     
    public void Where_is_Hero(int iHero){
            setISeeHero(false);
            if(Math.abs(getPos_x()) < Math.abs(List_Hero.get(iHero).getPos_x()+50*getWidth()))
                setISeeHero(true);
            else if(Math.abs(getPos_x()) < Math.abs(List_Hero.get(iHero).getPos_x()-50*getWidth()))
                setISeeHero(true);
            if(Math.abs(getPos_y()) < Math.abs(List_Hero.get(iHero).getPos_y()+50*getHeight()))
                setISeeHero(true);
            else if(Math.abs(getPos_y()) < Math.abs(List_Hero.get(iHero).getPos_y()-50*getHeight()))
                setISeeHero(true);
             
             
    }
    
    public int closestHero(ArrayList<Double> normList){
    	int HeroClose = 0; //attaquer le hero le plus proche
        for (int i = 0; i < List_Hero.size(); i++)
            for(int j = 0; j < List_Hero.size(); j++)
                if(normList.get(i) < normList.get(j))
                    HeroClose = i;
    	return HeroClose; 
    }
     
    
     
    public boolean isISeeHero() {
        return ISeeHero;
    }
 
    public void setISeeHero(boolean iSeeHero) {
        ISeeHero = iSeeHero;
    }
 

 
    public double norm(int vMonster,int wMonster,int xHero,int yHero){
        return Math.sqrt((vMonster-xHero)^2+(wMonster-yHero)^2);
    }
    
    
    
    /**
     * Description of the method attack.
     */
    public void attack(){
    	ArrayList<Double> normList = null; //liste de la distance de chaque joueur avec le monstre
        for (int i = 0; i < List_Hero.size(); i++)
            normList.add(norm(getPos_x(),getPos_y(),List_Hero.get(i).getPos_x(),List_Hero.get(i).getPos_y()));
    	int HeroProche = closestHero(normList);
    	if(normList.get(HeroProche) > Math.sqrt(getPas()^2+getPas()^2))
    		move();
    	else 
    		List_Hero.get(HeroProche).setHP(getHP()-Degat*getLevel()*typeMonster);
    }
 

    public void Distanc_Attack(){
    	
    }
 
    public void Special_Attack(){
    	
    }
 
 
}


}
