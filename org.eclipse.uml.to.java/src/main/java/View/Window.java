package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Window extends JFrame{
	
	private CardLayout card;
	private Panel[] panel = new Panel[8];
	private ImageIcon[] ImageIcons = new ImageIcon[10];
	private String modeDeJeu;
    private Image welcomeImage, menuImage;
	
	
	
	public Window(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gauntlet");
        this.setSize(1000+16,600+39);
        this.setResizable(false);
        setLocationRelativeTo(null);
        initialisation();
        this.getContentPane().add(panel[0], BorderLayout.CENTER);
	}
	
	private void initialisation(){
		try {
		      this.welcomeImage = ImageIO.read(new File("welcome.jpg"));
		      this.ImageIcons[0] = new ImageIcon("arrow.gif");
		      this.ImageIcons[1] = new ImageIcon("arrowLeft.gif");
		      this.ImageIcons[2] = new ImageIcon("arrowRight.gif");
		      this.ImageIcons[3] = new ImageIcon("arrowUp.gif");
		      this.ImageIcons[4] = new ImageIcon("arrowDown.gif");
		      this.ImageIcons[5] = new ImageIcon("menuSeparation.gif");
		      this.menuImage = ImageIO.read(new File("home.jpg"));
		} catch (IOException e) {
		      e.printStackTrace();}
		
		//Construction du panneau qui reprend tous les panneaux
		panel[0] = new Panel(0, 0, 1000, 600);
		this.card = panel[0].getCard();
		
		//Construction de l'acceuil
      panel[1] = new Panel(welcomeImage, panel[0], ImageIcons, card, 0, 0, 1000, 600, "Home");
      
      //Construction du menu
      panel[2] = new Panel(menuImage, panel[0], ImageIcons, card, 0, 0, 1000, 600, "Menu");
      
      //Construction du nombre de joueur
      panel[3] = new Panel(menuImage, panel[0], ImageIcons, card, 0, 0, 1000, 600, "Player");
      
      //Construction des informations des joueurs
      panel[4] = new Panel(menuImage, panel[0], ImageIcons, card, 0, 0, 1000, 600, "1");
      panel[5] = new Panel(menuImage, panel[0], ImageIcons, card, 0, 0, 1000, 600, "2");
      panel[6] = new Panel(menuImage, panel[0], ImageIcons, card, 0, 0, 1000, 600, "3");
      panel[7] = new Panel(menuImage, panel[0], ImageIcons, card, 0, 0, 1000, 600, "4");
	}

}
