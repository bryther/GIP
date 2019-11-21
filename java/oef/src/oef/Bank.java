package oef;

public class Bank {
	public static void main (String[]args)
	{
		bankrekening zichtrekening = new bankrekening();
		bankrekening spaarrekening = new bankrekening();
		zichtrekening.deposit(363);
		zichtrekening.print();
		spaarrekening.deposit(768);
		spaarrekening.print();
	}
}
