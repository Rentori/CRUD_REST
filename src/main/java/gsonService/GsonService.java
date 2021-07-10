package gsonService;

import com.google.gson.*;
import model.Event;
import model.File;
import model.User;

public class GsonService {
    private static Gson instance;

    private GsonService() {
    }

    public static Gson getInstance() {
        if (instance == null) {
            instance = new GsonBuilder()
                    .registerTypeAdapter(User.class, new UserGsonService())
                    .registerTypeAdapter(Event.class, new EventGsonService())
                    .registerTypeAdapter(File.class, new FileGsonService())
                    .create();
        }
        return instance;
    }
}
