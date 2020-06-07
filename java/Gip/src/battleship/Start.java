package battleship;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class serves to run the game. Board gives us the tools we use here to
 * let the game run its course.
 * 
 * @author Alec
 *
 */
public class Start extends JFrame {

	public static void main(String[] args) {
		Board game = new Board();
		game.Menu(game);

	}

}
