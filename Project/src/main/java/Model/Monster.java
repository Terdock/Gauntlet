package Model;
 
import java.util.ArrayList;
 
import Model.Creatures;

public abstract class Monster<WoldObject> extends Creatures {
    private int posMove;
    private boolean iSeeHero;
    private static int degat = 10;
    private int typeMonster = 1;
    private ArrayList<Hero> listHeros;
    private WoldObject wObject; 
     
    public Monster(ArrayList<Hero> listHeros,int posX,int posY,WoldObject wObject ){
        super(posX,posY);
        iSeeHero = false;
        this.listHeros = listHeros;  
        setPas(30); //fixons le pas à 30 pour tout les mob
        this.wObject = wObject;
    }
    
    
    public void move(int herosProche){
        Where_is_Hero(herosProche);//annonce si le monstre est dans le perimètre visible par l'utilisateur 
        if(isISeeHero()){
            if( Math.abs(getPosX() - listHeros.get(herosProche).getPosX()) < Math.abs(getPosY() - listHeros.get(herosProche).getPosY())){
                if (getPosY() - listHeros.get(herosProche).getPosY() < 0)
                    if(new Plateau().isMoveValide(getPosX(),getPosY()+ getPas()))
                        setPosY(getPosY()+ getPas());
                else
                    if(new Plateau().isMoveValide(getPosX(),getPosY()- getPas()))
                        setPosY(getPosY()- getPas());
            }
            else{
                if(getPosX() - listHeros.get(herosProche).getPosX() < 0)
                    if(new Plateau().isMoveValide(getPosX()+ getPas(),getPosY()))
                        setPosX(getPosX()+ getPas());
                else
                    if(new Plateau().isMoveValide(getPosX()- getPas(),getPosY()))
                        setPosX(getPosX()- getPas());
            }
        }
    }
     
    public void Where_is_Hero(int iHero){
            setISeeHero(false);
            if(Math.abs(getPosX()) < Math.abs(listHeros.get(iHero).getPosX()+50*getWidth()))
                setISeeHero(true);
            else if(Math.abs(getPosX()) < Math.abs(listHeros.get(iHero).getPosX()-50*getWidth()))
                setISeeHero(true);
            if(Math.abs(getPosY()) < Math.abs(listHeros.get(iHero).getPosY()+50*getHeight()))
                setISeeHero(true);
            else if(Math.abs(getPosY()) < Math.abs(listHeros.get(iHero).getPosY()-50*getHeight()))
                setISeeHero(true);
             
             
    }
    
    public int closestHero(ArrayList<Double> normList){
    	int HeroClose = 0; //attaquer le hero le plus proche
        for (int i = 0; i < listHeros.size(); i++)
            for(int j = 0; j < listHeros.size(); j++)
                if(normList.get(i) < normList.get(j))
                    HeroClose = i;
    	return HeroClose; 
    }
     
    
     
    public boolean isISeeHero() {
        return iSeeHero;
    }
 
    public void setISeeHero(boolean iSeeHero) {
        this.iSeeHero = iSeeHero;
    }
 
    public double norm(int vMonster,int wMonster,int xHero,int yHero){
        return Math.sqrt((vMonster-xHero)^2+(wMonster-yHero)^2);
    }
    
    
    
    public void attack(){
    	ArrayList<Double> normList = null; //liste de la distance de chaque joueur avec le monstre
        for (int i = 0; i < listHeros.size(); i++)
            normList.add(norm(getPosX(),getPosY(),listHeros.get(i).getPosX(),listHeros.get(i).getPosY()));
    	int HeroProche = closestHero(normList);
    	if(normList.get(HeroProche) > Math.sqrt(getPas()^2+getPas()^2))
    		move();
    	else 
    		listHeros.get(HeroProche).setHp(getHp()-degat*getLevel()*typeMonster);
    }
 

    public void Distanc_Attack(){
    	
    }
 
    public void Special_Attack(){
    	
    }
    
    public String nameType(){
		return "Monster";
	}
 
 
}



