package eas.com.Exception;

/**
 * Created by eduardo on 11/30/2016.
 */
public class AuthorExceptionNoFound extends RuntimeException {

    public AuthorExceptionNoFound() {
    }

    public AuthorExceptionNoFound(String message) {
        super(message);
    }
}
