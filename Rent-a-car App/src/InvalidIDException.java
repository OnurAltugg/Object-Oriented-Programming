
@SuppressWarnings("serial")
public class InvalidIDException extends Exception{
	
	public InvalidIDException() {
		super("Inappropriate ID!");
	}
	
	public InvalidIDException(String message) {
		super(message);
	}
	
	public InvalidIDException(String message, String customerType) {
		super(message + " is an inappropriate ID for " + customerType + " customer.");
	}

}
