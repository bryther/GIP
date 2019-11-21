package oef;

public class Loops {
	
	public static void main(String[]args) {
		Loops zoop= new Loops();
		zoop.printer();
	}
	
	
	
	public void printer() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print(j+1+", ");
			}
			System.out.println();
			System.out.println();
		}
	}

}
