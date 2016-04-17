package View;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class LoadImage {
	private ArrayList<Image> image; //reading the image file
	private Image[][] imagesWall = new Image[5][8];
	private Image[] imagesGround = new Image[5];
	
	public LoadImage(){
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
			try {
				imagesGround[i] = ImageIO.read(new File("images/Plateaux/Ground" +String.valueOf(i)+".png"));
			} catch (IOException e) {
				e.printStackTrace();
			};
		}
	}

	public Image[][] getImagesWall() {
		return imagesWall;
	}

	public Image[] getImagesGround() {
		return imagesGround;
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

		public Image images(String nameImage) {
			Image img = Mur0;
			if(nameImage.equals("Model.Sol0"))
				img = Sol0;
			else if (nameImage.equals("Model.Hole")){
				img = trou;
			}
			return img;
		}
        **/
}
