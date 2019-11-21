package oef;

public class tellmewhile {

	public static void main(String[] args) {
		tellmewhile boi = new tellmewhile();
		boi.four();

	}

	public void one() {
		int i = 0;
		while (i < 11) {
			System.out.println(i);
			i++;
		}
	}

	public void two() {
		int i = 0;
		int j = 10;
		while (i < 11) {
			System.out.println(j);
			i++;
			j--;
		}
	}

	public void three() {
		int i = 0;
		do {
			System.out.print(i + ", ");
			i=i+2;

		} while (i < 102);

	}

	public void four() {
		int i = 0;
		while (i>-1) {
			System.out.println(i);
			i++;
		}
			
	}

	public void five() {

	}
}
