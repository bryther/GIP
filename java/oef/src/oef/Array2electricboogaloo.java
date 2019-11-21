package oef;

public class Array2electricboogaloo {
	int [] electric = {2,4,8,16,32};
		
	public static void main (String[] args)
	{
		Array2electricboogaloo weird = new Array2electricboogaloo();
		weird.no_u();
		weird.printer();
	}
	public void no_u()
	{
		int [] boogaloo = new int [electric.length];
		
		for (int i = 0; i < boogaloo.length; i++) 
		{
			boogaloo[i] = electric[i];
		}
		
		int reverse = boogaloo.length -1;
		for (int i = 0; i < electric.length; i++) {
			electric[i] = boogaloo [reverse];
			reverse--;
		}
	}
	public void printer()
	{
		for (int i = 0; i < electric.length; i++) {
			System.out.println(electric[i]);
		}
	}
	
}
