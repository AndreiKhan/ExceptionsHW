package Exceptions;
public class TelephoneException extends Exception {

    public TelephoneException(String message, Exception e) {
        super(message, e);
    }
}
