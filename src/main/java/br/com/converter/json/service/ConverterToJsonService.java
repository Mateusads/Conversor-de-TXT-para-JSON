package br.com.converter.json.service;

import br.com.converter.json.model.Order;
import br.com.converter.json.model.User;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

public class ConverterToJsonService {

    private static JsonPrimitive jsonPrimitive (String format){
        return new JsonPrimitive(format);
    }

    public String converter(Set<User> users){
        Gson converter = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

        return converter.toJson(users);
    }

    private class LocalDateAdapter implements JsonSerializer<LocalDate> {
        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return jsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
        }
    }
}