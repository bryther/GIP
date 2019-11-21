package oef;

public class array {
	int[] flikker = new int [10];
	public static void main (String[] args)
	{
		array tyfus= new array();
		tyfus.teller();
		tyfus.printer();
	}
	
	public void teller ()
	{
		for (int i = 0; i < 10; i++) 
		{
			flikker[i]=i+1;
		}
	}
	
	public void printer ()
	{
		for (int j = 0; j < flikker.length; j++)
		{
			System.out.println(flikker[j]);
		}
	}
	
}
