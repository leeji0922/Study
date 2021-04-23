package Exception;

public class NotParameter extends Exception {
	String message;

	public NotParameter(String message) {
		super();
		this.message = message;
		System.out.println(message);
	}
	
}
