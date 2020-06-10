package battleship;

import javax.swing.JFrame;

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
