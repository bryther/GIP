package battleship;

import javax.swing.JLabel;

public class CoordinateLabel extends JLabel {
	public int x;
	public int y;

	public CoordinateLabel(int x, int y) {
		this.x = x;
		this.y = y;
		this.setText(x + ":" + y);
		;
	}

}
