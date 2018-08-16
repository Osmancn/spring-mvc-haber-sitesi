package com.example.demo.model;

import java.util.Map;
import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum ContentType {
    ARTICLE;

    @JsonValue
    public String toValue() {
        switch (this) {
            case ARTICLE: return "Article";
        }
        return null;
    }

    @JsonCreator
    public static ContentType forValue(String value) throws IOException {
        if (value.equals("Article")) return ARTICLE;
        throw new IOException("Cannot deserialize ContentType");
    }
}
