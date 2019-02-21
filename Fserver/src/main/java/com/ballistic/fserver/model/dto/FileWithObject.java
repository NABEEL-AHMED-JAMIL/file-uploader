package com.ballistic.fserver.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.google.gson.Gson;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "file", "files", "data" })
public class FileWithObject<T> {

    @JsonProperty("file")
    private MultipartFile file;
    @JsonProperty("files")
    private List<MultipartFile> files;
    @JsonRawValue
    @JsonProperty("data")
    private T data;
    // work like (meta-data)
    List<FileWithObject> rawData;

    public FileWithObject() { }

    public FileWithObject(T data) { this.data = data; }

    public FileWithObject(MultipartFile file, T data) {
        this.file = file;
        this.data = data;
    }

    public FileWithObject(List<MultipartFile> files, T data) {
        this.files = files;
        this.data = data;
    }

    public FileWithObject(List<FileWithObject> rawData) { this.rawData = rawData; }

    public MultipartFile getFile() { return file; }
    public void setFile(MultipartFile file) { this.file = file; }

    public List<MultipartFile> getFiles() { return files; }
    public void setFiles(List<MultipartFile> files) { this.files = files; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public List<FileWithObject> getRawData() { return rawData; }
    public void setRawData(List<FileWithObject> rawData) { this.rawData = rawData; }

    @Override
    public String toString() { return new Gson().toJson(this); }

}