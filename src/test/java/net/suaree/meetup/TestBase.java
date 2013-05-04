package net.suaree.meetup;

/**
 * @author roger
 */
abstract class TestBase {
    private final Credentials credentials = new Credentials("test_key");

    protected Credentials getCredentials() {
        return credentials;
    }
}
