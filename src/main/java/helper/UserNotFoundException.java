package helper;

public class UserNotFoundException extends Exception{

	public UserNotFoundException() {
		super("User with this Username not Found in database !!");
		
	}


	public UserNotFoundException(String message) {
		super(message);

	}


	
}
