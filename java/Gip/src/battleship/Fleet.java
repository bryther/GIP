package battleship;

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
	List<Ship> ships = new ArrayList<Ship>();
	static List<Ship> enemy = new ArrayList<Ship>();

	boolean[][] grid = new boolean[10][10];

	public void printer() {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (scanner(i, j)) {
					System.out.print("X ");
				} else {
					System.out.print("- ");
				}

			}
			System.out.println();
		}

	}

	private boolean scanner(int i, int j) {

		for (Ship s : ships) {

			for (Coordinate c : s.coordinates) {
				if (c.cellX == i && c.cellY == j) {
					return true;
				}
			}
		}
		return false;
	}

	// these two methods mainly served to register the ships on a grid and print
	// them to the console.
	public void Bomber(int i, int j, List<Ship> S) {
		for (Ship s : S) {

			for (Coordinate c : s.coordinates) {
				if (c.cellX == i && c.cellY == j) {
					c.hit = true;
				} else {
					c.vacant = true;
				}
			}
		}

	}

	public void sunk(List<Ship> S) {
		for (Ship s : S) {
			int count = 0;
			for (Coordinate c : s.coordinates) {
				if (c.hit == true) {
					count++;
				}
			}
			if (count == s.length) {
				s.sunk = true;
			}
		}
	}
	// This method checks the entire list of ships for hits, and declares
	// ships as sunk when the amount of hit coordinates matches the length of the
	// ship.

	public void addPB(Coordinate start, Coordinate end) {
		Ship PB = new Ship();
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
		Coordinate E1 = null;
		SM.name = "Ally Submarine";

		if (start.cellX == end.cellX) {
			E1.cellX = start.cellX;
			E1.cellY = start.cellY + 1;

		} else if (start.cellY == end.cellY) {
			E1.cellY = start.cellY;
			E1.cellX = start.cellX + 1;

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
		Coordinate E1 = null;
		DS.name = "Ally Destroyer";
		if (start.cellX == end.cellX) {
			E1.cellX = start.cellX;
			E1.cellY = start.cellY + 1;

		} else if (start.cellY == end.cellY) {
			E1.cellY = start.cellY;
			E1.cellX = start.cellX + 1;

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
		Coordinate E1 = null;
		Coordinate E2 = null;
		BS.name = "Ally Battleship";
		if (start.cellX == end.cellX) {
			E1.cellX = start.cellX;
			E1.cellY = start.cellY + 1;
			E2.cellX = start.cellX;
			E2.cellY = start.cellY + 2;

		} else if (start.cellY == end.cellY) {
			E1.cellY = start.cellY;
			E1.cellX = start.cellX + 1;
			E2.cellY = start.cellY;
			E2.cellX = start.cellX + 2;

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
		Coordinate E1 = null;
		Coordinate E2 = null;
		Coordinate E3 = null;
		ACC.name = "Ally Aircraft Carrier";
		if (start.cellX == end.cellX) {
			E1.cellX = start.cellX;
			E1.cellY = start.cellY + 1;
			E2.cellX = start.cellX;
			E2.cellY = start.cellY + 2;

		} else if (start.cellY == end.cellY) {
			E1.cellY = start.cellY;
			E1.cellX = start.cellX + 1;
			E2.cellY = start.cellY;
			E2.cellX = start.cellX + 2;

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

	private static void SpawnPB() {
		Coordinate start = new Coordinate(Randomize.randomWithRange(0, 9), Randomize.randomWithRange(0, 9));
		Coordinate E1 = start;

		int hr = Randomize.randomWithRange(0, 1);
		if (hr == 0 && start.cellX <= 5) {
			E1.cellX++;
		} else if (hr == 1 && start.cellY <= 5) {
			E1.cellY++;
		} else if (hr == 0 && start.cellX > 5) {
			E1.cellX--;
		} else if (hr == 1 && start.cellY > 5) {
			E1.cellY--;
		}
		Ship EPB = new Ship();
		EPB.name = "Enemy Patrol boat";
		EPB.coordinates.add(start);
		EPB.coordinates.add(E1);
		enemy.add(EPB);

	}

	private static void SpawnSM() {
		Coordinate start = new Coordinate(Randomize.randomWithRange(0, 9), Randomize.randomWithRange(0, 9));
		Coordinate E1 = start;
		Coordinate E2 = start;

		int hr = Randomize.randomWithRange(0, 1);
		if (hr == 0 && start.cellX <= 5) {
			E1.cellX = start.cellX + 1;
			E2.cellX = start.cellX + 2;
		} else if (hr == 1 && start.cellY <= 5) {
			E1.cellY = start.cellY + 1;
			E2.cellY = start.cellY + 2;
		} else if (hr == 0 && start.cellX > 5) {
			E1.cellX = start.cellX - 1;
			E2.cellX = start.cellX - 2;
		} else if (hr == 1 && start.cellY > 5) {
			E1.cellY = start.cellY - 1;
			E2.cellY = start.cellY - 2;
		}
		Ship ESM = new Ship();
		ESM.name = "Enemy Submarine";
		ESM.coordinates.add(start);
		ESM.coordinates.add(E1);
		ESM.coordinates.add(E2);
		enemy.add(ESM);

	}

	private static void SpawnDS() {
		Coordinate start = new Coordinate(Randomize.randomWithRange(0, 9), Randomize.randomWithRange(0, 9));
		Coordinate E1 = start;
		Coordinate E2 = start;

		int hr = Randomize.randomWithRange(0, 1);
		if (hr == 0 && start.cellX <= 5) {
			E1.cellX = start.cellX + 1;
			E2.cellX = start.cellX + 2;
		} else if (hr == 1 && start.cellY <= 5) {
			E1.cellY = start.cellY + 1;
			E2.cellY = start.cellY + 2;
		} else if (hr == 0 && start.cellX > 5) {
			E1.cellX = start.cellX - 1;
			E2.cellX = start.cellX - 2;
		} else if (hr == 1 && start.cellY > 5) {
			E1.cellY = start.cellY - 1;
			E2.cellY = start.cellY - 2;
		}
		Ship EDS = new Ship();
		EDS.name = "Enemy Destroyer";
		EDS.coordinates.add(start);
		EDS.coordinates.add(E1);
		EDS.coordinates.add(E2);
		enemy.add(EDS);
	}

	private static void SpawnBS() {
		Coordinate start = new Coordinate(Randomize.randomWithRange(0, 9), Randomize.randomWithRange(0, 9));
		Coordinate E1 = start;
		Coordinate E2 = start;
		Coordinate E3 = start;

		int hr = Randomize.randomWithRange(0, 1);
		if (hr == 0 && start.cellX <= 5) {
			E1.cellX = start.cellX + 1;
			E2.cellX = start.cellX + 2;
			E3.cellX = start.cellX + 3;
		} else if (hr == 1 && start.cellY <= 5) {
			E1.cellY = start.cellY + 1;
			E2.cellY = start.cellY + 2;
			E3.cellY = start.cellY + 3;
		} else if (hr == 0 && start.cellX > 5) {
			E1.cellX = start.cellX - 1;
			E2.cellX = start.cellX - 2;
			E3.cellX = start.cellX - 3;
		} else if (hr == 1 && start.cellY > 5) {
			E1.cellY = start.cellY - 1;
			E2.cellY = start.cellY - 2;
			E3.cellY = start.cellY - 3;
		}
		Ship EBS = new Ship();
		EBS.name = "Enemy Battleship";
		EBS.coordinates.add(start);
		EBS.coordinates.add(E1);
		EBS.coordinates.add(E2);
		EBS.coordinates.add(E3);
		enemy.add(EBS);

	}

	private static void SpawnACC() {

		Coordinate start = new Coordinate(Randomize.randomWithRange(0, 9), Randomize.randomWithRange(0, 9));
		Coordinate E1 = start;
		Coordinate E2 = start;
		Coordinate E3 = start;
		Coordinate E4 = start;

		int hr = Randomize.randomWithRange(0, 1);
		if (hr == 0 && start.cellX <= 5) {
			E1.cellX = start.cellX + 1;
			E2.cellX = start.cellX + 2;
			E3.cellX = start.cellX + 3;
			E4.cellX = start.cellX + 4;
		} else if (hr == 1 && start.cellY <= 5) {
			E1.cellY = start.cellY + 1;
			E2.cellY = start.cellY + 2;
			E3.cellY = start.cellY + 3;
			E4.cellY = start.cellY + 4;
		} else if (hr == 0 && start.cellX > 5) {
			E1.cellX = start.cellX - 1;
			E2.cellX = start.cellX - 2;
			E3.cellX = start.cellX - 3;
			E4.cellX = start.cellX - 4;
		} else if (hr == 1 && start.cellY > 5) {
			E1.cellY = start.cellY - 1;
			E2.cellY = start.cellY - 2;
			E3.cellY = start.cellY - 3;
			E4.cellY = start.cellY - 4;
		}
		Ship EACC = new Ship();
		EACC.name = "Enemy Aircraft Carrier";
		EACC.coordinates.add(start);
		EACC.coordinates.add(E1);
		EACC.coordinates.add(E2);
		EACC.coordinates.add(E3);
		EACC.coordinates.add(E4);
		enemy.add(EACC);

	}

	public static void SpawnFleet() {
		SpawnACC();
		SpawnBS();
		SpawnDS();
		SpawnSM();
		SpawnPB();

	}
	// The Spawn methods are the randomized counterpart to the Add methods. It
	// determines a random starting point and determines whether the ship will be
	// placed horizontally or vertically. Then it determines the rest of the ships
	// location based on these parameters. Finally it adds these to the correct
	// list. The SpawnFleet method allows to generate the entire enemy fleet with
	// one method.
}
