package net.suaree.meetup.model;

/**
 * Represents the text_format values used for the open_events API.
 *
 * @author roger
 */
public enum TextFormat {
    Html("html"),
    Plain("plain");

    private final String value;

    private TextFormat(String value) {
        this.value = value;
    }

    /**
     * Gets the text_format value as used in the open_events API.
     *
     * @return A String that represents the text_format value for the open_events API.
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
