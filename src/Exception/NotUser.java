package Exception;

public class NotUser extends Exception {
	String message;

	public NotUser(String message) {
		super();
		this.message = message;
		System.out.println(message);
	}
	
	
}
