package net.suaree.meetup.model;

/**
 * Represents a time range e.g. for the time parameter of the open_events API.
 *
 * @author roger
 */
public class TimeRange {
    private TimeRangeComponent start;
    private TimeRangeComponent end;

    public TimeRange() {
        this(null, null);
    }

    public TimeRange(TimeRangeComponent start, TimeRangeComponent end) {
        this.start = start;
        this.end = end;
    }

    public TimeRangeComponent getStart() {
        return start;
    }

    public void setStart(TimeRangeComponent start) {
        this.start = start;
    }

    public TimeRangeComponent getEnd() {
        return end;
    }

    public void setEnd(TimeRangeComponent end) {
        this.end = end;
    }

    public String getTimeSpec() {
        String specStart = null;
        String specEnd = null;

        if (null != start) {
            specStart = start.getTimeComponentSpec();
        }

        if (null != end) {
            specEnd = end.getTimeComponentSpec();
        }

        return String.format("%s,%s",
                null != specStart ? specStart : "",
                null != specEnd ? specEnd : "");
    }

    @Override
    public String toString() {
        return getTimeSpec();
    }
}
