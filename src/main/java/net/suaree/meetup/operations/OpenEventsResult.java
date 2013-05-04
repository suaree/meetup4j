package net.suaree.meetup.operations;

import com.google.gson.annotations.SerializedName;
import net.suaree.meetup.model.Event;
import net.suaree.meetup.model.ResultMetadata;

import java.util.List;

/**
 * Represents the result from a call to the open_events (v2) API.
 *
 * @author roger
 */
public class OpenEventsResult extends ResultBase {
    @SerializedName("results")
    private List<Event> events;

    private ResultMetadata meta;

    public List<Event> getEvents() {
        return events;
    }

    public ResultMetadata getMeta() {
        return meta;
    }
}
