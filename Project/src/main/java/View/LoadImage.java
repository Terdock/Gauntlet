package View;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LoadImage {
	private Image[][] imagesWall = new Image[5][8];
	private Image[] imagesGround = new Image[5];
	private Image[][][] imagesHeros = new Image[4][4][3];
	private Image[][] imagesWeapons = new Image[4][8];
	private Image[][][] imagesMonsters = new Image[3][4][3];
	private ImageIcon[] imageIcons = new ImageIcon[6];
	private Image[] imageBackground = new Image[2];
	private Image imageDeathHeros, imageDeathMonsters;
	
	public LoadImage(){
		
	}
	
	public void chargerImage(){
		loadTerrain();
		loadHeros();
		loadWeapons();
		loadMonsters();
	}
	
	private void loadTerrain(){
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
	
	private void loadHeros(){
		for(int i = 0; i<4; i++){
			for(int j = 0; j<4; j++){
				for(int n = 0; n<3; n++){
					try {
						imagesHeros[i][j][n] = ImageIO.read(new File("images/Heros/heros" +String.valueOf(i)+ String.valueOf(j)+ String.valueOf(n) +".png"));
					} catch (IOException e) {
						e.printStackTrace();
					};
				}
			}
		}
		try {
			imageDeathHeros = ImageIO.read(new File("images/Heros/herosDeath.png"));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	private void loadWeapons(){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 8; j++){
				try {
					imagesWeapons[i][j] = ImageIO.read(new File("images/Heros/weapon" + String.valueOf(i) + String.valueOf(j) +".png"));
				} catch (IOException e) {
					e.printStackTrace();
				};
			}
		}
	}
	
	private void loadMonsters(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<4; j++){
				for(int n = 0; n<3; n++){
					try {
						imagesMonsters[i][j][n] = ImageIO.read(new File("images/Monsters/monster" +String.valueOf(i)+ String.valueOf(j)+ String.valueOf(n) +".png"));
					} catch (IOException e) {
						e.printStackTrace();
					};
				}
			}
		}
		try {
			imageDeathMonsters = ImageIO.read(new File("images/Monsters/monsterDeath.png"));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public ImageIcon[] loadIconImage(){
		imageIcons[0] = new ImageIcon("Images/arrow.gif");
		imageIcons[1] = new ImageIcon("Images/arrowLeft.gif");
		imageIcons[2] = new ImageIcon("Images/arrowRight.gif");
		imageIcons[3] = new ImageIcon("Images/arrowUp.gif");
		imageIcons[4] = new ImageIcon("Images/arrowDown.gif");
		imageIcons[5] = new ImageIcon("Images/menuSeparation.gif");
		return imageIcons;
	}
	
	public Image[] loadBackground(){
		try {
			imageBackground[0] = ImageIO.read(new File("Images/welcome.jpg"));   
			imageBackground[1] = ImageIO.read(new File("Images/home.jpg"));
		} catch (IOException e) {
		      e.printStackTrace();
		}
		return imageBackground;
	}

	public Image[][] getImagesWall() {
		return imagesWall;
	}

	public Image[] getImagesGround() {
		return imagesGround;
	}

	public Image[][][] getImagesHeros() {
		return imagesHeros;
	}

	public Image[][] getImagesWeapons() {
		return imagesWeapons;
	}

	public Image[][][] getImagesMonsters() {
		return imagesMonsters;
	}

	public Image getImageDeathHeros() {
		return imageDeathHeros;
	}

	public Image getImageDeathMonsters() {
		return imageDeathMonsters;
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
