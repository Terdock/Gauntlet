package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame{
	private Image welcomeImage;
	private Panel generalPanel;
	private CardLayout card;
	
	
	
	public Window(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gauntlet");
        this.setSize(1000+16,600+39);
        this.setResizable(false);
        setLocationRelativeTo(null);
        initialisation();
        this.getContentPane().add(generalPanel, BorderLayout.CENTER);
	}
	
	private void initialisation(){
		
		//Chargement d'image tout au début dans la mémoire RAM.
		try {
		      this.welcomeImage = ImageIO.read(new File("welcome.jpg"));
		      //this.menuImage = ImageIO.read(new File(""));
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		
		
		//Construction du panneau qui reprend tous les panneaux
		generalPanel = new Panel(0, 0, 1000, 600);
		this.card = generalPanel.getCard();
	}

}
