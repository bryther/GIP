package oef.scanner;
import java.util.Scanner;

public class OefScanner2 {
	public static void main (String[]args) {
		Scanner alpha = new Scanner(System.in);
		System.out.println("enter calculation");
		String calc = alpha.nextLine();
		calc.indexOf("+");
		
		if (calc.contains("+")) {
			int s = calc.indexOf("+");
			double a = Double.parseDouble(calc.substring(0, s));
			double b = Double.parseDouble(calc.substring(s+1));
			double c = a+b;
			System.out.println(c);
		}
		else if (calc.contains("-")) {
			int s = calc.indexOf("-");
			double a = Double.parseDouble(calc.substring(0, s));
			double b = Double.parseDouble(calc.substring(s+1));
			double c = a-b;
			System.out.println(c);
		}
		else if (calc.contains("*")) {
			int s = calc.indexOf("*");
			double a = Double.parseDouble(calc.substring(0, s));
			double b = Double.parseDouble(calc.substring(s+1));
			double c = a*b;
			System.out.println(c);
		}
		else if (calc.contains("/")) {
			int s = calc.indexOf("/");
			double a = Double.parseDouble(calc.substring(0, s));
			double b = Double.parseDouble(calc.substring(s+1));
			double c = a/b;
			System.out.println(c);
		}
	}
}
