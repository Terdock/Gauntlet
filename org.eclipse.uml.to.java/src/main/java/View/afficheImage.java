package View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;

public class afficheImage {
	ArrayList<Image> image; //reading the image file
	
	public afficheImage(String nameImage){

		
	}
	
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
		
		public void chargerImage(String nameDossier,int max){
			for(int i = 0; i < max; i++){
				//image.add(new ImageIO.read(new FileInputStream(new File(nameDossier)));
				
			}
			
		}

		public static void image(String nameImage, int pos_x, int pos_y) {
			
			
		}
	
   
    
        
}