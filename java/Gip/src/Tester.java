

public class Tester {
	/*
	 * public static void main(String[] args) { Fleet enemy = new Fleet();
	 * enemy.spawnFleet(0); enemy.printer(); }
	 */
	public static void main(String[] args) {
		Fleet mine = new Fleet();
		Coordinate b = new Coordinate(0, 5);
		Coordinate e = new Coordinate(0, 9);
		mine.addACC(b, e);
		b.cellX = 1;
		b.cellY = 6;
		e.cellX = 1;
		mine.addBS(b, e);
		b.cellX = 2;
		b.cellY = 7;
		e.cellX = 2;
		mine.addDS(b, b);
		b.cellX = 3;
		e.cellX = 3;
		mine.addSM(b, e);
		b.cellX = 4;
		b.cellY = 8;
		e.cellX = 4;
		mine.addPB(b, e);

		mine.printer(mine);
	}
}
