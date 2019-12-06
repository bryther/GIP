package loops;

public class Drie {
	public static void main(String[] args) {
		Drie printer = new Drie();
		printer.tellmewhile();
	}
	public void printer() {
		for (int i = -20; i >= -50 ; i--) {
			if(i%2==0 && i!=-40) {
				System.out.println(i);
			}
		}
	}
	public void tellmewhile(){
		int i = 0;
		
		while(i<5) {
			int k = 89;
			for (int j = 0; j <= i; j++) {
				System.out.print(k + " ");
				k--;
			}
			System.out.println();
			i++;
						
		}
		
		
		
		
		
	}
}
