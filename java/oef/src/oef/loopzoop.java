package oef;

public class loopzoop {
	
	public static void main(String[]args) {
		loopzoop zoop = new loopzoop();
		zoop.led();
	}
	
	
	public void led(){
		int i =0;
		do {
			int j=-1;
			while(j<i){
				System.out.print(j+2+ " ");
				j++;
			}
			System.out.println();
			i++;
		}
		while (i<5);	
	}
}
