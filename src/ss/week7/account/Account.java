package ss.week7.account;

public class Account {
	protected double balance = 0.0;

	public void transaction(double amount) {
		while (balance <= -1000) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		synchronized (this) {
			balance = balance + amount;	
			if (balance < 0) {
				System.out.println(balance);				
			}

		}


	}
	public double getBalance() {
		return balance;

	}
}
