package net.suaree.meetup.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Unit Tests for the TimeRange and related classes.
 *
 * @author roger
 */
public class TimeRangeTest {
    @Test
    public void testRelativeRangeDays() {
        TimeRange range = new TimeRange(
                new RelativeTimeRangeComponent(-3, RelativeTimeRangeComponent.TimeUnit.Days),
                new RelativeTimeRangeComponent(2, RelativeTimeRangeComponent.TimeUnit.Days));

        Assert.assertEquals("-3d,2d", range.getTimeSpec());
    }

    @Test
    public void testRelativeRangeWeeks() {
        TimeRange range = new TimeRange(
                new RelativeTimeRangeComponent(-2, RelativeTimeRangeComponent.TimeUnit.Weeks),
                new RelativeTimeRangeComponent(3, RelativeTimeRangeComponent.TimeUnit.Weeks));

        Assert.assertEquals("-2w,3w", range.getTimeSpec());
    }

    @Test
    public void testRelativeRangeMonths() {
        TimeRange range = new TimeRange(
                new RelativeTimeRangeComponent(-1, RelativeTimeRangeComponent.TimeUnit.Months),
                new RelativeTimeRangeComponent(1, RelativeTimeRangeComponent.TimeUnit.Months));

        Assert.assertEquals("-1m,1m", range.getTimeSpec());
    }

    @Test
    public void testRelativeRangeMix() {
        TimeRange range = new TimeRange(
                new RelativeTimeRangeComponent(-1, RelativeTimeRangeComponent.TimeUnit.Days),
                new RelativeTimeRangeComponent(1, RelativeTimeRangeComponent.TimeUnit.Months));

        Assert.assertEquals("-1d,1m", range.getTimeSpec());
    }

    @Test
    public void testSomeNull() {
        TimeRange range = new TimeRange(
                null,
                new RelativeTimeRangeComponent(1, RelativeTimeRangeComponent.TimeUnit.Weeks));

        Assert.assertEquals(",1w", range.getTimeSpec());

        range = new TimeRange(
                new RelativeTimeRangeComponent(1, RelativeTimeRangeComponent.TimeUnit.Weeks),
                null);

        Assert.assertEquals("1w,", range.getTimeSpec());
    }

    @Test
    public void testAbsoluteRange() {
        TimeRange range = new TimeRange(
                new AbsoluteTimeRangeComponent(getCalendarForEpochTime(123456789)),
                new AbsoluteTimeRangeComponent(getCalendarForEpochTime(234567890)));

        Assert.assertEquals("123456789,234567890", range.getTimeSpec());
    }

    @Test
    public void testAbsoluteRelativeMix() {
        TimeRange range = new TimeRange(
                new AbsoluteTimeRangeComponent(getCalendarForEpochTime(234567890)),
                new RelativeTimeRangeComponent(1, RelativeTimeRangeComponent.TimeUnit.Days));

        Assert.assertEquals("234567890,1d", range.getTimeSpec());
    }

    private static Calendar getCalendarForEpochTime(long time) {
        Calendar result = Calendar.getInstance();

        result.setTimeInMillis(time);

        return result;
    }
}
