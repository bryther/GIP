package oef;

public class smaller {
	public static void main (String[] args)
	{
		smaller zooi = new smaller();
		System.out.println(zooi.onzin(7, 2));
		
	}
	
	public double onzin(double a, double b)
	{
		if(b<a)	{
			return b;

		}	else	{
			return a;
		}

	}

}
