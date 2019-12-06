package toetsinput;
import java.util.Scanner;


public class Toets1 
{
	Scanner scanner = new Scanner(System.in);
	public static void main (String[]args){
		Toets1 execute = new Toets1();
		execute.redact();
	}

	
	public void redact(){	
		
		System.out.println("Enter sentence");
		String text = scanner.nextLine();
		System.out.println("Enter scrapped word");
		String word = scanner.nextLine();
		String redacted = "*";
		text = text.replace(word, redacted.repeat(word.length()));
		System.out.println(text);
		
	}
	public void censor(){	
		
		System.out.println("Enter sentence");
		String text = scanner.nextLine();
		System.out.println("Enter scrapped word");
		String word = scanner.nextLine();
		String redacted = "[REDACTED]";
		text = text.replace(word, redacted);
		System.out.println(text);
		
	}
	public void redacted() {
		System.out.println("Enter sentence");
		String text = scanner.nextLine();
		System.out.println("Enter scrapped word");
		String word = scanner.nextLine();
		Integer split = text.indexOf(word);
		String textA = text.substring(0, split);
		String textB = text.substring(split + word.length());
		String redacted = "";
		for (int i = 0; i < word.length(); i++) {
			redacted = redacted + "*";
		}
		System.out.println(textA+redacted+textB);
	}
	public void exponentiate() {
		System.out.println("Enter calculation");
		String calc = scanner.nextLine();
		int sign = calc.indexOf("^");
		double base = Double.parseDouble(calc.substring(0, sign));
		double exponent = Double.parseDouble(calc.substring(sign+1));
		double sol = base;
		sol = Math.pow(base, exponent);
		System.out.println(sol);
		}
	
}


