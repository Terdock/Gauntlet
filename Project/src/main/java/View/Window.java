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
import java.awt.Graphics.*;

import Controler.AbstractControler;
import Model.WorldEntity;
import observer.Observer;

public class Window extends JFrame implements Observer {
	
	private CardLayout card;
	private String modeDeJeu;
	private HomePanel homePanel;
	private ModePanel modePanel;
	private PlayerPanel playerPanel;
	private IdentityPanel identityPanel;
	private GamePanel gamePanel;
	private ScorePanel scorePanel;
	private Panel principalPanel, gameContentPanel;
	private ImageIcon[] imageIcons = new ImageIcon[10];
	private String[][] heros = new String[5][2];
    private Image welcomeImage, menuImage;
    private AbstractControler controle;
    private Integer nombreDeJoueur;
	
	public Window(AbstractControler controle){
		this.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gauntlet");
        this.setSize(1000+16,600+29);
        this.setResizable(false);
        setLocationRelativeTo(null);
        initialisation();
        this.getContentPane().add(principalPanel);
        setVisible(true);
	}

	private void initialisation(){
		try {
		      this.welcomeImage = ImageIO.read(new File("Images/welcome.jpg"));
		      this.imageIcons[0] = new ImageIcon("Images/arrow.gif");
		      this.imageIcons[1] = new ImageIcon("Images/arrowLeft.gif");
		      this.imageIcons[2] = new ImageIcon("Images/arrowRight.gif");
		      this.imageIcons[3] = new ImageIcon("Images/arrowUp.gif");
		      this.imageIcons[4] = new ImageIcon("Images/arrowDown.gif");
		      this.imageIcons[5] = new ImageIcon("Images/menuSeparation.gif");
		      this.menuImage = ImageIO.read(new File("Images/home.jpg"));
		} catch (IOException e) {
		      e.printStackTrace();}
		
		//Construction du panneau qui reprend tous les panneaux
		principalPanel = new Panel();
		this.card = principalPanel.getCard();
		
		//Construction de l'acceuil
		homePanel = new HomePanel(welcomeImage, principalPanel, imageIcons, "Home");
		actionButton(homePanel.getButton(), "ModeDeJeu");
		
      	//Construction du mode de jeu
      	modePanel = new ModePanel(menuImage, principalPanel, imageIcons, "ModeDeJeu");
      	for (Integer i = 0; i < 3; i++){
      		actionButton(modePanel.getButtons()[i], modePanel.getButtonName()[i]);
      	}
      	
      	//Construction du Panel pour obtenir le nombre de joueur
		playerPanel = new PlayerPanel(menuImage, principalPanel, imageIcons, "Player");
      	
      	//Contruction du panneau de jeu et de score
		gameContentPanel = new Panel(principalPanel, "GamePanel");
		gamePanel = new GamePanel(gameContentPanel);
		scorePanel = new ScorePanel(gameContentPanel);
      	
      
	}
	
	private void actionButton(Button button, String info){
		button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(info.equals("ModeDeJeu")){
            		card.show(principalPanel, info);
            	}else if (info.equals("Mode Quête")||info.equals("Mode Arène")||info.equals("Mode Survivor")){
            		modeDeJeu = info;
            		
            		card.show(principalPanel, "Player");
            		for (Integer i = 1; i <= 4; i++){
        				actionButton(playerPanel.getButtons()[i-1], String.valueOf(i));
        			}
            	
            	}else if (info.equals("1")||info.equals("2")||info.equals("3")||info.equals("4")){
            		nombreDeJoueur = Integer.valueOf(info);
            		
            		//Construction du Panel pour obtenir les information des joueurs
            		identityPanel = new IdentityPanel(menuImage, principalPanel, imageIcons, info);
            		card.show(principalPanel, info);
            		actionButton(identityPanel.getButton(),"Information");
            		
            	}else if (info.equals("Information")){
            		for(Integer i = 0; i < identityPanel.getPlayerName().length; i++){
            			heros[i][0] = identityPanel.getPlayerName()[i].getText();
            			heros[i][1] = (String)identityPanel.getTypeHeros()[i].getSelectedItem();
            		}
            		controle.initComposant(modeDeJeu, heros);
            		card.show(principalPanel, "GamePanel");
            	}
            	
            }
       });
	}

	public void update(ArrayList<WorldEntity> entities) {
		gamePanel.setEntities(entities);
		
	}

}
