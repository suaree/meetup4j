package net.suaree.meetup.serialization;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Calendar;

/**
 * @author roger
 */
public class CalendarDeserializer implements JsonDeserializer<Calendar> {
    public Calendar deserialize(JsonElement jsonElement,
                                Type type,
                                JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (jsonElement.isJsonNull()) {
            return null;
        }

        Long dateVal = jsonElement.getAsLong();
        Calendar result = Calendar.getInstance();

        result.setTimeInMillis(dateVal);

        return result;
    }
}
