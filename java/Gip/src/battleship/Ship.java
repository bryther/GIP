package battleship;

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
	List<Coordinate> coordinates = new ArrayList<Coordinate>();
	String name;
	boolean sunk = false;
	int length;
	// keeps track of a ships location by marking down the coordinates
}
