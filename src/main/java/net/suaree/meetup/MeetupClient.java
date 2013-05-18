package net.suaree.meetup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.suaree.meetup.exception.RequestErrorException;
import net.suaree.meetup.exception.RequestException;
import net.suaree.meetup.operations.*;
import net.suaree.meetup.serialization.CalendarDeserializer;
import net.suaree.meetup.serialization.LowercaseEnumTypeAdapterFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;

/**
 * A client for the Meetup (v2) APIs.
 *
 * @author roger
 */
public class MeetupClient {
    private static final Log log = LogFactory.getLog(MeetupClient.class);

    /**
     * Holds the credentials for accessing the Meetup APIs.
     */
    private final Credentials credentials;

    /**
     * Holds the HttpClient to use with this instance.
     */
    private final HttpClient httpClient;

    /**
     * Holds the Gson JSON serializer/deserializer to use with this instance.
     */
    private final Gson gson;

    /**
     * Initializes a new instance of MeetupClient using the given Credentials.
     *
     * @param credentials The Credentials to use when calling the Meetup APIs.
     */
    public MeetupClient(Credentials credentials) {
        this(credentials, new DefaultHttpClient());
    }

    /**
     * Initializes a new instance of MeetupClient using the given Credentials.
     *
     * @param credentials The Credentials to use when calling the Meetup APIs.
     * @param httpClient  The HttpClient to use when invoking the Meetup APIs.
     */
    public MeetupClient(Credentials credentials, HttpClient httpClient) {
        if (null == credentials) {
            throw new IllegalArgumentException("credentials");
        }

        if (null == httpClient) {
            throw new IllegalArgumentException("httpClient");
        }

        this.credentials = credentials;
        this.httpClient = httpClient;

        this.gson = new GsonBuilder()
                .registerTypeAdapter(Calendar.class, new CalendarDeserializer())
                .registerTypeAdapterFactory(new LowercaseEnumTypeAdapterFactory())
                .create();
    }

    public OpenEventsResult getOpenEvents(OpenEventsRequest request) throws RequestException {
        OpenEventsResult result = sendRequest(OpenEventsResult.class, request);

        return result;
    }

    /**
     * Sends the given request to the service and returns the resulting HttpResponse.
     *
     * @param request The RequestBase that describes the request to send to the service.
     * @return An instance of ResultBase that represents the response from the service.
     * @throws RequestException
     */
    private <T extends ResultBase> T sendRequest(Class<T> cls, RequestBase request) throws RequestException {
        assert null != request;

        HttpGet get = null;

        try {
            URI requestUri = request.getUri(credentials);
            get = new HttpGet(requestUri);

            if (log.isDebugEnabled()) {
                log.debug(String.format("GET %s", get.getURI()));
            }

            get.addHeader("Accept-Charset", "UTF-8");

            HttpResponse response = httpClient.execute(get);
            InputStream in = response.getEntity().getContent();
            Reader reader;

            if (log.isDebugEnabled()) {
                log.debug("Response Headers:");

                for (Header header : response.getAllHeaders()) {
                    log.debug(String.format("%s: %s", header.getName(), header.getValue()));
                }
            }

            reader = new InputStreamReader(in);

            if (log.isTraceEnabled()) {
                // If tracing is enabled for this class, wrap the InputStreamReader in a LoggingInputStreamReader so we
                // can log the request body.
                reader = new LoggingInputStreamReader(new BufferedReader(reader));
            }

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode >= 200 && statusCode < 300) {
                T result = gson.fromJson(reader, cls);

                return result;
            } else {
                ErrorResult result = gson.fromJson(reader, ErrorResult.class);

                throw new RequestErrorException(result);
            }
        } catch (URISyntaxException ex) {
            log.error("URISyntaxException:", ex);

            throw new RequestException(ex);
        } catch (ClientProtocolException ex) {
            log.error("ClientProtocolException:", ex);

            throw new RequestException(ex);
        } catch (IOException ex) {
            log.error("IOException:", ex);

            throw new RequestException(ex);
        } finally {
             if (null != get) {
                 get.releaseConnection();
             }
        }
    }
}
