package com.ballistic.fserver.model.dto.http;

import com.google.gson.Gson;

public class FileInfo {

    public static final String FILE_INFO = "fileInfo";
    public static final String FILE_INFOS = "fileInfos";
    public static final String FILE_NAME = "file_name";
    public static final String FILE_SIZE = "file_size";

    private String file_name;
    private Long file_size;

    public FileInfo() {}

    public FileInfo(String file_name, Long file_size) {
        this.file_name = file_name;
        this.file_size = file_size;
    }

    public String getFile_name() { return file_name; }
    public void setFile_name(String file_name) { this.file_name = file_name; }

    public Long getFile_size() { return file_size; }
    public void setFile_size(Long file_size) { this.file_size = file_size; }

    @Override
    public String toString() { return new Gson().toJson(this); }
}
