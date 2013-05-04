package net.suaree.meetup.operations;

import net.suaree.meetup.model.Category;
import net.suaree.meetup.model.SearchEventStatus;
import net.suaree.meetup.model.TextFormat;
import net.suaree.meetup.serialization.ConversionHelper;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a request to the open_events (v2) API.
 *
 * @author roger
 */
public class OpenEventsRequest extends RequestBase {
    private boolean andText;

    private boolean limitedEvents;

    private Category[] categories;

    private String text;

    private String zip;

    private String city;

    private String state;

    private String country;

    private Double lat;

    private Double lng;

    private Integer radiusInMiles;

    private SearchEventStatus status;

    private TextFormat textFormat;

    private Integer pageSize;

    private Integer page;

    public boolean isAndText() {
        return andText;
    }

    public void setAndText(boolean andText) {
        this.andText = andText;
    }

    public boolean isLimitedEvents() {
        return limitedEvents;
    }

    public void setLimitedEvents(boolean limitedEvents) {
        this.limitedEvents = limitedEvents;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category... categories) {
        this.categories = categories;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Integer getRadiusInMiles() {
        return radiusInMiles;
    }

    public void setRadiusInMiles(Integer radiusInMiles) {
        this.radiusInMiles = radiusInMiles;
    }

    public SearchEventStatus getStatus() {
        return status;
    }

    public void setStatus(SearchEventStatus status) {
        this.status = status;
    }

    public TextFormat getTextFormat() {
        return textFormat;
    }

    public void setTextFormat(TextFormat textFormat) {
        this.textFormat = textFormat;
    }

    /**
     * Gets the size of the pages to retrieve.
     *
     * @return An Integer that defines the size of the pages to retrieve.
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets the size of the pages to retrieve.
     *
     * @param pageSize An Integer that defines the size of the pages to retrieve.
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets the page (the offset parameter).
     *
     * @return An Integer that defines the zero-based index of the page to retrieve.
     */
    public Integer getPage() {
        return page;
    }

    /**
     * Sets the page (the offset parameter).
     *
     * @param page The zero-based index of the page to retrieve.
     */
    public void setPage(Integer page) {
        this.page = page;
    }

    /**
     * Gets the name of the Meetup API this request is for.
     *
     * @return A string that represents the Meetup API name.
     */
    @Override
    protected String getApiName() {
        return "2/open_events";
    }

    /**
     * Gets the query parameters for this Meetup API request.
     *
     * @return A List of NameValuePair instances that define the request parameters.
     */
    @Override
    protected List<NameValuePair> getQueryParameters() {
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>(32);

        if (null != categories && 0 < categories.length) {
            params.add(new BasicNameValuePair("category", ConversionHelper.convertValuesToCommaSeparatedList(categories)));
        }

        if (andText) {
            addParameter("and_text", "true", params);
        }

        addParameter("text", text, params);

        addParameter("limited_events", limitedEvents, params);

        addParameter("city", city, params);
        addParameter("state", state, params);
        addParameter("zip", zip, params);
        addParameter("country", country, params);

        addParameter("lat", lat, params);
        addParameter("lon", lng, params);

        addParameter("radius", radiusInMiles, params);

        addParameter("status", status, params);

        addParameter("text_format", textFormat, params);

        addParameter("page", pageSize, params);
        addParameter("offset", page, params);

        return params;
    }
}
