
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This class keeps track of our own and the enemy's fleet. It has two lists
 * keeping track of the ships, and various methods to attack and keep track of
 * each side's ships.
 * 
 * @author Alec
 *
 */
public class Fleet {
	public List<Ship> ships = new ArrayList<Ship>();
	int[][] grid = new int[10][10];

	public String printer(Fleet a) {
		String result = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (a.scanner(i, j)) {
					result = result + "X ";
				} else {
					result = result + "O ";
				}
			}
			result = result + "\n";
		}
		return result;
	}

	public boolean scanner(int i, int j) {

		for (Ship s : ships) {

			for (Coordinate c : s.coordinates) {
				if (c.cellX == i && c.cellY == j) {
					return true;
				}
			}
		}
		return false;
	}

	public Color painter(int i, int j) {
		for (Ship s : ships) {
			for (Coordinate c : s.coordinates) {
				if (c.cellX == i && c.cellY == j) {
					return s.color;
				}
			}
		}
		return null;
	}

	// these two methods mainly served to register the ships on a grid and print
	// them to the console.
	public boolean bomber(int i, int j) {
		for (Ship s : ships) {

			for (Coordinate c : s.coordinates) {
				if (c.cellX == i && c.cellY == j) {
					c.hit = true;
					return true;
				}

			}
		}
		return false;
	}

	public void sinker() {
		for (Ship s : ships) {
			int hit = 0;
			for (Coordinate c : s.coordinates) {
				if (c.hit) {
					hit++;
				}
			}
			if (hit == s.length) {
				s.sunk = true;
			}
		}
	}

	public boolean sunk() {
		int sunk = 0;
		for (Ship s : ships) {
			if (s.sunk) {
				sunk++;
			}

		}
		if (sunk == ships.size())
			return true;
		else {
			return false;
		}
	}

	public boolean fleetSunk() {
		int sunk = 0;
		for (Ship s : ships) {
			if (s.sunk) {
				sunk++;
			}
		}
		if (sunk == ships.size())
			return true;
		else {
			return false;
		}
	}

	// This method checks the entire list of ships for hits, and declares
	// ships as sunk when the amount of hit coordinates matches the length of the
	// ship.
	public void addShip(Ship s) {
		ships.add(s);

	}

	public void spawnFleet(int level, Ship a, Ship b, Ship d, Ship s, Ship p) {
		if (level == 0) {
			a.coordinateAdder(new Coordinate(6, 4), new Coordinate(6, 8), a);
			b.coordinateAdder(new Coordinate(3, 2), new Coordinate(6, 4), b);
			d.coordinateAdder(new Coordinate(2, 4), new Coordinate(4, 4), d);
			s.coordinateAdder(new Coordinate(2, 8), new Coordinate(2, 6), s);
			p.coordinateAdder(new Coordinate(8, 8), new Coordinate(8, 9), p);

		} else if (level == 1) {
			a.coordinateAdder(new Coordinate(0, 0), new Coordinate(4, 9), a);
			b.coordinateAdder(new Coordinate(0, 1), new Coordinate(0, 4), b);
			d.coordinateAdder(new Coordinate(3, 7), new Coordinate(5, 7), d);
			s.coordinateAdder(new Coordinate(8, 2), new Coordinate(8, 4), s);
			p.coordinateAdder(new Coordinate(1, 6), new Coordinate(1, 7), p);

		} else if (level == 2) {
			a.coordinateAdder(new Coordinate(3, 2), new Coordinate(7, 2), a);
			b.coordinateAdder(new Coordinate(8, 4), new Coordinate(8, 7), b);
			d.coordinateAdder(new Coordinate(2, 4), new Coordinate(2, 6), d);
			s.coordinateAdder(new Coordinate(7, 7), new Coordinate(7, 9), s);
			p.coordinateAdder(new Coordinate(1, 0), new Coordinate(1, 1), p);
		}

		else if (level == 3) {
			a.coordinateAdder(new Coordinate(5, 9), new Coordinate(9, 9), a);
			b.coordinateAdder(new Coordinate(5, 2), new Coordinate(8, 2), b);
			d.coordinateAdder(new Coordinate(2, 4), new Coordinate(2, 6), d);
			s.coordinateAdder(new Coordinate(3, 7), new Coordinate(5, 7), s);
			p.coordinateAdder(new Coordinate(5, 5), new Coordinate(6, 5), p);

		} else if (level == 4) {
			a.coordinateAdder(new Coordinate(3, 7), new Coordinate(7, 7), a);
			b.coordinateAdder(new Coordinate(3, 2), new Coordinate(3, 5), b);
			d.coordinateAdder(new Coordinate(9, 1), new Coordinate(9, 3), d);
			s.coordinateAdder(new Coordinate(0, 7), new Coordinate(0, 9), s);
			p.coordinateAdder(new Coordinate(5, 1), new Coordinate(6, 1), p);

		} else if (level == 5) {
			a.coordinateAdder(new Coordinate(1, 2), new Coordinate(1, 6), a);
			b.coordinateAdder(new Coordinate(4, 5), new Coordinate(4, 8), b);
			d.coordinateAdder(new Coordinate(3, 2), new Coordinate(5, 2), d);
			s.coordinateAdder(new Coordinate(8, 3), new Coordinate(8, 5), s);
			p.coordinateAdder(new Coordinate(7, 0), new Coordinate(7, 1), p);

		} else if (level == 6) {
			a.coordinateAdder(new Coordinate(5, 3), new Coordinate(9, 3), a);
			b.coordinateAdder(new Coordinate(6, 6), new Coordinate(6, 9), b);
			d.coordinateAdder(new Coordinate(1, 1), new Coordinate(1, 3), d);
			s.coordinateAdder(new Coordinate(2, 6), new Coordinate(4, 6), s);
			p.coordinateAdder(new Coordinate(8, 8), new Coordinate(9, 8), p);

		} else if (level == 7) {
			a.coordinateAdder(new Coordinate(4, 5), new Coordinate(8, 5), a);
			b.coordinateAdder(new Coordinate(4, 0), new Coordinate(4, 3), b);
			d.coordinateAdder(new Coordinate(1, 4), new Coordinate(3, 4), d);
			s.coordinateAdder(new Coordinate(5, 7), new Coordinate(5, 9), s);
			p.coordinateAdder(new Coordinate(2, 8), new Coordinate(3, 8), p);

		} else if (level == 8) {
			a.coordinateAdder(new Coordinate(2, 2), new Coordinate(2, 6), a);
			b.coordinateAdder(new Coordinate(5, 5), new Coordinate(8, 5), b);
			d.coordinateAdder(new Coordinate(8, 1), new Coordinate(8, 3), d);
			s.coordinateAdder(new Coordinate(0, 0), new Coordinate(2, 0), s);
			p.coordinateAdder(new Coordinate(6, 0), new Coordinate(6, 1), p);

		} else if (level == 9) {
			a.coordinateAdder(new Coordinate(2, 9), new Coordinate(6, 9), a);
			b.coordinateAdder(new Coordinate(8, 5), new Coordinate(8, 8), b);
			d.coordinateAdder(new Coordinate(2, 5), new Coordinate(2, 7), d);
			s.coordinateAdder(new Coordinate(1, 1), new Coordinate(3, 1), s);
			p.coordinateAdder(new Coordinate(4, 4), new Coordinate(4, 5), p);

		}
		ships.add(a);
		ships.add(b);
		ships.add(d);
		ships.add(s);
		ships.add(p);

	}
// The Spawn methods are the randomized counterpart to the Add methods. It
// determines a random starting point and determines whether the ship will be
// placed horizontally or vertically. Then it determines the rest of the ships
// location based on these parameters. Finally it adds these to the correct
// list. The SpawnFleet method allows to generate the entire enemy fleet with
// one method.
}
