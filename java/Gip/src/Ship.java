
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this class defines each ship, mainly to keep track of what squares it
 * occupies. Also keeps track of whether the ship is sunk;
 * 
 * @author Alec
 *
 */

public class Ship {
	public List<Coordinate> coordinates = new ArrayList<Coordinate>();
	String name;
	boolean sunk = false;
	int length;
	Color color;
	// keeps track of a ships location by marking down the coordinates

	public Ship(String name, int length, Color color) {
		this.name = name;
		this.length = length;
		this.color = color;

	}

	public void shipSunk(Ship s) {
		int counter = 0;
		for (Coordinate c : s.coordinates) {
			if (c.hit) {
				counter++;
				if (counter == s.length) {
					s.sunk = true;
				}
			}
		}
	}

	public void coordinateAdder(Coordinate a, Coordinate b, Ship s) {
		if (s.length > 2) {
			Coordinate E1 = new Coordinate(0, 0);
			Coordinate E2 = new Coordinate(0, 0);
			Coordinate E3 = new Coordinate(0, 0);
			if (s.length == 3) {
				if (a.cellX == b.cellX + (s.length - 1)) {
					E1.cellY = a.cellY;
					E1.cellX = a.cellX - 1;
				} else if (a.cellX == b.cellX - (s.length - 1)) {
					E1.cellY = a.cellY;
					E1.cellX = a.cellX + 1;
				} else if (a.cellY == b.cellY + (s.length - 1)) {
					E1.cellX = a.cellX;
					E1.cellY = a.cellY - 1;
				} else if (a.cellY == b.cellY - (s.length - 1)) {
					E1.cellX = a.cellX;
					E1.cellY = a.cellY + 1;
				}
				s.coordinates.add(E1);
			} else if (s.length == 4) {
				if (a.cellX == b.cellX + (s.length - 1)) {
					E1.cellY = a.cellY;
					E1.cellX = a.cellX - 1;
					E2.cellY = a.cellY;
					E2.cellX = a.cellX - 2;
				} else if (a.cellX == b.cellX - (s.length - 1)) {
					E1.cellY = a.cellY;
					E1.cellX = a.cellX + 1;
					E2.cellY = a.cellY;
					E2.cellX = a.cellX + 2;
				} else if (a.cellY == b.cellY + (s.length - 1)) {
					E1.cellX = a.cellX;
					E1.cellY = a.cellY - 1;
					E2.cellX = a.cellX;
					E2.cellY = a.cellY - 2;
				} else if (a.cellY == b.cellY - (s.length - 1)) {
					E1.cellX = a.cellX;
					E1.cellY = a.cellY + 1;
					E2.cellX = a.cellX;
					E2.cellY = a.cellY + 2;
				}
				s.coordinates.add(E1);
				s.coordinates.add(E2);
			} else {
				if (a.cellX == b.cellX + (s.length - 1)) {
					E1.cellY = a.cellY;
					E1.cellX = a.cellX - 1;
					E2.cellY = a.cellY;
					E2.cellX = a.cellX - 2;
					E3.cellY = a.cellY;
					E3.cellX = a.cellX - 3;
				} else if (a.cellX == b.cellX - (s.length - 1)) {
					E1.cellY = a.cellY;
					E1.cellX = a.cellX + 1;
					E2.cellY = a.cellY;
					E2.cellX = a.cellX + 2;
					E3.cellY = a.cellY;
					E3.cellX = a.cellX + 3;
				} else if (a.cellY == b.cellY + (s.length - 1)) {
					E1.cellX = a.cellX;
					E1.cellY = a.cellY - 1;
					E2.cellX = a.cellX;
					E2.cellY = a.cellY - 2;
					E3.cellX = a.cellX;
					E3.cellY = a.cellY - 3;
				} else if (a.cellY == b.cellY - (s.length - 1)) {
					E1.cellX = a.cellX;
					E1.cellY = a.cellY + 1;
					E2.cellX = a.cellX;
					E2.cellY = a.cellY + 2;
					E3.cellX = a.cellX;
					E3.cellY = a.cellY + 3;
				}
				s.coordinates.add(E1);
				s.coordinates.add(E2);
				s.coordinates.add(E3);
			}
		}
		s.coordinates.add(a);
		s.coordinates.add(b);
	}

	public String sunk(Ship s) {
		int count = 0;
		for (Coordinate c : s.coordinates) {
			if (c.hit == true) {
				count++;
			}
			if (count == s.length) {
				s.sunk = true;
				return s.name + " has sunk \n";
			}
		}
		return "";
	}
}
