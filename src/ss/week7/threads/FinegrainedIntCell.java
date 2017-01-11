package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
	
	final Lock lock = new ReentrantLock();
	final Condition used = lock.newCondition();
	final Condition unused = lock.newCondition();
	
	private int value;
	private boolean notused = false;

	@Override
	public void setValue(int val) {
		lock.lock();
		try {
			while (notused) {
				unused.await();				
			}
			value = val;
			notused = true;
			used.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}

	@Override
	public int getValue() {
		lock.lock();
		try {
			while (!notused) {
				used.await();				
			}
			notused = false;
			unused.signal();
			return value;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return -1;
	}


}
