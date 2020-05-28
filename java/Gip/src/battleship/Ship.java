package battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * defines each ship, mainly to keep track of what squares it occupies. Also
 * keeps track of whether the ship is sunk;
 * 
 * @author Alec
 *
 */

public class Ship {
	List<Coordinate> coordinates = new ArrayList<Coordinate>();
	boolean sunk;
	// keeps track of a ships location by marking down the coordinates
}
