

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
