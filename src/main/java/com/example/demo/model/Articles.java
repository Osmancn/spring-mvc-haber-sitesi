package com.example.demo.model;

import java.util.Map;
import com.fasterxml.jackson.annotation.*;

public class Articles {
    private String id;
    private ContentType contentType;
    private String createdDate;
    private String description;
    private File[] files;
    private String modifiedDate;
    private String path;
    private String startDate;
    private String[] tags;
    private String title;
    private String url;

    @JsonProperty("Id")
    public String getID() { return id; }
    @JsonProperty("Id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("ContentType")
    public ContentType getContentType() { return contentType; }
    @JsonProperty("ContentType")
    public void setContentType(ContentType value) { this.contentType = value; }

    @JsonProperty("CreatedDate")
    public String getCreatedDate() { return createdDate; }
    @JsonProperty("CreatedDate")
    public void setCreatedDate(String value) { this.createdDate = value; }

    @JsonProperty("Description")
    public String getDescription() { return description; }
    @JsonProperty("Description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("Files")
    public File[] getFiles() { return files; }
    @JsonProperty("Files")
    public void setFiles(File[] value) { this.files = value; }

    @JsonProperty("ModifiedDate")
    public String getModifiedDate() { return modifiedDate; }
    @JsonProperty("ModifiedDate")
    public void setModifiedDate(String value) { this.modifiedDate = value; }

    @JsonProperty("Path")
    public String getPath() { return path; }
    @JsonProperty("Path")
    public void setPath(String value) { this.path = value; }

    @JsonProperty("StartDate")
    public String getStartDate() { return startDate; }
    @JsonProperty("StartDate")
    public void setStartDate(String value) { this.startDate = value; }

    @JsonProperty("Tags")
    public String[] getTags() { return tags; }
    @JsonProperty("Tags")
    public void setTags(String[] value) { this.tags = value; }

    @JsonProperty("Title")
    public String getTitle() { return title; }
    @JsonProperty("Title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("Url")
    public String getURL() { return url; }
    @JsonProperty("Url")
    public void setURL(String value) { this.url = value; }
}
