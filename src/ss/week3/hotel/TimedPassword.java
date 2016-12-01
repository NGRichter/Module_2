package ss.week3.hotel;

public class TimedPassword extends Password {
	
	private int validTime;
	private long beginTime;
	
	public TimedPassword(int time) {
		super();
		validTime = time;
		beginTime = System.currentTimeMillis();
		
	}
	
	public TimedPassword() {
		this(1);
	}
	
	public void reset() {
		beginTime = System.currentTimeMillis();
	}
	
	public boolean isExpired() {
		long endTime = System.currentTimeMillis();
		return (validTime * 1000) < (endTime - beginTime);
	}
	@Override
	public boolean setWord(String oldpass, String newpass) {
		if (oldpass.equals(factoryPassword)) {
			if (acceptable(newpass)) {
				factoryPassword = newpass;			
				reset();
				return true;
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

}
