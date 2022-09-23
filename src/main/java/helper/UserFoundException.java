package helper;

public class UserFoundException extends Exception {

	public UserFoundException() {
		super("User with this Username is already in DB !!  try With another one");

	}

	public UserFoundException(String message) {
		super(message);

	}
}
