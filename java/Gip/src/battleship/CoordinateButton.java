package battleship;

import javax.swing.JButton;

public class CoordinateButton extends JButton{
	int x;
	int y;

	public CoordinateButton(int x, int y) {
		this.x = x;
		this.y = y;
		this.setText(x + ":" + y);;
	}
}
