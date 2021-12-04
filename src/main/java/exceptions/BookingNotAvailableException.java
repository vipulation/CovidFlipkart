package exceptions;

public class BookingNotAvailableException extends Exception{
    public BookingNotAvailableException(String message) {
        super(message);
    }
}
