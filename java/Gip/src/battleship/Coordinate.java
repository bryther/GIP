package battleship;

import javax.swing.ImageIcon;

public class Coordinate {
	public int cellX;
	public int cellY;
	public ImageIcon bgImage;
	// boolean filled;
	boolean hit;
	// the different traits a coordinate can have: it's location, the image used,
	// and whether it's been hit.

	public Coordinate(int cellX, int cellY) {
		this.cellX = cellX;
		this.cellY = cellY;
	}

}
