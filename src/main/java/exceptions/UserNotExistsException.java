package exceptions;

public class UserNotExistsException extends Exception{
    public UserNotExistsException(String message) {
        super(message);
    }
}
