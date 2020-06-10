package battleship;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
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

import battleship.Coordinate;
import battleship.CoordinateButton;
import battleship.Fleet;
import battleship.Ship;

import java.util.*;

/**
 * This class serves to set up the board, and to operate the game once it begins
 * to run.
 * 
 * @author Alec
 *
 */
public class Board extends JPanel {

	Fleet enemyFleet = new Fleet();
	Fleet myFleet = new Fleet();
	private final static int CELL_SIZE = 30;
	// defines the size of each individual cell
	private final static int N_ROWS = 10;
	private final static int N_COLS = 10;
	// defines the dimensions of the playing field
	private final static int BOARD_WIDTH = N_COLS * CELL_SIZE;
	private final static int BOARD_HEIGHT = N_ROWS * CELL_SIZE;
	// the playing field is a grid, the value of each cell determines its content,
	// whether it's blank, a ship, or a vacant field
	private boolean inGame;
	private List<CoordinateButton> buttonsonfieldlist = new ArrayList<CoordinateButton>();
	// true when the game is running, false when it's not

	private void GameStart() {
		inGame = true;
		enemyFleet.spawnFleet(Randomize.randomWithRange(0, 9), enemyFleet);
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH * 4, BOARD_HEIGHT * 2);
		JPanel panel = new JPanel();
		GridLayout master = new GridLayout(1, 2);
		panel.setLayout(master);
		GridLayout grid = new GridLayout(10, 10);
		JPanel field = new JPanel();
		field.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		JTextArea log = new JTextArea();
		field.setLayout(grid);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				CoordinateButton button = new CoordinateButton(i, j);
				button.setBackground(Color.BLUE);
				field.add(button);
				buttonsonfieldlist.add(button);
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						boolean hit = enemyFleet.bomber(button.x, button.y);
						if (hit) {
							button.setBackground(Color.RED);
							log.append(enemyFleet.sunk());
							if (enemyFleet.fleetSunk()) {
								inGame = false;
							}
							;
						} else {
							button.setBackground(Color.WHITE);
						}
						hit = myFleet.bomber(Randomize.randomWithRange(0, 9), Randomize.randomWithRange(0, 9));
						if (hit) {
							log.append(button.x + "." + button.y + "Hit \n");
							log.append(myFleet.sunk());
							if (myFleet.fleetSunk()) {
								inGame = false;
							}
						} else {
							log.append(button.x + "." + button.y + " Missed \n");
						}
					}
				});
				/*
				 * // kleur schepen in met groen for (Ship s : enemyFleet.ships) { for
				 * (Coordinate c : s.coordinates) { if (c.cellX == button.x && c.cellY ==
				 * button.y) { button.setBackground(Color.GREEN); } } }
				 */
			}
		}
		frame.add(panel);
		panel.add(field);
		panel.add(log);
		frame.setVisible(true);
	}
	
	public CoordinateButton findButtonAtCoordinates(int x, int y) {
		for (CoordinateButton button : buttonsonfieldlist) {
			if (button.x == x && button.y == y) {
				return button;
			}
		}
		return null;
	}

	private void Prelude() {
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		JPanel panel = new JPanel();
		frame.add(panel);
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
				a.GameStart();
				frame.dispose();

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
