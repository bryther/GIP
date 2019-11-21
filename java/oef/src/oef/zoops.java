package oef;

public class zoops {
	
	
	
	public static void main (String[]args) {
		zoops loop = new zoops();
		loop.loop();
		
	}
	
	public void loop() {
		for (int i = 0; i < 5; i++) {
			System.out.print("Outer loop iteration " + (i+1));
			System.out.println();
			for (int j = 0; j < 2; j++) {
				System.out.println("i = " + i + "; j = " + j);
			}
		}
	}

}
