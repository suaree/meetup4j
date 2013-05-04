package net.suaree.meetup.model;

/**
 * Represents a relative time range component, e.g. a number of days, weeks or months.
 *
 * @author roger
 */
public class RelativeTimeRangeComponent extends TimeRangeComponent {
    private final int amount;

    private final TimeUnit unit;

    public RelativeTimeRangeComponent(int amount, TimeUnit unit) {
        if (0 == amount) {
            throw new IllegalArgumentException("amount");
        }

        if (null == unit) {
            throw new IllegalArgumentException("unit");
        }

        this.amount = amount;
        this.unit = unit;
    }

    public int getAmount() {
        return amount;
    }

    public TimeUnit getUnit() {
        return unit;
    }

    @Override
    public String getTimeComponentSpec() {
        return String.format("%d%s", amount, unit.getValue());
    }

    /**
     * Represents the unit of time used for a relative TimeRange component.
     */
    public enum TimeUnit {
        Days("d"),
        Weeks("w"),
        Months("m");

        private final String value;

        private TimeUnit(String value) {
            this.value = value;
        }

        /**
         * Gets the time unit spec value as used in the Meetup APIs.
         *
         * @return A String that represents the time unit spec  value for the Meetup APIs.
         */
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
