package ss.week2.hotel;

public class Safe {
	
	public boolean active;
	public boolean open;
	private Password password;
	//@public invariant open == true ==> active == true;
	//@public invariant active == false ==> open == false;
	/**Creates a safe.
	 * 
	 */
	
	public static void main(String[] arg) {
		Safe safe = new Safe();
		safe.open(Password.INITIAL);
		System.out.println("Is the safe open: " + safe.isOpen());
	}
	
	public Safe() {
		active = false;
		open = false;
		password = new Password();
	}
	/**Activate the safe.
	 * 
	 * @param password
	 * @return true if activated
	 * @return false if not activated
	 */
	public boolean activate(String pw) {
		if (password.testWord(pw)) {
			active = true;
			assert active == true;
			return true;
		} else {
			return false;
		}

	}
	/**Deactivates the safe.
	 * 
	 */
	//@ensures active == false;
	public void deactivate() {
		open = false;
		active = false;
		assert open == false;
		assert active == false;
	}
	/**Opens the safe.
	 * 
	 * @param password
	 * @return true is opened
	 * @return false is not opened
	 */
	//@requires active == true;
	public boolean open(String pw) {
		assert active == true;
		if (password.testWord(pw) && active) {
			open = true;
			assert open == true;
			return true;
			
		} else {
			return false;
		}
	}
	/**Closes the safe.
	 * 
	 */
	//@ensures open == false;
	public void close() {
		open = false;
		assert open == false;
	}
	/**Returns is safe is active.
	 * 
	 * @return true if active
	 * @return false if not active
	 */
	public boolean isActive() {
		return active;
	}
	/**Returns if safe is opened.
	 * 
	 * @return true if open
	 * @return false if closed
	 */
	public boolean isOpen() {
		return open;
	}

}
