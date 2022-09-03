package se.skolverket.hibernatevalidationdemo.exception;

public class CustomisedException extends RuntimeException{

    public CustomisedException() {
    }

    public CustomisedException(String message) {
        super(message);
    }

    public CustomisedException(String message, Throwable cause) {
        super(message, cause);
    }
}
