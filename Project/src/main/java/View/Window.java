package View;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Controler.AbstractControler;
import Model.WorldEntity;
import observer.Observer;

public class Window extends JFrame implements Observer {
	
	private CardLayout card;
	private String modeDeJeu;
	private Panel[] panel = new Panel[8];
	private ImageIcon[] ImageIcons = new ImageIcon[10];
	private String[][] Heros = new String[5][2];
    private Image welcomeImage, menuImage;
    private AbstractControler controle;
    private Panneau panini;
    private Integer nombreDeJoueur;
	
	public Window(AbstractControler controle){
		this.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gauntlet");
        this.setSize(1000+16,600+39);
        this.setResizable(true);
        setLocationRelativeTo(null);
        initialisation();
        this.getContentPane().add(panel[0]);
        setVisible(true);
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
		panel[1] = new Panel(welcomeImage, panel[0], ImageIcons, "Home");
		panel[1].getButtons()[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	card.show(panel[0], "ModeDeJeu");}});
		
      	//Construction du mode de jeu
      	panel[2] = new Panel(menuImage, panel[0], ImageIcons, "ModeDeJeu");
      	for (Integer i = 0; i < 3; i++){
      		actionButton(panel[2].getButtons()[i+1], panel[2].getButtonName()[i]);
      	}
      	
      	
      	//Contruction du panneau de jeu
      	this.panini = new Panneau(); 
      	
      
	}
	
	private void actionButton(Button button, String info){
		button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if (info.equals("Mode Quête")||info.equals("Mode Arène")||info.equals("Mode Survivor")){
            		modeDeJeu = info;
            		
            		//Construction du Panel pour obtenir le nombre de joueur
            		panel[3] = new Panel(menuImage, panel[0], ImageIcons, "Player");
            		card.show(panel[0], "Player");
            		for (Integer i = 1; i <= 4; i++){
        				actionButton(panel[3].getButtons()[i+3], String.valueOf(i));
        			}
            	
            	}else if (info.equals("1")||info.equals("2")||info.equals("3")||info.equals("4")){
            		nombreDeJoueur = Integer.valueOf(info);
            		
            		//Construction du Panel pour obtenir les information des joueurs
            		panel[4] = new Panel(menuImage, panel[0], ImageIcons, info);
            		card.show(panel[0], info);
            		actionButton(panel[4].getButtons()[8],"Information");
            		
            	}else if (info.equals("Information")){
            		for(Integer i = 0; i < panel[4].getPlayerName().length; i++){
            			Heros[i][0] = panel[4].getPlayerName()[i].getText();
            			Heros[i][1] = (String)panel[4].getTypeHeros()[i].getSelectedItem();
            		}
            		//controle.initComposant(modeDeJeu, Heros);
            		new Panel(menuImage, panel[0], "harr");
            		card.show(panel[0], "harr");
            	}
            	
            }
       });
	}

	@Override
	public void update(ArrayList<WorldEntity> entities) {
		this.panini.setEntities(entities);
		
	}

}
