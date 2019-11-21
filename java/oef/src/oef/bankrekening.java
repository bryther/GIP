package oef;

public class bankrekening {
	int saldo = 0;

	public void print() {
		System.out.println(saldo);
	}

	public void withdraw(int a) {
		saldo = saldo - a;

	}

	public void deposit(int a) {
		saldo = saldo + a;
	}
}
