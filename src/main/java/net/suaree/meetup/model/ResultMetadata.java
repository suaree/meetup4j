package net.suaree.meetup.model;

import com.google.gson.annotations.SerializedName;

import java.util.Calendar;

/**
 * Represents the metadata of the result of a call to the Meetup APIs.
 *
 * @author roger
 */
public class ResultMetadata {
    @SerializedName("lat")
    private String latRaw;

    @SerializedName("lon")
    private String lngRaw;

    private String id;

    private String title;

    private String description;

    private String method;

    private Integer count;

    @SerializedName("total_count")
    private Integer totalCount;

    private String link;

    private String url;

    private String next;

    private Calendar updated;

    public Double getLat() {
        if (null == latRaw || latRaw.isEmpty()) {
            return null;
        }

        return Double.parseDouble(latRaw);
    }

    public Double getLng() {
        if (null == lngRaw || lngRaw.isEmpty()) {
            return null;
        }

        return Double.parseDouble(lngRaw);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMethod() {
        return method;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public String getLink() {
        return link;
    }

    public String getUrl() {
        return url;
    }

    public String getNext() {
        return next;
    }

    public Calendar getUpdated() {
        return updated;
    }
}
