package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread {
	
	public static ReentrantLock lock;
	
	public TestSyncConsole(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		sum();
	}
	
	private synchronized void sum() {
		lock.lock();
		try {
			String sum = getName() + ": Sum equals " + 
					(SyncConsole.readInt(getName() + ": First number: ") + 
					SyncConsole.readInt(getName() + ": Second number: "));
			SyncConsole.println(sum);			
		} finally {
			lock.unlock();
		}

	}
	
	public static void main(String[] args) {
		lock = new ReentrantLock();
		Thread test = new TestSyncConsole("Thread A");
		Thread test2 = new TestSyncConsole("Thread B");
		test.start();
		test2.start();
	}
}
//7.11 Even though the values you type in go to the right place B can sometimes go first and sometime A does.
//And the First number goes first and then the second, you can't have the first and second number of A and then that of B.

//7.12 There is no difference, the methods are still being called in a inconsistent manner.

//7.14 1. It has a fairness policy (Threads who are first get the lock sooner). It supports waiting for the lock with a time-out.
// 2. Yes
// 3. The lock can be used in between methods, it can also be given to the next thread that waited the longest.
// 4. The code will look uglier