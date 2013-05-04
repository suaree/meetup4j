package net.suaree.meetup.exception;

/**
 * Represents an exception that occurred when invoking the Meetup APIs.
 *
 * @author roger
 */
public class RequestException extends Exception {
    public RequestException() {
    }

    public RequestException(Throwable cause) {
        super(cause);
    }

    public RequestException(String message) {
        super(message);
    }

    public RequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
