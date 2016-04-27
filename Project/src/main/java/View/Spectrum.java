package View;
 
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
 
import javax.imageio.ImageIO;
 
public class Spectrum{
	private String[] zu;
	private Integer[] tu;
	private Image[][][] imagesHeros;
	
	
	public Spectrum(Image[][][] imagesHeros, Integer playerNumber){
		this.imagesHeros = imagesHeros;
		zu = new String[playerNumber];
		tu = new Integer[playerNumber];
		for (int i = 0; i<playerNumber; i++){
			zu[i] = "Action Stop";
			tu[i] = 0;
		}
	}
	
    private ArrayList<Integer> z = new ArrayList<Integer>();
    private ArrayList<Integer> t = new ArrayList<Integer>();
     
    private ArrayList< ArrayList< ArrayList<Image> > > images;
    private ArrayList< ArrayList<Image> > imagesDead;
     
     
    
    public Spectrum(){
        for(int i = 0; i < 4; i++){
            z.add(1);
            t.add(0);
        }
         
        try {
        	images = new ArrayList<ArrayList<ArrayList<Image>>>();
            for(int i = 0; i < direction; i++) {
                ArrayList< ArrayList<Image> > sub = new ArrayList<ArrayList<Image>>();
                for(int j = 1; j < mouvement; j++) {
                    ArrayList<Image> subsub = new ArrayList<Image>();
                    for(int p = 0; p < playerNumber; p++){
                        subsub.add( ImageIO.read(new File("player" + (p + 1) + "/" + i + j + ".gif")) );
                    }
                    sub.add(subsub);
                }
                images.add(sub);
            }

             
            imagesDead = new ArrayList<ArrayList<Image>>();
            for(int i = 1; i <= 4; i++) {
                ArrayList<Image> sub = new ArrayList<Image>();
                for(int j = 1; j <= 5; j++)
                {
                    sub.add( ImageIO.read(new File("player"+i+"/4"+j+".gif")));
                }
                imagesDead.add(sub);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
    /**
     * 
     * @param d
     * @param p
     * @return Image
     * 
     * Choix de l'image à afficher en fonction de la direction et de l'image précédent
     */
    public Image spectrum(String action, Integer player){
    	Image[] heros = new Image[4*3];
    	
    	for (int direction = 0; direction < 4; direction++){
            for (int mouvement = 0; mouvement < 3; mouvement++){
            	heros[direction + mouvement] = imagesHeros[player][direction][mouvement];
            }
        }
    	
    	if(zu[player].equals(action)){
    		zu[player] = action;
    		tu[player] = tu[player+1];
    		if(tu[player]>= 4){
    			tu[player] = 1;
    		}
    	}
    	
    	 if (z.get(p) == d)
         { 
             z.set(p, d);
             t.set(p, t.get(p) + 1);
             if (t.get(p) >= 4) {
                 t.set(p, 1);
             }
         }
          
         else
         {
             z.set(p, d); 
             t.set(p, 0);
         }
          
         if (d == 10 || d == 20)
         {  
             d = 1;
             t.set(p, 0);
         }
    	
		return null;
    }
    
    public Image sil(int d, int p){
        ArrayList<Image> man = new ArrayList<Image>();
         
        for (int direction = 0; direction < 4; direction++){
            for (int mouvement = 0; mouvement < 3; mouvement++){
            	man
            }
        	for (int j = 1; j < 6; j++)
            {
                man.add( images.get(i).get(j-1).get(p) );
            }
        }
         
        if (z.get(p) == d)
        { 
            z.set(p, d);
            t.set(p, t.get(p) + 1);
            if (t.get(p) >= 4) {
                t.set(p, 1);
            }
        }
         
        else
        {
            z.set(p, d); 
            t.set(p, 0);
        }
         
        if (d == 10 || d == 20)
        {  
            d = 1;
            t.set(p, 0);
        }
         
        return man.get(d * 5 + t.get(p));
    }
         
    /**
     * 
     * @param player
     * @param compteur_vie
     * @return Image
     * 
     * Affichage de l'explosion du bomberman quand celui-ci meurt
     */
    public Image imageDead(int player,int compteur_vie)
    {
        return imagesDead.get(player).get(compteur_vie - 1);
    }
 
}
 