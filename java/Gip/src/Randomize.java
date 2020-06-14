

/**
 * this class serves as a personal alternative to the regular random class. it
 * returns an integer in between the given parameters.
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