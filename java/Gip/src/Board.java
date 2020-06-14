
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
	Ship AACC = new Ship("Ally Aircraft Carrier", 5, Color.GREEN);
	Ship ABS = new Ship("Ally Battleship", 4, Color.CYAN);
	Ship ADS = new Ship("Ally Destroyer", 3, Color.MAGENTA);
	Ship ASM = new Ship("Ally Submarine", 3, Color.YELLOW);
	Ship APB = new Ship("Ally Aircraft Carrier", 2, Color.ORANGE);
	Ship EACC = new Ship("Enemy Aircraft Carrier", 5, Color.RED);
	Ship EBS = new Ship("Enemy Battleship", 4, Color.RED);
	Ship EDS = new Ship("Enemy Destroyer", 3, Color.RED);
	Ship ESM = new Ship("Enemy Submarine", 3, Color.RED);
	Ship EPB = new Ship("Enemy Patrol Boat", 2, Color.RED);
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
	private boolean won;
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

	private void endScreen(Board a) {
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT / 2);
		frame.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		GridLayout gameOver = new GridLayout(3, 1);
		frame.add(panel);
		panel.setLayout(gameOver);
		JLabel label = new JLabel();
		if (won) {
			label.setText("Game Over. You won!");
		} else {
			label.setText("Game Over. You lost!");
		}
		JButton newGame = new JButton("New Game?");
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.Prelude(a);
				frame.dispose();
			}

		});
		frame.setVisible(true);
		JButton scoreBoard = new JButton("Scoreboard");
		scoreBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a.scoreBoard(a);
				frame.dispose();

			}

		});
		panel.add(label);
		panel.add(newGame);
		panel.add(scoreBoard);
		frame.setVisible(true);

	}

	private void GameStart(Board a) {
		inGame = true;
		enemyFleet.spawnFleet(Randomize.randomWithRange(0, 9), EACC, EBS, EDS, ESM, EPB);
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
		log.append(enemyFleet.printer(enemyFleet));

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
							enemyFleet.sinker();
							button.setBackground(Color.RED);
							log.append("struck " + button.x + "." + button.y + "; enemy ship hit! \n");
							myScore++;
							if (EACC.sunk) {
								log.append(EACC.name + " has sunk.\n");
							}
							if (EBS.sunk) {
								log.append(EBS.name + " has sunk.\n");
							}
							if (EDS.sunk) {
								log.append(EDS.name + " has sunk.\n");
							}
							if (ESM.sunk) {
								log.append(ESM.name + " has sunk.\n");
							}
							if (EPB.sunk) {
								log.append(EPB.name + " has sunk.\n");
							}
							if (enemyFleet.sunk()) {
								inGame = false;
								SqlConnect.saveScore(playerName, myScore, enemyScore, "won");
								won = true;
								a.endScreen(a);
								frame.dispose();
							}

						} else {
							log.append("struck " + button.x + "." + button.y + "; missed. \n");

							button.setBackground(Color.WHITE);
						}

						int enemyX = Randomize.randomWithRange(0, 9);
						int enemyY = Randomize.randomWithRange(0, 9);
						if (myFleet.bomber(enemyX, enemyY)) {
							myFleet.sinker();
							a.findSquareAtCoordinates(enemyX, enemyY).setBackground(Color.RED);
							enemyScore++;
							log.append("Enemy struck " + enemyX + "." + enemyY + "; Ally ship hit! \n");

							if (AACC.sunk) {
								log.append(AACC.name + " has sunk.\n");
							}
							if (ABS.sunk) {
								log.append(ABS.name + " has sunk.\n");
							}
							if (ADS.sunk) {
								log.append(ADS.name + " has sunk.\n");
							}
							if (ASM.sunk) {
								log.append(ASM.name + " has sunk.\n");
							}
							if (APB.sunk) {
								log.append(APB.name + " has sunk.\n");
							}
							if (myFleet.sunk()) {
								inGame = false;
								SqlConnect.saveScore(playerName, myScore, enemyScore, "Lost");
								a.endScreen(a);
								frame.dispose();

							}
						} else {
							log.append("enemy struck " + enemyX + "." + enemyY + "; missed. \n");
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
		won = false;
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
							for (int k = 1; k <= button.squareFinder(tempS, tempT); k++) {
								if (tempS.cellX == tempT.cellX && tempS.cellY < tempT.cellY) {
									a.findButtonAtCoordinates(tempS.cellX, tempS.cellY + k).setBackground(Color.BLACK);
								} else if (tempS.cellX == tempT.cellX && tempS.cellY > tempT.cellY) {
									a.findButtonAtCoordinates(tempS.cellX, tempS.cellY - k).setBackground(Color.BLACK);
								} else if (tempS.cellX < tempT.cellX && tempS.cellY == tempT.cellY) {
									a.findButtonAtCoordinates(tempS.cellX + k, tempS.cellY).setBackground(Color.BLACK);
								} else if (tempS.cellX > tempT.cellX && tempS.cellY == tempT.cellY) {
									a.findButtonAtCoordinates(tempS.cellX - k, tempS.cellY).setBackground(Color.BLACK);
								}

							}
							if (shipCount == 0) {
								AACC.coordinateAdder(tempS, tempT, AACC);
								myFleet.addShip(AACC);
								log.append(AACC.name + "added (" + tempS.cellX + "." + tempS.cellY + "),(" + tempT.cellX
										+ "." + tempT.cellY + ")\n");
								log.append("Add battleship\n");
								shipCount++;
							} else if (shipCount == 1) {
								ABS.coordinateAdder(tempS, tempT, ABS);
								myFleet.addShip(ABS);
								log.append(ABS.name + "added (" + tempS.cellX + "." + tempS.cellY + "),(" + tempT.cellX
										+ "." + tempT.cellY + ")\n");
								log.append("Add Destroyer\n");
								shipCount++;
							} else if (shipCount == 2) {
								ADS.coordinateAdder(tempS, tempT, ADS);
								myFleet.addShip(ADS);
								log.append(ADS.name + "added (" + tempS.cellX + "." + tempS.cellY + "),(" + tempT.cellX
										+ "." + tempT.cellY + ")\n");
								log.append("Add Submarine\n");
								shipCount++;

							} else if (shipCount == 3) {
								ASM.coordinateAdder(tempS, tempT, ASM);
								myFleet.addShip(ASM);
								log.append(ASM.name + "added (" + tempS.cellX + "." + tempS.cellY + "),(" + tempT.cellX
										+ "." + tempT.cellY + ")\n");
								log.append("Add Patrol Boat\n");
								shipCount++;
							} else {
								APB.coordinateAdder(tempS, tempT, APB);
								myFleet.addShip(APB);
								a.GameStart(a);
								frame.dispose();
							}
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

	public void name(Board a) {
		JFrame frame = new JFrame();
		frame.setSize(BOARD_WIDTH, BOARD_HEIGHT / 2);
		frame.setLocationRelativeTo(null);
		GridLayout name = new GridLayout(2, 1);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(name);
		JTextArea text = new JTextArea();
		text.setSize(BOARD_WIDTH - 1, BOARD_HEIGHT / 4);
		panel.add(text);
		JButton start = new JButton("start game");
		panel.add(start);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = text.getText();
				a.Prelude(a);
				frame.dispose();

			}

		});
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
				a.name(a);
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
