package practice;

import java.util.Random;
import java.util.Scanner;

public class Linking {
	private Scanner scan = new Scanner(System.in);
	private Random rand = new Random();

	public void main(String[] args) {
		System.out.println("Geef String op");
		String tekst = scan.nextLine();
		Linking main = new Linking();
		main.randomize(tekst);

	}

	public void randomize(String a) {
		String[] nieuw = new String[8];
		for (int i = 0; i < 8; i++) {
			int b = rand.nextInt(10);
			nieuw[i] = Integer.toString(b);
		}
		System.out.print(a);
	}

}
