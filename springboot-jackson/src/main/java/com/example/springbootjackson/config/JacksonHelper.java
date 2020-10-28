package com.example.springbootjackson.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class JacksonHelper {
    private final ObjectMapper objectMapper;

    public JacksonHelper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public String toJson(Object object) {
        return objectMapper.writeValueAsString(object);
    }

    @SneakyThrows
    public <T> T fromJson(String s, Class<T> tClass) {
        return objectMapper.readValue(s, tClass);
    }

    @SneakyThrows
    public Map<String, Object> fromJson(String s) {
        return objectMapper.readValue(s, new TypeReference<Map<String, Object>>() {
        });
    }
}
