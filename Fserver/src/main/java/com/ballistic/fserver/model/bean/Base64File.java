package com.ballistic.fserver.model.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "filename", "filetype", "value" })
public class Base64File {

    @JsonProperty("filename")
    public String filename;
    @JsonProperty("filetype")
    public String filetype;
    @JsonProperty("value")
    public String value;

    public Base64File() {}

    public Base64File(String filename, String filetype, String value) {
        this.filename = filename;
        this.filetype = filetype;
        this.value = value;
    }

    public String getFilename() { return filename; }
    public void setFilename(String filename) { this.filename = filename; }

    public String getFiletype() { return filetype; }
    public void setFiletype(String filetype) { this.filetype = filetype; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

}