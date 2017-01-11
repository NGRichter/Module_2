package ss.week7.account;

public class AccountSync {
	
	public static void main(String[] args) {
		Account account = new Account();

		for (int i = 0; i < 10; i++) {
			Thread t1 = new MyThread(10, 200000, account);
			Thread t2 = new MyThread(-10, 200000, account);	
			t1.start();
			t2.start();
			while (t1.isAlive() || t2.isAlive()) {
				
			}
		}

		System.out.println(account.getBalance());
	}
	
	//7.19 1. 204260
	// 2. 88390
	// 3. 300230
	
	//7.20 MyThread won't have to change. AccountSync does have to change.
	// Making of the thread would be: 
	//Runnable mythread = new MyThread(10,2000,account);
	//Thread t1 = new Thread(mythread);
	//t1.start();

}
