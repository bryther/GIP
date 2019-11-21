package oef;

public class Array3tokyodrift {
		int[][] matrix = new int [10][15];
		
		public static void main (String[]args) {
			Array3tokyodrift speed = new Array3tokyodrift(); 
			speed.schrijver();
			speed.printen();
		}
		
		public void schrijver() {
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					
					matrix[i][j] = i*j;
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
