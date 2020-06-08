package battleship;

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
}
