package net.suaree.meetup.model;

import java.util.Calendar;

/**
 * Represents an absolute time range component, i.e. an actual date.
 *
 * @author roger
 */
public class AbsoluteTimeRangeComponent extends TimeRangeComponent {
    private final Calendar time;

    public AbsoluteTimeRangeComponent(Calendar time) {
        this.time = time;
    }

    @Override
    public String getTimeComponentSpec() {
        return Long.toString(time.getTimeInMillis());
    }
}
