package com.ballistic.fserver.model.dto.http;

import com.google.gson.Gson;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class HttpRequestInfo {

    private Data data;
    private FileInfo fileInfo;
    private MultipartFile file;
    private List<FileInfo> fileInfos;
    private List<MultipartFile> files;

    public HttpRequestInfo() { }

    public HttpRequestInfo(Data data) {
        this.data = data;
    }

    public Data getData() { return data; }
    public void setData(Data data) { this.data = data; }

    public FileInfo getFileInfo() { return fileInfo; }
    public void setFileInfo(FileInfo fileInfo) { this.fileInfo = fileInfo; }

    public List<FileInfo> getFileInfos() { return fileInfos; }
    public void setFileInfos(List<FileInfo> fileInfos) { this.fileInfos = fileInfos; }

    public MultipartFile getFile() { return file; }
    public void setFile(MultipartFile file) { this.file = file; }

    public List<MultipartFile> getFiles() { return files; }
    public void setFiles(List<MultipartFile> files) { this.files = files; }

    @Override
    public String toString() { return new Gson().toJson(this); }
}
