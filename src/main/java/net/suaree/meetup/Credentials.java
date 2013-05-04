package net.suaree.meetup;

/**
 * Represents access credentials for the Meetup APIs.
 *
 * @author roger
 */
public class Credentials {
    private final String apiKey;

    /**
     * Initializes a new instance of Credentials using the given apiKey and no user key.
     *
     * @param apiKey The value for the key parameter of the Meetup APIs.
     */
    public Credentials(String apiKey) {
        this.apiKey = apiKey;
    }

    /**
     * Gets the app_key value to use for the Meetup APIs.
     *
     * @return A String that represents the key value for the Meetup APIs.
     */
    public String getApiKey() {
        return apiKey;
    }
}
