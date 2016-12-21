package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {
	
	private int first;
	private int second;
	
	public ArgumentLengthsDifferException(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}

	public String getMessage() {
		return "\nLength of first string: " + first + "\nLength of second string: " + second;
	}

}
