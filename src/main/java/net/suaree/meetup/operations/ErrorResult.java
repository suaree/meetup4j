package net.suaree.meetup.operations;

/**
 * Represents an error result as retrieved from the Meetup APIs.
 *
 * @author roger
 */
public class ErrorResult extends ResultBase {
    private String code;

    private String problem;

    private String details;

    public String getCode() {
        return code;
    }

    public String getProblem() {
        return problem;
    }

    public String getDetails() {
        return details;
    }
}
