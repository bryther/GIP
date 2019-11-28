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
			String a = calc.substring(0, s);
			String b = calc.substring(s+1);
			double aa = Double.parseDouble(a);
			double bb = Double.parseDouble(b);
			double c = aa+bb;
			System.out.println(c);
		}
		else if (calc.contains("-")) {
			int s = calc.indexOf("-");
			String a = calc.substring(0, s);
			String b = calc.substring(s+1);
			double aa = Double.parseDouble(a);
			double bb = Double.parseDouble(b);
			double c = aa-bb;
			System.out.println(c);
		}
		else if (calc.contains("*")) {
			int s = calc.indexOf("*");
			String a = calc.substring(0, s);
			String b = calc.substring(s+1);
			double aa = Double.parseDouble(a);
			double bb = Double.parseDouble(b);
			double c = aa*bb;
			System.out.println(c);
		}
		else if (calc.contains("/")) {
			int s = calc.indexOf("/");
			String a = calc.substring(0, s);
			String b = calc.substring(s+1);
			double aa = Double.parseDouble(a);
			double bb = Double.parseDouble(b);
			double c = aa/bb;
			System.out.println(c);
		}

	}
}
