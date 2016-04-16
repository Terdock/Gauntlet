package View;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.awt.*;

public class afficheImage {
	private ArrayList<Image> image; //reading the image file
	private Image[][] imagesWall = new Image[5][8];
	
	public afficheImage(){
		chargerImage();
	}
		
	private void chargerImage(){
		for(int i = 0; i < 5; i++){
			for(int j = 0; j <8; j++){
				try {
					imagesWall[i][j] = ImageIO.read(new File("images/Plateaux/Wall" +String.valueOf(i)+ String.valueOf(j) +".png"));
				} catch (IOException e) {
					e.printStackTrace();
				};
			}
		}
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
	        
	     return split;
	}
	**/
    
        
}