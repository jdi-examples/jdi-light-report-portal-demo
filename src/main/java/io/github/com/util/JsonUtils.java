package io.github.com.util;

import com.epam.jdi.light.logger.LogLevels;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class JsonUtils {

    private JsonUtils() {
    }

    public static <T> List<T> getObject(InputStream json, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        CollectionType collectionType = typeFactory.constructCollectionType(List.class, tClass);
        try {
            return objectMapper.readValue(json, collectionType);
        } catch (IOException e) {
            logger.toLog(e.getMessage(), LogLevels.ERROR);
            throw new RuntimeException(e.getMessage());
        }
    }
}
