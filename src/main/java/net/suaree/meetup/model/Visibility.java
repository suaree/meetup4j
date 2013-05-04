package net.suaree.meetup.model;

/**
 * Represents the event visibility values used with the Meetup APIs.
 *
 * @author roger
 */
public enum Visibility {
    Public("public"),
    Members("members"),
    PublicLimited("public_limited");

    private final String value;

    private Visibility(String value) {
        this.value = value;
    }

    /**
     * Gets the visibility value as used in the Meetup APIs.
     *
     * @return A String that represents the visibility value for the Meetup APIs.
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
