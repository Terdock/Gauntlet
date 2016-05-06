package View;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class LoadImage {
	private Image[][] imagesWall = new Image[5][8], imagesWeapons = new Image[4][4];;
	private Image[] imagesGround = new Image[5], imageBackground = new Image[4], imageBonus = new Image[4];
	private Image[][][] imagesHeros = new Image[4][4][3], imagesMonsters = new Image[3][4][3];;
	private ImageIcon[] imageIcons = new ImageIcon[6];
	private Image imageDeathHeros, imageDeathMonsters, imageDoor, imageExit, imageKey;
	
	public LoadImage(){
		
	}
	
	public void chargerImage(){
		loadTerrain();
		loadHeros();
		loadWeapons();
		loadMonsters();
		loadDoor();
		loadExit();
		loadKey();
		loadBonus();
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
			for(int j = 0; j < 4; j++){
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
	
	private void loadDoor(){
		try {
			imageDoor = ImageIO.read(new File("images/Door.png"));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	private void loadExit(){
		try {
			imageExit = ImageIO.read(new File("images/Exit.png"));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	private void loadKey(){
		try {
			imageKey = ImageIO.read(new File("images/key.png"));
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
			imageBackground[2] = ImageIO.read(new File("Images/imageScore.jpg"));
			imageBackground[3] = ImageIO.read(new File("Images/horror.jpg"));
		} catch (IOException e) {
		      e.printStackTrace();
		}
		return imageBackground;
	}
	
	public Image[] loadBonus(){
		try {
			imageBonus[0] = ImageIO.read(new File("Images/Potions/stepPotion.png"));
			imageBonus[1] = ImageIO.read(new File("Images/Potions/healthPotion.png"));
			imageBonus[2] = ImageIO.read(new File("Images/Potions/invisibilityPotion.png"));
			imageBonus[3] = ImageIO.read(new File("Images/Potions/speedPotion.gif"));
		} catch (IOException e) {
		      e.printStackTrace();
		}
		return imageBonus;
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

	public Image getImageDoor() {
		return imageDoor;
	}

	public Image getImageKey() {
		return imageKey;
	}

	public Image[] getImageBonus() {
		return imageBonus;
	}

	public Image getImageExit() {
		return imageExit;
	}
	
	
	
}
