package View;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Controller.AbstractController;

public class Window extends JFrame{
	
	private CardLayout card;
	private Panel[] panel = new Panel[10];
	private LoadImage loadImage = new LoadImage();
	private ImageIcon[] imageIcons = new ImageIcon[6];
	private String[][] heros = new String[5][2];
	private Image[] backgroundImages = new Image[4];
    private Integer playerNumber;
    private Integer[] dimensions = new Integer[2];
    private String modeDeJeu;
    private AbstractController controller;
	
	public Window(AbstractController controller){
		this.controller = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gauntlet");
        this.setSize(1000,600+29);
        this.setResizable(false);
        setLocationRelativeTo(null);
        initialisation();
        this.getContentPane().add(panel[0]);
        setVisible(true);
	}

	public Panel[] getPanel() {
		return panel;
	}

	private void initialisation(){
		//Chargement d'images
		imageIcons = loadImage.loadIconImage();
		for(int i = 0; i < 4; i++){
			backgroundImages[i] = loadImage.loadBackground()[i];
		}
		
		//Construction du panneau qui reprend tous les panneaux
		panel[0] = new Panel();
		this.card = panel[0].getCard();
		
		//Construction de l'acceuil
		panel[1] = new HomePanel(backgroundImages[0], panel[0], imageIcons, "Home");
		actionButton(((HomePanel) panel[1]).getButton(), "ModeDeJeu");
		
      	//Construction du mode de jeu
		panel[2] = new ModePanel(backgroundImages[1], panel[0], imageIcons, "ModeDeJeu");
      	for (Integer i = 0; i < 3; i++){
      		actionButton(((ModePanel) panel[2]).getButtons()[i], ((ModePanel) panel[2]).getButtonName()[i]);
      	}
      	
      	//Construction du Panel pour obtenir le nombre de joueur
		panel[3] = new PlayerPanel(backgroundImages[1], panel[0], imageIcons, "Player");
      	
      	//Contruction du panneau de jeu et de score
		panel[5] = new Panel(panel[0], "GamePanel");
		panel[6] = new ScorePanel(panel[5], backgroundImages[2]);
		panel[7] = new GamePanel(card, panel[0], panel[5], controller);
		
		//Construction du panneau d'horreur
		panel[9] = new HorrorPanel(card, panel[0], backgroundImages[3], "Horror");
		
		//Construction du panneau pour recommencer
		panel[8] = new AgainPanel(panel[0], backgroundImages[1], imageIcons, "Play Again");
		actionButton(((AgainPanel) panel[8]).getButtons()[0], "Rejouer");
		actionButton(((AgainPanel) panel[8]).getButtons()[1], "Quitter");
      	
	}
	
	
	//Ajout des diff�rentes actions que doivent faire les boutons des panneaux.
	private void actionButton(Button button, String info){
		button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(info.equals("ModeDeJeu")){
            		card.show(panel[0], info);
            	}else if (info.equals("Mode Qu�te") || info.equals("Mode Ar�ne")){
            		modeDeJeu = info;
            		controller.setGameMode(info);
            		if(info.equals("Mode Qu�te")){
            			playerNumber = 1;
            		}else if(info.equals("Mode Ar�ne")){
            			playerNumber = 2;
            		}
            		controller.setGamePlayerNumber(playerNumber);
            		
            		//Construction du Panel pour obtenir les informations du joueur
            		panel[4] = new IdentityPanel(backgroundImages[1], panel[0], imageIcons, String.valueOf(playerNumber));
            		card.show(panel[0], String.valueOf(playerNumber));
            		actionButton(((IdentityPanel)panel[4]).getButton(),"Information");
            	}else if (info.equals("1") || info.equals("2")){
            		playerNumber = Integer.valueOf(info);
            		controller.setGamePlayerNumber(playerNumber);
            		
            		//Construction du Panel pour obtenir les informations du joueur
            		panel[4] = new IdentityPanel(backgroundImages[1], panel[0], imageIcons, info, 0);
            		card.show(panel[0], info);
            		actionButton(((IdentityPanel)panel[4]).getButton(),"Information");
            	}else if (info.equals("Mode Survivor")){
            		modeDeJeu = info;
            		controller.setGameMode(info);
            		
            		card.show(panel[0], "Player");
            		for (Integer i = 1; i <= 2; i++){
        				actionButton(((PlayerPanel)panel[3]).getButtons()[i-1], String.valueOf(i));
        			}
            	
            	}else if (info.equals("Information")){
            		for(Integer i = 0; i < playerNumber; i++){
            			heros[i][0] = ((IdentityPanel)panel[4]).getPlayerName()[i].getText();
            			heros[i][1] = (String)((IdentityPanel)panel[4]).getTypeHeros()[i].getSelectedItem();
            		}
            		dimensions[1] = (Integer) ((IdentityPanel)panel[4]).getDimensions()[0].getSelectedItem();
            		dimensions[0] = (Integer) ((IdentityPanel)panel[4]).getDimensions()[1].getSelectedItem();
            		controller.setDimensions(dimensions);
            		((ScorePanel)panel[6]).setPlayerAndHeros(playerNumber, heros);
            		((ScorePanel)panel[6]).addName();
            		((GamePanel)panel[7]).addKeyboard(playerNumber);
            		((GamePanel)panel[7]).setModeDeJeu(modeDeJeu);
            		((AgainPanel)panel[8]).setPlayerAndHeros(playerNumber, heros);
            		controller.initComposant(heros);
            		card.show(panel[0], "GamePanel");
            	}else if(info.equals("Rejouer")){
            		card.show(panel[0], "ModeDeJeu");
            	}else if(info.equals("Quitter")){
            		System.exit(0);
            	}
            }
       });
	}


	
}
