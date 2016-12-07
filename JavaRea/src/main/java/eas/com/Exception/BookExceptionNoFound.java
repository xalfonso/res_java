package eas.com.Exception;

/**
 * Created by eduardo on 12/7/2016.
 */
public class BookExceptionNoFound extends Exception {

    public BookExceptionNoFound() {
    }

    public BookExceptionNoFound(String message) {
        super(message);
    }
}
