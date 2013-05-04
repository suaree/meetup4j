package net.suaree.meetup;

import net.suaree.meetup.exception.RequestErrorException;
import net.suaree.meetup.exception.RequestException;
import net.suaree.meetup.model.Event;
import net.suaree.meetup.model.ResultMetadata;
import net.suaree.meetup.operations.ErrorResult;
import net.suaree.meetup.operations.OpenEventsRequest;
import net.suaree.meetup.operations.OpenEventsResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author roger
 */
public class OpenEventsSearchTest extends TestBase {
    @Test
    public void testBasicError() {
        MeetupClient client = new MeetupClient(getCredentials(),
                new ResourceBasedHttpClient("/OpenEvents-Error.json", 400));
        OpenEventsRequest request = new OpenEventsRequest();

        try {
            client.getOpenEvents(request);
            Assert.fail();
        } catch (RequestErrorException ex) {
            ErrorResult error = ex.getError();

            Assert.assertNotNull(error);
            Assert.assertEquals("bad_request", error.getCode());
            Assert.assertEquals("The API request is malformed", error.getProblem());
        } catch (RequestException ex) {
            Assert.fail();
        }
    }

    @Test
    public void testBasicSearch() throws RequestException {
        MeetupClient client = new MeetupClient(getCredentials(),
                new ResourceBasedHttpClient("/OpenEvents-Ok.json"));
        OpenEventsRequest request = new OpenEventsRequest();

        request.setZip("10012");
        request.setPageSize(200);

        OpenEventsResult result = client.getOpenEvents(request);
        Assert.assertNotNull(result);

        ResultMetadata meta = result.getMeta();
        Assert.assertNotNull(meta);
        Assert.assertEquals(new Integer(192), meta.getCount());
        Assert.assertEquals(new Integer(1012), meta.getTotalCount());

        List<Event> events = result.getEvents();
        Assert.assertNotNull(events);
        Assert.assertEquals(192, events.size());
    }
}
