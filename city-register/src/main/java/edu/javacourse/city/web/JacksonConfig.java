package edu.javacourse.city.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;

@Provider
public class JacksonConfig implements ContextResolver<ObjectMapper> {

    private final ObjectMapper objectMapper;

    public JacksonConfig() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());  // поддержка Java 8 дат
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);  // даты в строку, а не в массив
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return objectMapper;
    }
}