package oef;

public class bigger {
	public static void main (String[] args)
	{
		bigger zooi = new bigger();
		System.out.println(zooi.onzin(7, 2));
		
	}
	
	public double onzin(double a, double b)
	{
		if(a<b){
			return b;

		} else {
			return a;
		}

	}
}
