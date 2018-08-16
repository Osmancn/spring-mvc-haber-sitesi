package com.example.demo.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class File {
    private String fileURL;
    private Metadata metadata;

    @JsonProperty("FileUrl")
    public String getFileURL() { return fileURL; }
    @JsonProperty("FileUrl")
    public void setFileURL(String value) { this.fileURL = value; }

    @JsonProperty("Metadata")
    public Metadata getMetadata() { return metadata; }
    @JsonProperty("Metadata")
    public void setMetadata(Metadata value) { this.metadata = value; }
}
