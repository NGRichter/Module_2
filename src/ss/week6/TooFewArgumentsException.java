package ss.week6;

public class TooFewArgumentsException extends WrongArgumentException {
	
	public TooFewArgumentsException() {
		super();
	}

	public String getMessage() {
		return "\nMust pass two command line arguments";
	}
}
