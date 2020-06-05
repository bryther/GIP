package battleship;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.*;

/**
 * This class serves to set up the board, and to operate the game once it begins
 * to run.
 * 
 * @author Alec
 *
 */
public class Board extends JPanel {

	private final int NUM_IMAGES = 4;
	private final int CELL_SIZE = 30;
	// defines the size of each individual cell
	private final int FILLED_CELL = 1;
	private final int COVERED_CELL = 3;
	private final int HIT_CELL = 2;
	private final int EMPTY_CELL = 0;
	// defines our 4 types of cells and their corresponding image. by default, all
	// squares are blue, the ships are black, hit ship parts
	// are red and missed shots are marked white
	private final int SHIP_SQUARES = 17;
	// the total amount of squares occupied by ships. might change depending on my
	// placement algorithm
	private final int N_ROWS = 10;
	private final int N_COLS = 10;
	// defines the dimensions of the playing field
	private final int BOARD_WIDTH = N_COLS * CELL_SIZE + 32;
	private final int BOARD_HEIGHT = N_ROWS * CELL_SIZE + 32;
	private int[] field;
	// the playing field is a grid, the value of each cell determines its content,
	// whether it's blank, a ship, or a vacant field
	private boolean inGame;
	// true when the game is running, false when it's not
	private int allCells;
	private final JLabel statusbar = new JLabel();

	private Image[] img;

	private void initBoard() {

		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

		img = new Image[NUM_IMAGES];

		for (int i = 0; i < NUM_IMAGES; i++) {

			var path = "src\\game_image\\" + i + ".png";
			img[i] = (new ImageIcon(path)).getImage();
		}
		// loads images into the program

		newGame();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawBoard(g);
	}

	public void drawBoard(Graphics g) {

		for (int i = 0; i < BOARD_WIDTH; i++) {
			g.drawLine(0, i * CELL_SIZE, BOARD_HEIGHT * CELL_SIZE, i * CELL_SIZE);
		}
		for (int j = 0; j < BOARD_HEIGHT; j++) {
			g.drawLine(0, j * CELL_SIZE, BOARD_WIDTH * CELL_SIZE, j * CELL_SIZE);
		}

	}
	// This draws the board for us.

	private void newGame() {

	}

	public void menu() {
		JFrame frame = new JFrame("xx");
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		JPanel panel = new JPanel();
		frame.add(panel);
		JButton Start = new JButton("Start game");
		panel.add(Start);
	}

	// the process of starting up the game

}
