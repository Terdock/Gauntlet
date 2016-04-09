package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Menu {

	private JFrame frame;
	private Image welcome_image;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CardLayout card = new CardLayout();
		
		try {
		      this.welcome_image = ImageIO.read(new File("welcome.jpg"));
		    } catch (IOException e) {
		      e.printStackTrace();
		    } 
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel welcome_panel = new Panel(welcome_image);
		frame.getContentPane().add(welcome_panel, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		welcome_panel.add(btnNewButton);
	}

}
