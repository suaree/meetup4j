package net.suaree.meetup.exception;

import net.suaree.meetup.operations.ErrorResult;

/**
 * Represents an exception that wraps an error from the Meetup APIs.
 *
 * @author roger
 */
public class RequestErrorException extends RequestException {
    private final ErrorResult error;

    /**
     * Initializes a new instance of RequestErrorException, using the specified Error object.
     *
     * @param error The Error object describing the Meetup API request error.
     */
    public RequestErrorException(ErrorResult error) {
        if (null == error) {
            throw new IllegalArgumentException("error");
        }

        this.error = error;
    }

    /**
     * Initializes a new instance of RequestErrorException, using the specified cause and error objects.
     *
     * @param cause The cause of the exception
     * @param error The Error object describing the Meetup API request error.
     */
    public RequestErrorException(Throwable cause, ErrorResult error) {
        super(cause);

        if (null == error) {
            throw new IllegalArgumentException("error");
        }

        this.error = error;
    }

    /**
     * Gets the Error object that describes the Meetup API request error.
     *
     * @return An Error object describing the Meetup API request error.
     */
    public ErrorResult getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return String.format("%s - %s (%s)", error.getCode(), error.getProblem(), error.getDetails());
    }
}
