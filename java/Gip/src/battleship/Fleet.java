package battleship;

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

	public void printer() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

			}
			System.out.println();
		}

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
	// This method checks the entire list of ships for hits, and declares
	// ships as sunk when the amount of hit coordinates matches the length of the
	// ship.

	public void addPB(Coordinate start, Coordinate end) {
		Ship PB = new Ship();
		PB.color = Color.GRAY;
		PB.name = "Ally Patrol Boat";
		PB.coordinates.add(start);
		PB.coordinates.add(end);
		PB.length = 2;
		ships.add(PB);
	}
	// adds our smallest ship (patrol boat) to the ship list of the fleet and adds
	// the coordinates to the appropriate list

	public void addSM(Coordinate start, Coordinate end) {
		Ship SM = new Ship();
		SM.color = Color.YELLOW;
		Coordinate E1 = new Coordinate(0, 0);
		SM.name = "Ally Submarine";
		if (start.cellX == end.cellX + 2) {
			E1.cellX = start.cellX;
			E1.cellY = start.cellY + 1;

		} else if (start.cellY == end.cellY + 2) {
			E1.cellY = start.cellY;
			E1.cellX = start.cellX + 1;

		} else if (start.cellX == end.cellX - 2) {
			E1.cellX = start.cellX;
			E1.cellY = start.cellY - 1;

		} else if (start.cellY == end.cellY - 2) {
			E1.cellY = start.cellY;
			E1.cellX = start.cellX - 1;
		}
		SM.coordinates.add(start);
		SM.coordinates.add(E1);
		SM.coordinates.add(end);
		ships.add(SM);
		SM.length = 3;
	}
	// adds our first 3-length ship (submarine) to the ship list of the fleet and
	// adds the coordinates to the appropriate list

	public void addDS(Coordinate start, Coordinate end) {
		Ship DS = new Ship();
		DS.color = Color.MAGENTA;
		Coordinate E1 = new Coordinate(0, 0);
		DS.name = "Ally Destroyer";
		if (start.cellX == end.cellX + 2) {
			E1.cellX = start.cellX;
			E1.cellY = start.cellY + 1;

		} else if (start.cellY == end.cellY + 2) {
			E1.cellY = start.cellY;
			E1.cellX = start.cellX + 1;

		} else if (start.cellX == end.cellX - 2) {
			E1.cellX = start.cellX;
			E1.cellY = start.cellY - 1;

		} else if (start.cellY == end.cellY - 2) {
			E1.cellY = start.cellY;
			E1.cellX = start.cellX - 1;

		}
		DS.coordinates.add(start);
		DS.coordinates.add(E1);
		DS.coordinates.add(end);
		DS.length = 3;
		ships.add(DS);
	}
	// adds our second 3-length ship (destroyer) to the ship list of the fleet and
	// adds the coordinates to the appropriate list

	public void addBS(Coordinate start, Coordinate end) {
		Ship BS = new Ship();
		BS.color = Color.CYAN;
		Coordinate E1 = new Coordinate(0, 0);
		Coordinate E2 = new Coordinate(0, 0);
		BS.name = "Ally Battleship";
		if (start.cellX == end.cellX + 2) {
			E1.cellX = start.cellX;
			E2.cellX = start.cellX;
			E1.cellY = start.cellY + 1;
			E2.cellY = start.cellY + 2;

		} else if (start.cellY == end.cellY + 2) {
			E1.cellY = start.cellY;
			E2.cellY = start.cellY;
			E1.cellX = start.cellX + 1;
			E2.cellX = start.cellX + 2;

		} else if (start.cellX == end.cellX - 2) {
			E1.cellX = start.cellX;
			E2.cellX = start.cellX;
			E1.cellY = start.cellY - 1;
			E2.cellY = start.cellY - 2;

		} else if (start.cellY == end.cellY - 2) {
			E1.cellY = start.cellY;
			E2.cellY = start.cellY;
			E1.cellX = start.cellX - 1;
			E2.cellX = start.cellX - 2;
		}
		BS.coordinates.add(start);
		BS.coordinates.add(E1);
		BS.coordinates.add(E2);
		BS.coordinates.add(end);
		BS.length = 4;
		ships.add(BS);

	}
	// adds our 4-length ship (battleship) to the ship list of the fleet and adds
	// the coordinates to the appropriate list

	public void addACC(Coordinate start, Coordinate end) {
		Ship ACC = new Ship();
		ACC.color = Color.GREEN;
		Coordinate E1 = new Coordinate(0, 0);
		Coordinate E2 = new Coordinate(0, 0);
		Coordinate E3 = new Coordinate(0, 0);
		ACC.name = "Ally Aircraft Carrier";
		if (start.cellX == end.cellX + 2) {
			E1.cellX = start.cellX;
			E2.cellX = start.cellX;
			E3.cellX = start.cellX;
			E1.cellY = start.cellY + 1;
			E2.cellY = start.cellY + 2;
			E3.cellY = start.cellY + 3;

		} else if (start.cellY == end.cellY + 2) {
			E1.cellY = start.cellY;
			E2.cellY = start.cellY;
			E3.cellY = start.cellY;
			E1.cellX = start.cellX + 1;
			E2.cellX = start.cellX + 2;
			E3.cellX = start.cellX + 3;

		} else if (start.cellX == end.cellX - 2) {
			E1.cellX = start.cellX;
			E2.cellX = start.cellX;
			E3.cellX = start.cellX;
			E1.cellY = start.cellY - 1;
			E2.cellY = start.cellY - 2;
			E3.cellY = start.cellY - 3;

		} else if (start.cellY == end.cellY - 2) {
			E1.cellY = start.cellY;
			E2.cellY = start.cellY;
			E3.cellY = start.cellY;
			E1.cellX = start.cellX - 1;
			E2.cellX = start.cellX - 2;
			E2.cellX = start.cellX - 3;
		}
		ACC.coordinates.add(start);
		ACC.coordinates.add(E1);
		ACC.coordinates.add(E2);
		ACC.coordinates.add(E3);
		ACC.coordinates.add(end);
		ACC.length = 5;
		ships.add(ACC);
	}
	// adds our largest ship (Aircraft carrier) to the ship list of the fleet and
	// adds the coordinates to the appropriate list

	public void spawnFleet(int level, Fleet a) {
		Ship EACC = new Ship(), EBS = new Ship(), EDS = new Ship(), ESM = new Ship(), EPB = new Ship();
		EACC.name = "Enemy Aircraft Carrier";
		EBS.name = "Enemy Battleship";
		EDS.name = "Enemy Destroyer";
		ESM.name = "Enemy Submarine";
		EPB.name = "Enemy Patrol Boat";
		EACC.length = 5;
		EBS.length = 4;
		EDS.length = 3;
		ESM.length = 3;
		EPB.length = 2;
		if (level == 0) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(6, 4 + i));
			}

			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(3 + i, 2));
			}

			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(2 + i, 4));
			}

			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(2, 8 - i));
			}

			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(8, 8 + i));
			}

		} else if (level == 1) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(0 + i, 0));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(0, 1 + i));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(3 + i, 7));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(8, 2 + i));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(1, 6 + i));
			}

		} else if (level == 2) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(3 + i, 2));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(8, 4 + i));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(2, 4 + i));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(7, 7 + i));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(1, 0 + i));
			}

		} else if (level == 3) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(5 + i, 9));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(5 + i, 2));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(2, 4 + i));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(3 + i, 7));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(5 + i, 5));
			}

		} else if (level == 4) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(3 + i, 7));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(3, 2 + i));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(9, 1 + i));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(0, 7 + i));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(5 + i, 1));
			}

		} else if (level == 5) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(1, 2 + i));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(4, 5 + i));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(3 + i, 2));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(8, 3 + i));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(7, 0 + i));
			}

		} else if (level == 6) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(5 + i, 3));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(6, 6 + i));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(1, 1 + i));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(2 + i, 6));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(8 + i, 8));
			}

		} else if (level == 7) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(4 + i, 5));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(4, 0 + i));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(1 + i, 4));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(5, 7 + i));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(2 + i, 8));
			}

		} else if (level == 8) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(2, 2 + i));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(5 + i, 5));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(8, 1 + i));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(0 + i, 0));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(6, 0 + i));
			}

		} else if (level == 9) {
			for (int i = 0; i < 5; i++) {
				EACC.coordinates.add(new Coordinate(2 + i, 9));
			}
			for (int i = 0; i < 4; i++) {
				EBS.coordinates.add(new Coordinate(8, 5 + i));
			}
			for (int i = 0; i < 3; i++) {
				EDS.coordinates.add(new Coordinate(2, 5 + i));
			}
			for (int i = 0; i < 3; i++) {
				ESM.coordinates.add(new Coordinate(1 + i, 1));
			}
			for (int i = 0; i < 2; i++) {
				EPB.coordinates.add(new Coordinate(4, 4 + i));
			}

		}
		a.ships.add(EACC);
		a.ships.add(EBS);
		a.ships.add(EDS);
		a.ships.add(ESM);
		a.ships.add(EPB);

	}
	// The Spawn methods are the randomized counterpart to the Add methods. It
	// determines a random starting point and determines whether the ship will be
	// placed horizontally or vertically. Then it determines the rest of the ships
	// location based on these parameters. Finally it adds these to the correct
	// list. The SpawnFleet method allows to generate the entire enemy fleet with
	// one method.
}
