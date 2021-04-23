package Exception;

public class NotPermissions extends Exception {
	String message;

	public NotPermissions(String message) {
		super();
		this.message = message;
		System.out.println(message);
	}
	
	
}
