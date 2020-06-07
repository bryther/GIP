package battleship;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
	private final static int CELL_SIZE = 30;
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
	private final static int N_ROWS = 10;
	private final static int N_COLS = 10;
	// defines the dimensions of the playing field
	private final static int BOARD_WIDTH = N_COLS * CELL_SIZE;
	private final static int BOARD_HEIGHT = N_ROWS * CELL_SIZE;
	private int[] field;
	// the playing field is a grid, the value of each cell determines its content,
	// whether it's blank, a ship, or a vacant field
	private boolean inGame;
	// true when the game is running, false when it's not
	private int allCells;
	private final JLabel statusbar = new JLabel();

	private Image[] img;

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

	private void GameStart() {
		Fleet.SpawnFleet();
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH * 3, BOARD_HEIGHT * 2);
		JPanel panel = new JPanel();
		frame.add(panel);

	}

	private void Prelude() {
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		JPanel panel = new JPanel();
		frame.add(panel);
		JTextArea PBS = new JTextArea(1, 2);
		JTextArea PBE = new JTextArea(1, 2);
		panel.add(PBS);
		panel.add(PBE);
		JTextArea SMS = new JTextArea(1, 2);
		JTextArea SME = new JTextArea(1, 2);
		panel.add(SMS);
		panel.add(SME);
		JTextArea DSS = new JTextArea(1, 2);
		JTextArea DSE = new JTextArea(1, 2);
		panel.add(DSS);
		panel.add(DSE);
		JTextArea BSS = new JTextArea(1, 2);
		JTextArea BSE = new JTextArea(1, 2);
		panel.add(BSS);
		panel.add(BSE);
		JTextArea ACCS = new JTextArea(1, 2);
		JTextArea ACCE = new JTextArea(1, 2);
		panel.add(ACCS);
		panel.add(ACCE);
		JButton commit = new JButton("Commit coordinates");
		frame.setVisible(true);
	}

	public void Menu(Board a) {
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT / 4);
		JPanel panel = new JPanel();
		frame.add(panel);
		JButton start = new JButton("start game");
		panel.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.Prelude();

			}

		});
		JButton score = new JButton("Score board");
		panel.add(score);
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// method to display the graph
			}
		});
		frame.setVisible(true);
	}

}
