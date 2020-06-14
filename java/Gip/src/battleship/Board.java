package battleship;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

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
	SqlConnect c = new SqlConnect();
	private final static int CELL_SIZE = 30;
	// defines the size of each individual cell
	private final static int N_ROWS = 10;
	private final static int N_COLS = 10;
	// defines the dimensions of the playing field
	private final static int BOARD_WIDTH = N_COLS * CELL_SIZE;
	private final static int BOARD_HEIGHT = N_ROWS * CELL_SIZE;
	int shipCount = 0;
	boolean fr = false;
	private List<CoordinateButton> buttonsonfieldlist = new ArrayList<CoordinateButton>();
	private List<CoordinateLabel> squaresonfieldlist = new ArrayList<CoordinateLabel>();
	// the playing field is a grid, the value of each cell determines its content,
	// whether it's blank, a ship, or a vacant field
	private boolean inGame;
	public int myScore = 0;
	public int enemyScore = 0;
	public int roundsPassed = 0;
	public String playerName;
	// true when the game is running, false when it's not

	public CoordinateButton findButtonAtCoordinates(int x, int y) {
		for (CoordinateButton button : buttonsonfieldlist) {
			if (button.x == x && button.y == y) {
				return button;
			}
		}
		return null;

	}

	public CoordinateLabel findSquareAtCoordinates(int x, int y)

	{
		for (CoordinateLabel square : squaresonfieldlist) {
			if (square.x == x && square.y == y) {
				return square;
			}
		}
		return null;
	}

	private void GameStart(Board a) {
		inGame = true;
		enemyFleet.spawnFleet(Randomize.randomWithRange(0, 9), enemyFleet);
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH * 3, BOARD_HEIGHT);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		GridLayout master = new GridLayout(1, 2);
		panel.setLayout(master);
		GridLayout grid = new GridLayout(10, 10);
		JPanel field1 = new JPanel();
		field1.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		JPanel field2 = new JPanel();
		field2.setLayout(grid);
		field2.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		JTextArea log = new JTextArea();
		field1.setLayout(grid);
		JScrollPane scroll = new JScrollPane(log);
		;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				CoordinateButton button = new CoordinateButton(i, j);
				button.setBackground(Color.BLUE);
				field1.add(button);
				buttonsonfieldlist.add(button);
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (enemyFleet.bomber(button.x, button.y)) {
							button.setBackground(Color.RED);
							log.append("struck " + button.x + "." + button.y + "; enemy ship hit! \n");
							myScore++;
							if (enemyFleet.sunk()) {
								inGame = false;
								SqlConnect.saveScore(playerName, myScore, enemyScore, "won");
							}

						} else {
							log.append("struck " + button.x + "." + button.y + "; missed. \n");

							button.setBackground(Color.WHITE);
						}

						int enemyX = Randomize.randomWithRange(0, 9);
						int enemyY = Randomize.randomWithRange(0, 9);
						if (myFleet.bomber(enemyX, enemyY)) {
							a.findSquareAtCoordinates(enemyX, enemyY).setBackground(Color.RED);
							log.append("enemy struck " + enemyX + "." + enemyY + "; ally ship hit! \n");
							enemyScore++;
							if (myFleet.sunk()) {
								inGame = false;
								SqlConnect.saveScore(playerName, myScore, enemyScore, "lost");
							}
						} else {
							log.append("enemy struck " + button.x + "." + button.y + "; missed. \n");
							a.findSquareAtCoordinates(enemyX, enemyY).setBackground(Color.WHITE);
						}
						roundsPassed++;
					}
				});
				/*
				 * // kleur schepen in met groen for (Ship s : enemyFleet.ships) { for
				 * (Coordinate c : s.coordinates) { if (c.cellX == button.x && c.cellY ==
				 * button.y) { button.setBackground(Color.GREEN); } } }
				 */
			}
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				CoordinateLabel square = new CoordinateLabel(i, j);
				square.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
				square.setBackground(Color.BLUE);
				if (myFleet.scanner(square.x, square.y)) {
					square.setBackground(myFleet.painter(square.x, square.y));
				}
				square.setOpaque(true);
				field2.add(square);
				squaresonfieldlist.add(square);
			}

		}
		frame.add(panel);
		scroll.setViewportView(log);
		panel.add(field1);
		panel.add(scroll);
		panel.add(field2);
		log.setEditable(false);
		frame.setVisible(true);
	}

	private void Prelude(Board a) {
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH * 4, BOARD_HEIGHT * 2);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		GridLayout master = new GridLayout(1, 2);
		panel.setLayout(master);
		GridLayout grid = new GridLayout(10, 10);
		JPanel field = new JPanel();
		field.setSize(BOARD_WIDTH, BOARD_HEIGHT);
		JTextArea log = new JTextArea();
		field.setLayout(grid);
		Coordinate tempS = new Coordinate(0, 0);
		Coordinate tempT = new Coordinate(0, 0);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				CoordinateButton button = new CoordinateButton(i, j);
				button.setBackground(Color.BLUE);
				field.add(button);
				buttonsonfieldlist.add(button);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (!fr) {
							tempS.cellX = button.x;
							tempS.cellY = button.y;
							button.setBackground(Color.BLACK);
							fr = true;
						} else {
							tempT.cellX = button.x;
							tempT.cellY = button.y;
							button.setBackground(Color.BLACK);
							if (shipCount == 0) {
								myFleet.addACC(tempS, tempT);
								log.append("Ally Carrier added (" + String.valueOf(tempS.cellX) + "."
										+ String.valueOf(tempS.cellY) + ")/(" + String.valueOf(tempT.cellX) + "."
										+ String.valueOf(tempT.cellY) + ")\n");
								log.append("Add Ally Battleship \n");
								if (tempS.cellX - tempT.cellX > 0) {
									for (int k = 1; k < 4; k++) {
										a.findButtonAtCoordinates(button.x + k, button.y).setBackground(Color.BLACK);
									}

								} else if (tempS.cellX - tempT.cellX < 0) {
									for (int k = 1; k < 4; k++) {
										a.findButtonAtCoordinates(button.x - k, button.y).setBackground(Color.BLACK);
									}
								} else if (tempS.cellY - tempT.cellY > 0) {
									for (int k = 1; k < 4; k++) {
										a.findButtonAtCoordinates(button.x, button.y + k).setBackground(Color.BLACK);
									}

								} else if (tempS.cellY - tempT.cellY < 0) {
									for (int k = 1; k < 4; k++) {
										a.findButtonAtCoordinates(button.x, button.y - k).setBackground(Color.BLACK);
									}
								}

							} else if (shipCount == 1) {
								myFleet.addBS(tempS, tempT);
								log.append("Ally Battleship added (" + String.valueOf(tempS.cellX) + "."
										+ String.valueOf(tempS.cellY) + ")/(" + String.valueOf(tempT.cellX) + "."
										+ String.valueOf(tempT.cellY) + ")\n");
								log.append("Add Ally Destroyer \n");
								if (tempS.cellX - tempT.cellX > 0) {
									for (int k = 1; k < 3; k++) {
										a.findButtonAtCoordinates(button.x + k, button.y).setBackground(Color.BLACK);
									}

								} else if (tempS.cellX - tempT.cellX < 0) {
									for (int k = 1; k < 3; k++) {
										a.findButtonAtCoordinates(button.x - k, button.y).setBackground(Color.BLACK);
									}
								} else if (tempS.cellY - tempT.cellY > 0) {
									for (int k = 1; k < 3; k++) {
										a.findButtonAtCoordinates(button.x, button.y + k).setBackground(Color.BLACK);
									}

								} else if (tempS.cellY - tempT.cellY < 0) {
									for (int k = 1; k < 3; k++) {
										a.findButtonAtCoordinates(button.x, button.y - k).setBackground(Color.BLACK);
									}
								}

							} else if (shipCount == 2 || shipCount == 3) {
								if (shipCount == 2) {
									myFleet.addDS(tempS, tempT);
									log.append("Ally Destroyer added (" + String.valueOf(tempS.cellX) + "."
											+ String.valueOf(tempS.cellY) + ")/(" + String.valueOf(tempT.cellX) + "."
											+ String.valueOf(tempT.cellY) + ")\n");
									log.append("Add Ally Submarine \n");

								} else {
									myFleet.addSM(tempS, tempT);
									log.append("Ally Submarine added (" + String.valueOf(tempS.cellX) + "."
											+ String.valueOf(tempS.cellY) + ")/(" + String.valueOf(tempT.cellX) + "."
											+ String.valueOf(tempT.cellY) + ")\n");
									log.append("Add Ally Patrol Boat  \n");
								}

								if (tempS.cellX - tempT.cellX > 0) {
									a.findButtonAtCoordinates(button.x + 1, button.y).setBackground(Color.BLACK);

								} else if (tempS.cellX - tempT.cellX < 0) {
									a.findButtonAtCoordinates(button.x - 1, button.y).setBackground(Color.BLACK);

								} else if (tempS.cellY - tempT.cellY > 0) {
									a.findButtonAtCoordinates(button.x, button.y + 1).setBackground(Color.BLACK);

								} else if (tempS.cellY - tempT.cellY < 0) {
									a.findButtonAtCoordinates(button.x, button.y - 1).setBackground(Color.BLACK);

								}

							} else if (shipCount == 4) {
								myFleet.addPB(tempS, tempT);
								a.GameStart(a);
								frame.dispose();

							}
							shipCount++;
							fr = false;
						}
					}

				});

			}
		}
		log.append("add ally Carrier\n");
		frame.add(panel);
		panel.add(field);
		panel.add(log);
		frame.setVisible(true);

	}

	private void scoreBoard(Board a) {
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH * 4, BOARD_HEIGHT * 2);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		frame.add(panel);
		JTable table = new JTable();
		JScrollPane score = new JScrollPane(table);
		table.setModel(c.highScore());
		panel.add(score);
		frame.setVisible(true);
	}

	public void Menu(Board a) {
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT / 4);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		frame.add(panel);
		JButton start = new JButton("start game");
		panel.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.Prelude(a);
				frame.dispose();

			}

		});
		JButton score = new JButton("Score board");
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.scoreBoard(a);
				frame.dispose();

			}

		});
		panel.add(score);
		score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// method to display the graph
			}
		});
		frame.setVisible(true);
	}

}
