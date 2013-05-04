package net.suaree.meetup.model;

/**
 * Represents the event status values used with the Meetup APIs.
 *
 * @author roger
 */
public enum EventStatus {
    Cancelled("cancelled"),
    Upcoming("upcoming"),
    Past("past"),
    Proposed("proposed"),
    Suggested("suggested");

    private final String value;

    private EventStatus(String value) {
        this.value = value;
    }

    /**
     * Gets the status value as used in the open_events API.
     *
     * @return A String that represents the status value for the open_events API.
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
