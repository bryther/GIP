package oef;
import java.util.Scanner;

public class Switch {
	Scanner scanner = new Scanner(System.in);
	public static void main (String[]args) {
		Switch dewit = new Switch();
		dewit.ifelse();
	}
	
	public void ifelse() {
		System.out.println("geef leeftijd in");
		String age = scanner.nextLine();
		int intage = Integer.parseInt(age);
		
		if (intage<16) {
			System.out.println("geen");
		}
		else if (intage >=16 && intage <= 18) {
			System.out.println("AM");
		}
		else if (intage >=18 && intage <= 20) {
			System.out.println("A1");
		}
		else if (intage >=20 && intage <= 22) {
			System.out.println("A2");
		}
		else {
			System.out.println("A");
		}
		
		
	}

}
