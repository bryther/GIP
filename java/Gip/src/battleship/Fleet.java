package battleship;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
	List<Ship> ships = new ArrayList<Ship>();
	List<Ship> enemy = new ArrayList<Ship>();

	boolean[][] grid = new boolean[10][10];

	public void addShip(Ship a) {
		ships.add(a);
	}

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

	public void addPB(Coordinate start, Coordinate E1) {
		Ship PB = new Ship();
		PB.coordinates.add(start);
		PB.coordinates.add(E1);
		ships.add(PB);
	}
	// adds our smallest ship (patrol boat) to the ship list of the fleet and adds
	// the coordinates to the appropriate list

	public void addSM(Coordinate start, Coordinate E1, Coordinate E2) {
		Ship SM = new Ship();
		SM.coordinates.add(start);
		SM.coordinates.add(E1);
		SM.coordinates.add(E2);
		ships.add(SM);
	}

	public void addDS(Coordinate start, Coordinate E1, Coordinate E2) {
		Ship DS = new Ship();
		DS.coordinates.add(start);
		DS.coordinates.add(E1);
		DS.coordinates.add(E2);
		ships.add(DS);
	}

	public void addBS(Coordinate start, Coordinate E1, Coordinate E2, Coordinate E3) {
		Ship BS = new Ship();
		BS.coordinates.add(start);
		BS.coordinates.add(E1);
		BS.coordinates.add(E2);
		BS.coordinates.add(E3);
		ships.add(BS);
	}

	public void addACC(Coordinate start, Coordinate E1, Coordinate E2, Coordinate E3, Coordinate E4) {
		Ship ACC = new Ship();
		ACC.coordinates.add(start);
		ACC.coordinates.add(E1);
		ACC.coordinates.add(E2);
		ACC.coordinates.add(E3);
		ACC.coordinates.add(E4);
		ships.add(ACC);
	}

	public void SpawnPB() {
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
		EPB.coordinates.add(start);
		EPB.coordinates.add(E1);
		enemy.add(EPB);

	}

	public void SpawnSM() {
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
		ESM.coordinates.add(start);
		ESM.coordinates.add(E1);
		ESM.coordinates.add(E2);
		enemy.add(ESM);

	}

	public void SpawnDS() {
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
		EDS.coordinates.add(start);
		EDS.coordinates.add(E1);
		EDS.coordinates.add(E2);
		enemy.add(EDS);
	}

	public void SpawnBS() {
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
		EBS.coordinates.add(start);
		EBS.coordinates.add(E1);
		EBS.coordinates.add(E2);
		EBS.coordinates.add(E3);
		enemy.add(EBS);

	}

	public void SpawnACC() {

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
		EACC.coordinates.add(start);
		EACC.coordinates.add(E1);
		EACC.coordinates.add(E2);
		EACC.coordinates.add(E3);
		EACC.coordinates.add(E4);
		enemy.add(EACC);

	}

	public void SpawnFleet() {

	}

}
