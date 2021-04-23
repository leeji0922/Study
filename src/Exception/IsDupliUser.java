package Exception;

public class IsDupliUser extends Exception {
	String message;

	public IsDupliUser(String message) {
		super();
		this.message = message;
		System.out.println(message);
	}
	
	
}
