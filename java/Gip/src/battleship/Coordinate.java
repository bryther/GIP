package battleship;

import javax.swing.ImageIcon;

/**
 * This class describes the traits of every square on the grid. It's also used
 * to record the locations of the ships
 * 
 * @author Alec
 *
 */
public class Coordinate {
	public int cellX;
	public int cellY;
	public boolean hit;
	// the different traits a coordinate can have: it's location, the image used,
	// and whether it's been hit.

	public Coordinate(int cellX, int cellY) {
		this.cellX = cellX;
		this.cellY = cellY;
	}

}
