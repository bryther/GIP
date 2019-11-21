package oef;

public class dafuk 
{	
	public static void main (String[] args)
	{
		dafuk zooi = new dafuk();
		System.out.println(zooi.onzin(-10, 43, 8, "explosive diarhea"));		
	}
	
	public boolean onzin(double a, double b, double c, String d)
	{
		if((a>-100 && a<0 )&& (b > 40 && b < 50) && c > 0 && (d.length()<2 || d.length()>10))
		{
			return true;
		}	
		else
		{
			return false;
		}
	}


}
