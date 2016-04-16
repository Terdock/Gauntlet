package View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;

public class afficheImage {
	ArrayList<Image> image; //reading the image file
	static Image Sol0;
    static Image Mur0;
    static Image trou; 
	
	public afficheImage(){
		//chargerImage(String nameDossier,int max);
		try {
		      this.Sol0 = ImageIO.read(new File("images/Plateaux/Sol0.png"));
		      this.Mur0 = ImageIO.read(new File("images/Plateaux/Plateau10.png"));
		      this.trou = ImageIO.read(new File("images/Plateaux/trou.png"));
		} catch (IOException e) {
			  e.printStackTrace();
		};
		
	}
		/**
		public BufferedImage[] createSplit(BufferedImage image,int rows, int cols){
			int sizeImage = rows * cols;
	        int sizeImageWidth = image.getWidth() / cols; // determines the sizeImage width and height
	        int sizeImageHeight = image.getHeight() / rows;
	        int count = 0;
	        BufferedImage split[] = new BufferedImage[sizeImage]; //Image array to hold image sizeImage
	        for (int x = 0; x < rows; x++) {
	            for (int y = 0; y < cols; y++) {
	                //Initialize the image array with image sizeImage
	                split[count] = new BufferedImage(sizeImageWidth, sizeImageHeight, image.getType());

	                // draws the image sizeImage
	                Graphics2D gr = split[count++].createGraphics();
	                gr.drawImage(image, 0, 0, sizeImageWidth, sizeImageHeight, sizeImageWidth * y, sizeImageHeight * x, sizeImageWidth * y + sizeImageWidth, sizeImageHeight * x + sizeImageHeight, null);
	                gr.dispose();
	            }
	        }
	        
	        return split;
		}
		**/
		
		public void chargerImage(String nameDossier,int max){
			for(int i = 0; i < max; i++){
				//image.add(new ImageIO.read(new FileInputStream(new File(nameDossier)));
				
			}
			
		}

		public static Image images(String nameImage) {
			Image img = Mur0;
			System.out.println(nameImage);
			if(nameImage.equals("Model.Sol0"))
				img = Sol0;
			else if (nameImage.equals("Model.Hole")){
				img = trou;
			}
			return img;
		}
	
   
    
        
}