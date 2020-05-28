package battleship;

/**
 * this class serves as a personal alternative to the regular random class. it
 * returns an integer ranging from the given min to the given max.
 * 
 * @author Alec
 *
 */

public class Randomize {
	public static void main(String[] args) {
		System.out.print(randomWithRange(0, 1));
	}

	static int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}
}