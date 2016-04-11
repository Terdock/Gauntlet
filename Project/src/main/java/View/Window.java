package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Controler.*;
import Model.*;
import observer.Observer;

public class Window extends JFrame implements Observer {
	
	private CardLayout card;
	private Panel[] panel = new Panel[8];
	private ImageIcon[] ImageIcons = new ImageIcon[10];
	private String modeDeJeu;
	private String[][] PlayerRegister;
    private Image welcomeImage, menuImage;
    private AbstractControler controle;
    private Panneau panini;
   
	
	
	
	public Window(AbstractControler controle){
		this.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gauntlet");
        this.setSize(1000+16,600+39);
        this.setResizable(false);
        setLocationRelativeTo(null);
        initialisation();
        this.getContentPane().add(panel[0], BorderLayout.CENTER);
        setVisible(true);
	}
	
	private void doit(){
		
	}
	

	private void initialisation(){
		try {
		      this.welcomeImage = ImageIO.read(new File("Images/welcome.jpg"));
		      this.ImageIcons[0] = new ImageIcon("Images/arrow.gif");
		      this.ImageIcons[1] = new ImageIcon("Images/arrowLeft.gif");
		      this.ImageIcons[2] = new ImageIcon("Images/arrowRight.gif");
		      this.ImageIcons[3] = new ImageIcon("Images/arrowUp.gif");
		      this.ImageIcons[4] = new ImageIcon("Images/arrowDown.gif");
		      this.ImageIcons[5] = new ImageIcon("Images/menuSeparation.gif");
		      this.menuImage = ImageIO.read(new File("Images/home.jpg"));
		} catch (IOException e) {
		      e.printStackTrace();}
		
		//Construction du panneau qui reprend tous les panneaux
		panel[0] = new Panel();
		this.card = panel[0].getCard();
		
		//Construction de l'acceuil
		panel[1] = new Panel(welcomeImage, panel[0], ImageIcons, card, "Home", null,controle);
      
      	//Construction du menu
      	panel[2] = new Panel(menuImage, panel[0], ImageIcons, card, "Menu", null,controle);
      	
      	//Contruction du panneau de jeu
      	this.panini = new Panneau(); 
      	
      
	}

	@Override
	public void update(ArrayList<WorldEntity> entities) {
		this.panini.setEntities(entities);
		
	}

}
