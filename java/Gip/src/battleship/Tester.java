package battleship;

public class Tester {
	public static void main(String[] args) {
		Fleet test = new Fleet();
		/*
		 * test.addPB(new Coordinate(6, 6), new Coordinate(6, 7)); test.addSM(new
		 * Coordinate(1, 3), new Coordinate(2, 3), new Coordinate(3, 3)); test.addDS(new
		 * Coordinate(8, 3), new Coordinate(8, 4), new Coordinate(8, 5)); test.addBS(new
		 * Coordinate(3, 5), new Coordinate(3, 6), new Coordinate(3, 7), new
		 * Coordinate(3, 8)); test.addACC(new Coordinate(3, 1), new Coordinate(4, 1),
		 * new Coordinate(5, 1), new Coordinate(6, 1), new Coordinate(7, 1));
		 * test.printer();
		 */
		Fleet enemy = new Fleet();
		enemy.SpawnFleet();
		enemy.printer();

		// System.out.println(coordinantesCOM);

		/*
		 * for (int i = 0; i < Ship.coordinatesCOM.size(); i++) {
		 * System.out.print(Ship.coordinatesCOM.get(i).cellX); System.out.println(); }
		 */

	}
}
