package com.ballistic.fserver.model;

import java.sql.Date;
import java.util.List;

public class Bucket {

    private String id;
    private String uuid;
    private String name;
    private String token; // token? :- token:-bucket' -:
    private String url;
    private List<String> downloadUrl;
    private Date deleteDate;
    private Date updateDate;
    private Date createDate;
    private Boolean isDelete;
    private String userId;

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

    @Override
    public String toString() {
        return "Bucket{" +
                "id='" + id + '\'' + ", uuid='" + uuid + '\'' + ", name='" + name + '\'' +
                ", token='" + token + '\'' + ", url='" + url + '\'' + ", downloadUrl=" + downloadUrl +
                ", deleteDate=" + deleteDate + ", updateDate=" + updateDate + ", createDate=" + createDate +
                ", isDelete=" + isDelete + ", userId='" + userId + '\'' +
                '}';
    }
}
