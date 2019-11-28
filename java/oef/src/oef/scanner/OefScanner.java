package oef.scanner;
import java.util.Scanner;

public class OefScanner {

	private Scanner  splode = new Scanner(System.in);
	public static void main (String[]args) {
		OefScanner os = new OefScanner();
		os.divide();
		
	
	}
	private void hello(){
		System.out.println("Enter name");
		
		String username = splode.nextLine();
		System.out.println("Hello " + username);	
	}
	private void adding() {
		System.out.println("Enter value A");
		double a = splode.nextDouble();
		System.out.println("Enter value B");
		double b = splode.nextDouble();
		double c = a+b;
		String result = ""+c;
		System.out.println(result);
	}
	private void divide() {
		System.out.println("Enter value A");
		double a = splode.nextDouble();
		System.out.println("Enter value B");
		double b = splode.nextDouble();
		double c = a/b;
		String result = ""+c;
		System.out.println(result);
	}
}
