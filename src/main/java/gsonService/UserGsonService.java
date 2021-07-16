package gsonService;

import com.google.gson.*;
import model.Event;
import model.File;
import model.User;

import java.lang.reflect.Type;

public class UserGsonService implements JsonSerializer<User>, JsonDeserializer<User> {
    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject userObject = new JsonObject();
        userObject.addProperty("id", user.getId());
        userObject.addProperty("first_name", user.getFirstName());
        userObject.addProperty("last_name", user.getLastName());
        userObject.addProperty("events", String.valueOf(user.getEvents()));

        return userObject;
    }

    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        Long id = jsonObject.get("id").getAsLong();
        String firstName = jsonObject.get("first_name").getAsString();
        String lastName = jsonObject.get("last_name").getAsString();
        Long eventId = jsonObject.get("event_id").getAsLong();

        return new User(id, firstName, lastName, eventId);
    }
}
