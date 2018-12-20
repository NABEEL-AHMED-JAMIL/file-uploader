package com.ballistic.fserver.model.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.springframework.web.multipart.MultipartFile;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "file", "files", "data" })
public class FileWithObject<T> {

    @JsonProperty("file")
    private MultipartFile file;
    @JsonProperty("files")
    private MultipartFile[] files; // Note :- not support with api(singleFileUploadWithObject,listOfObjectsWithSingleFile)
    @JsonRawValue
    @JsonProperty("data")
    private T data;

    public FileWithObject() { }

    public FileWithObject(MultipartFile file, T data) {
        this.file = file;
        this.data = data;
    }

    public FileWithObject(MultipartFile[] files, T data) {
        this.files = files;
        this.data = data;
    }

    public MultipartFile getFile() { return file; }
    public void setFile(MultipartFile file) { this.file = file; }

    public MultipartFile[] getFiles() { return files; }
    public void setFiles(MultipartFile[] files) { this.files = files; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

}
