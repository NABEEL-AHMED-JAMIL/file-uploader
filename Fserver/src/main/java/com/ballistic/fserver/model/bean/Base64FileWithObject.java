package com.ballistic.fserver.model.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "file", "files", "data" })
public class Base64FileWithObject<T> {

    @JsonProperty("file")
    private Base64File file;
    @JsonProperty("files")
    private Base64File[] files;
    @JsonRawValue
    @JsonProperty("data")
    private T data;

    public Base64FileWithObject() {}

    public Base64FileWithObject(Base64File file, T data) {
        this.file = file;
        this.data = data;
    }

    public Base64FileWithObject(Base64File[] files, T data) {
        this.files = files;
        this.data = data;
    }

    public Base64File getFile() { return file; }
    public void setFile(Base64File file) { this.file = file; }

    public Base64File[] getFiles() { return files; }
    public void setFiles(Base64File[] files) { this.files = files; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

}