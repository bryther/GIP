package loops;

public class Een {
	int[][] matrix = new int [10][15];
	
	public static void main (String[]args) {
		Een oefening = new Een();
		oefening.schrijver();
		oefening.printen();
	}
	
	public void schrijver() {
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				matrix[i][j] = (i+1)*(j+1);
			}
		}
	
	}

	public void printen() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	

}
