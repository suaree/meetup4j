package net.suaree.meetup.model;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;

/**
 * Represents an event from/for the Meetup APIs.
 *
 * @author roger
 */
public class Event {
    private String id;

    private EventStatus status;

    private Visibility visibility;

    private String name;

    private String description;

    private String why;

    private Calendar time;

    private Long duration;

    private Venue venue;

    @SerializedName("event_url")
    private String url;

    @SerializedName("maybe_rsvp_count")
    private Long maybeRsvpCount;

    @SerializedName("yes_rsvp_count")
    private Long yesRsvpCount;

    private Long headcount;

    @SerializedName("waitlist_count")
    private Long waitlistCount;

    private Double distance;

    private Calendar created;

    private Calendar updated;

    public String getId() {
        return id;
    }

    public EventStatus getStatus() {
        return status;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Calendar getEndTime() {
        if (null == duration) {
            return null;
        }

        Calendar result = Calendar.getInstance();

        result.setTimeInMillis(time.getTimeInMillis() + duration);

        return result;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getUrl() {
        return url;
    }

    public Long getMaybeRsvpCount() {
        return maybeRsvpCount;
    }

    public Long getYesRsvpCount() {
        return yesRsvpCount;
    }

    public Long getHeadcount() {
        return headcount;
    }

    public Long getWaitlistCount() {
        return waitlistCount;
    }

    public Double getDistance() {
        return distance;
    }

    public Calendar getCreated() {
        return created;
    }

    public Calendar getUpdated() {
        return updated;
    }
}
