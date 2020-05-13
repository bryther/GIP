package battleship;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	private final int N_ROWS = 10;
	private final int N_COLS = 10;
	// defines the dimensions of the playing field
	private final int BOARD_WIDTH = N_COLS * CELL_SIZE + 1;
	private final int BOARD_HEIGHT = N_ROWS * CELL_SIZE + 1;
	private int[] field;
	// the playing field is a grid, the value of each cell determines its content,
	// whether it's blank, a mine, or a clue
	private boolean inGame;
	// true when the game is running, false when it's game over
	private int allCells;
	private final JLabel statusbar;

	private Image[] img;

	public Board(JLabel statusbar) {

		this.statusbar = statusbar;
		initBoard();
	}

	private void initBoard() {

		setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));

		img = new Image[NUM_IMAGES];

		for (int i = 0; i < NUM_IMAGES; i++) {

			var path = "C:\\Users\\DELL\\Desktop\\game images\\minesweeper\\" + i + ".png";
			img[i] = (new ImageIcon(path)).getImage();
		}
		// loads images into the program

		addMouseListener(new Bass_Cannon());
		newGame();
	}

	private void newGame() {

		int cell;

		var random = new Random();
		inGame = true;
		minesLeft = N_MINES;

		allCells = N_ROWS * N_COLS;
		field = new int[allCells];

		for (int i = 0; i < allCells; i++) {

			field[i] = COVER_FOR_CELL;
		}

		statusbar.setText(Integer.toString(minesLeft));

		int i = 0;

		while (i < N_MINES) {

			int position = (int) (allCells * random.nextDouble());

			if ((position < allCells) && (field[position] != COVERED_MINE_CELL)) {

				int current_col = position % N_COLS;
				field[position] = COVERED_MINE_CELL;
				i++;

				if (current_col > 0) {
					cell = position - 1 - N_COLS;
					if (cell >= 0) {
						if (field[cell] != COVERED_MINE_CELL) {
							field[cell] += 1;
						}
					}
					cell = position - 1;
					if (cell >= 0) {
						if (field[cell] != COVERED_MINE_CELL) {
							field[cell] += 1;
						}
					}

					cell = position + N_COLS - 1;
					if (cell < allCells) {
						if (field[cell] != COVERED_MINE_CELL) {
							field[cell] += 1;
						}
					}
				}
				// sets up the mines

				cell = position - N_COLS;
				if (cell >= 0) {
					if (field[cell] != COVERED_MINE_CELL) {
						field[cell] += 1;
					}
				}

				cell = position + N_COLS;
				if (cell < allCells) {
					if (field[cell] != COVERED_MINE_CELL) {
						field[cell] += 1;
					}
				}

				if (current_col < (N_COLS - 1)) {
					cell = position - N_COLS + 1;
					if (cell >= 0) {
						if (field[cell] != COVERED_MINE_CELL) {
							field[cell] += 1;
						}
					}
					cell = position + N_COLS + 1;
					if (cell < allCells) {
						if (field[cell] != COVERED_MINE_CELL) {
							field[cell] += 1;
						}
					}
					cell = position + 1;
					if (cell < allCells) {
						if (field[cell] != COVERED_MINE_CELL) {
							field[cell] += 1;
						}
					}
				}
			}
		}
	}

	// the process of starting up the game
	private class Bass_Cannon extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {

			int x = e.getX();
			int y = e.getY();

			int cCol = x / CELL_SIZE;
			int cRow = y / CELL_SIZE;

			boolean doRepaint = false;

			if (!inGame) {

				newGame();
				repaint();
			}

			if ((x < N_COLS * CELL_SIZE) && (y < N_ROWS * CELL_SIZE)) {

				if (e.getButton() == MouseEvent.BUTTON3) {

					if (field[(cRow * N_COLS) + cCol] > MINE_CELL) {

						doRepaint = true;

						if (field[(cRow * N_COLS) + cCol] <= COVERED_MINE_CELL) {

							if (minesLeft > 0) {
								field[(cRow * N_COLS) + cCol] += MARK_FOR_CELL;
								minesLeft--;
								String msg = Integer.toString(minesLeft);
								statusbar.setText(msg);
							} else {
								statusbar.setText("No marks left");
							}
						} else {

							field[(cRow * N_COLS) + cCol] -= MARK_FOR_CELL;
							minesLeft++;
							String msg = Integer.toString(minesLeft);
							statusbar.setText(msg);
						}
					}

				} else {

					if (field[(cRow * N_COLS) + cCol] > COVERED_MINE_CELL) {

						return;
					}

					if ((field[(cRow * N_COLS) + cCol] > MINE_CELL)
							&& (field[(cRow * N_COLS) + cCol] < MARKED_MINE_CELL)) {

						field[(cRow * N_COLS) + cCol] -= COVER_FOR_CELL;
						doRepaint = true;

						if (field[(cRow * N_COLS) + cCol] == MINE_CELL) {
							inGame = false;
						}

						if (field[(cRow * N_COLS) + cCol] == EMPTY_CELL) {
							find_empty_cells((cRow * N_COLS) + cCol);
						}
					}
				}

				if (doRepaint) {
					repaint();
				}
			}
		}
	}
}
