package View;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

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
	private LoadImage loadImage = new LoadImage();
	private ImageIcon[] imageIcons = new ImageIcon[6];
	private String[][] heros = new String[5][2];
    private Image welcomeImage, menuImage, scoreImage;
    private AbstractControler controle;
    private Integer playerNumber;
	
	public Window(AbstractControler controle){
		this.controle = controle;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gauntlet");
        this.setSize(1000,600+29);
        this.setResizable(false);
        setLocationRelativeTo(null);
        initialisation();
        this.getContentPane().add(principalPanel);
        setVisible(true);
	}

	private void initialisation(){
		//Chargement d'images
		imageIcons = loadImage.loadIconImage();
		welcomeImage = loadImage.loadBackground()[0];
		menuImage = loadImage.loadBackground()[1];
		scoreImage = loadImage.loadBackground()[2];
		
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
		scorePanel = new ScorePanel(gameContentPanel, scoreImage);
      	
      
	}
	
	private void actionButton(Button button, String info){
		button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(info.equals("ModeDeJeu")){
            		card.show(principalPanel, info);
            	}else if (info.equals("Mode Quête")){
            		modeDeJeu = info;
            		playerNumber = 1;
            		
            		//Construction du Panel pour obtenir les informations du joueur en Mode Quête
            		identityPanel = new IdentityPanel(menuImage, principalPanel, imageIcons, "1");
            		card.show(principalPanel, "1");
            		actionButton(identityPanel.getButton(),"Information");
            	}else if (info.equals("Mode Arène")||info.equals("Mode Survivor")){
            		modeDeJeu = info;
            		
            		card.show(principalPanel, "Player");
            		for (Integer i = 1; i <= 2; i++){
        				actionButton(playerPanel.getButtons()[i-1], String.valueOf(i));
        			}
            	
            	}else if (info.equals("1")||info.equals("2")){
            		playerNumber = Integer.valueOf(info);
            		
            		//Construction du Panel pour obtenir les informations des joueurs en Mode Arène et Mode Survivor
            		identityPanel = new IdentityPanel(menuImage, principalPanel, imageIcons, info);
            		card.show(principalPanel, info);
            		actionButton(identityPanel.getButton(),"Information");
            		
            	}else if (info.equals("Information")){
            		for(Integer i = 0; i < playerNumber; i++){
            			heros[i][0] = identityPanel.getPlayerName()[i].getText();
            			heros[i][1] = (String)identityPanel.getTypeHeros()[i].getSelectedItem();
            		}
            		gamePanel.setPlayerNumber(playerNumber);
            		gamePanel.addKeyboard();
            		scorePanel.addName(heros, playerNumber);
            		controle.initComposant(modeDeJeu, heros);
            		card.show(principalPanel, "GamePanel");
            	}
            }
       });
	}

	public void update(ArrayList<WorldEntity> entities) {
		gamePanel.setEntities(entities);
		
	}


	public void update(Integer numberMap) {
		gamePanel.setNumberMap(numberMap);
	}

}
