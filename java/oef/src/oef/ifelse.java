package oef;

public class ifelse {
	
	public static void main (String[] args)
	{
		ifelse zooi = new ifelse();
		System.out.println(zooi.onzin(7));
		
	}
	
	public boolean onzin(double a)
	{
		if(a<1 && 0<a){
				return true;

		} else {
			return false;
		}
	}

}
