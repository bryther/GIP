package oef;

public class trudat {
	public static void main (String[] args)
	{
		trudat zooi = new trudat();
		System.out.println(zooi.onzin(7, 8));
		
	}
	
	public boolean onzin(double a, double b)
	{
		if(a>b)	{
			return true;

		}	else {
			return false;
		}
	}

}
