package net.suaree.meetup.operations;

import net.suaree.meetup.Credentials;
import net.suaree.meetup.exception.RequestException;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Represents the base class for Meetup API requests.
 *
 * @author roger
 */
public abstract class RequestBase {
    /**
     * Gets the URI to use to invoke this API.
     *
     * @param credentials The Credentials to use when invoking the Meetup API.
     * @return An instance of URI that represents the URI of this request.
     * @throws java.net.URISyntaxException
     * @throws RequestException
     */
    public URI getUri(Credentials credentials) throws URISyntaxException, RequestException {
        URIBuilder builder = new URIBuilder(String.format("https://api.meetup.com/%s.json", getApiName()));

        builder.addParameter("key", credentials.getApiKey());

        for (NameValuePair param : getQueryParameters()) {
            builder.addParameter(param.getName(), param.getValue());
        }

        return builder.build();
    }

    /**
     * Gets the name of the Meetup API this request is for.
     *
     * @return A string that represents the Meetup API name.
     */
    protected abstract String getApiName();

    /**
     * Gets the query parameters for this Meetup API request.
     *
     * @return A List of NameValuePair instances that define the request parameters.
     */
    protected abstract List<NameValuePair> getQueryParameters();

    /**
     * Adds the given parameter to the list of parameters, iff the value is not null.
     *
     * @param name   The name of the parameter to add.
     * @param value  The value of the parameter to add.
     * @param params The list of parameters to add the parameter to.
     * @param <T>    The type of the parameter's value.
     */
    protected <T> void addParameter(String name, T value, List<NameValuePair> params) {
        if (null == name) {
            throw new IllegalArgumentException("name must not be null.");
        }
        if (null == params) {
            throw new IllegalArgumentException("params must not be null.");
        }

        if (null != value) {
            params.add(new BasicNameValuePair(name, value.toString()));
        }
    }

    /**
     * Adds the given parameter to the list of parameters, iff the value is not null or empty.
     *
     * @param name   The name of the parameter to add.
     * @param value  The value of the parameter to add.
     * @param params The list of parameters to add the parameter to.
     */
    protected void addParameter(String name, String value, List<NameValuePair> params) {
        if (null == name) {
            throw new IllegalArgumentException("name must not be null.");
        }
        if (null == params) {
            throw new IllegalArgumentException("params must not be null.");
        }

        if (null != value && !value.isEmpty()) {
            params.add(new BasicNameValuePair(name, value));
        }
    }
}
