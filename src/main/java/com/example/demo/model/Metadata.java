package com.example.demo.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Metadata {
    private String title;
    private String description;

    @JsonProperty("Title")
    public String getTitle() { return title; }
    @JsonProperty("Title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("Description")
    public String getDescription() { return description; }
    @JsonProperty("Description")
    public void setDescription(String value) { this.description = value; }
}