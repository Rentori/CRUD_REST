package gsonService;

import com.google.gson.*;
import model.File;

import java.lang.reflect.Type;

public class FileGsonService implements JsonSerializer<File>, JsonDeserializer<File> {
    @Override
    public JsonElement serialize(File file, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject fileObject = new JsonObject();
        fileObject.addProperty("id", file.getId());
        fileObject.addProperty("name", file.getName());

        return fileObject;
    }

    @Override
    public File deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        Long id = jsonObject.get("id").getAsLong();
        String name = jsonObject.get("name").getAsString();
        File file = new File(id, name);

        return file;
    }
}
