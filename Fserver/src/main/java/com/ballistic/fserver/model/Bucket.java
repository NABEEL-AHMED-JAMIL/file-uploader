package com.ballistic.fserver.model;

import com.google.gson.Gson;

import java.sql.Date;
import java.util.List;

public class Bucket {

    private String id;
    private String uuid; // bucket-uuid
    private String name; // name distinct in user-id
    private String token; // token? :- bucket-access-token -:
    private String url; // bucket store location
    private List<String> downloadUrl; // bucket download url's more then 1 create but distinct
    private Date deleteDate; // delete date
    private Date updateDate; // update date
    private Date createDate; // create date
    private Boolean isDelete; // base 'true' when delete-Date added
    private String userId; // + ---> store as user_uuid
    private List<Store> stores; // (file,folder-file,folder-folder-file)

    public Bucket() {}

    public Bucket(String name) { this.name = name; }

    public Bucket(String uuid, String name, String token, String url, List<String> downloadUrl,
           Date deleteDate, Date updateDate, Date createDate, Boolean isDelete) {
        this.uuid = uuid;
        this.name = name;
        this.token = token;
        this.url = url;
        this.downloadUrl = downloadUrl;
        this.deleteDate = deleteDate;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.isDelete = isDelete;
    }

    public Bucket(String uuid, String name, String token, String url, List<String> downloadUrl,
           Date deleteDate, Date updateDate, Date createDate, Boolean isDelete, String userId) {
        this.uuid = uuid;
        this.name = name;
        this.token = token;
        this.url = url;
        this.downloadUrl = downloadUrl;
        this.deleteDate = deleteDate;
        this.updateDate = updateDate;
        this.createDate = createDate;
        this.isDelete = isDelete;
        this.userId = userId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUuid() { return uuid; }
    public void setUuid(String uuid) { this.uuid = uuid; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public List<String> getDownloadUrl() { return downloadUrl; }
    public void setDownloadUrl(List<String> downloadUrl) { this.downloadUrl = downloadUrl; }

    public Date getDeleteDate() { return deleteDate; }
    public void setDeleteDate(Date deleteDate) { this.deleteDate = deleteDate; }

    public Date getUpdateDate() { return updateDate; }
    public void setUpdateDate(Date updateDate) { this.updateDate = updateDate; }

    public Date getCreateDate() { return createDate; }
    public void setCreateDate(Date createDate) { this.createDate = createDate; }

    public Boolean getDelete() { return isDelete; }
    public void setDelete(Boolean delete) { isDelete = delete; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public List<Store> getStores() { return stores; }
    public void setStores(List<Store> stores) { this.stores = stores; }

    @Override
    public String toString() { return new Gson().toJson(this); }

}
