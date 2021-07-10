package gsonService;

import com.google.gson.*;
import model.Event;
import model.File;

import java.lang.reflect.Type;

public class EventGsonService implements JsonSerializer<Event>, JsonDeserializer<Event> {
    @Override
    public JsonElement serialize(Event event, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject eventObject = new JsonObject();
        eventObject.addProperty("id", event.getId());
        eventObject.addProperty("name", event.getName());
        eventObject.addProperty("file_id", event.getFile().getId());

        return eventObject;
    }

    @Override
    public Event deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Long id = jsonObject.get("id").getAsLong();
        String name = jsonObject.get("name").getAsString();
        Long fileId = jsonObject.get("file_id").getAsLong();
        Event event = new Event(id, name, new File(fileId));

        return event;
    }
}
