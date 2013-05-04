package net.suaree.meetup.model;

/**
 * Represents a component (start or end) of a TimeRange for the Meetup APIs.
 *
 * @author roger
 */
public abstract class TimeRangeComponent {
    public abstract String getTimeComponentSpec();

    @Override
    public String toString() {
        return getTimeComponentSpec();
    }
}
