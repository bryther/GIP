package oef;

public class chars {
		static String zin = new String();
	

	
	public static void main (String[]args) {
			
			zin = "Boze bevers bouwen beter.";
			chars tel = new chars();
			System.out.println(tel.scanner("e"));
			System.out.print(zin.charAt(2));
			
	}
	
	public int scanner (String a) {
		int teller = 0;
		for (int i = 0; i < zin.length(); i++) {
			if (zin.charAt(i)== a.charAt(0)) {
				teller++;
			}
		}
		return teller;
	}
}
