
import java.awt.Color;

import javax.swing.JButton;

public class CoordinateButton extends JButton {
	public int x;
	public int y;

	public CoordinateButton(int x, int y) {
		this.x = x;
		this.y = y;
		this.setText(x + ":" + y);
		;
	}

	public int squareFinder(Coordinate a, Coordinate b) {
		int squares = 0;
		if (a.cellX == b.cellX) {
			squares = Math.abs(a.cellY - b.cellY) - 1;
		} else {
			squares = Math.abs(a.cellX - b.cellX) - 1;
		}

		return squares;
	}

}
