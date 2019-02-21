package com.ballistic.fserver.model;

import com.google.gson.Gson;

import java.util.Date;
import java.util.Set;

public class Store {

    private String id;
    private String resourceName; // resourceName(1,2,3) in case of same name
    private Boolean isFolder; // folder-case
    private Long size; // size (kb,mb,gb) if it's accessed more then 100gb then show error store not possible
    private String contentType; // (folder,image(png,jpg),document(text,csv),video(mp4,vlc))
    private String width; // only (image,video)
    private String height; // only (image,video)
    private Date createDate;
    private Date updateDate;
    private Date deleteDate;
    private Boolean isDelete;
    private Set<String> downloadUrl;
    private Set<Store> storeList; // in case folder

    @Override
    public String toString() { return new Gson().toJson(this); }

}
