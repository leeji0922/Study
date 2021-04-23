package Exception;

public class NotAdmin extends Exception {
	String message;

	public NotAdmin(String message) {
		super();
		this.message = message;
		System.out.println(message);
	}
	
	
}
