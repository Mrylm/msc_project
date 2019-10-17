package com.henu.spider.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author shkstart
 * @create 2019-10-15 15:54
 */
public class News {
    private String appId;
    private String title;
    private String intro;
    private String source;
    private String url;
    private Date updateTime;

    @Override
    public String toString() {
        return "News{" +
                "appId='" + appId + '\'' +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", updateTime=" + updateTime +
                '}';
    }

    @JSONField(name="app_id")
    public String getAppId() {
        return appId;
    }
    @JSONField(name="app_id")
    public void setAppId(String appId) {
        this.appId = appId;
    }
    @JSONField(name="title")
    public String getTitle() {
        return title;
    }
    @JSONField(name="title")
    public void setTitle(String title) {
        this.title = title;
    }
    @JSONField(name="intro")
    public String getIntro() {
        return intro;
    }
    @JSONField(name="intro")
    public void setIntro(String intro) {
        this.intro = intro;
    }
    @JSONField(name="source")
    public String getSource() {
        return source;
    }
    @JSONField(name="source")
    public void setSource(String source) {
        this.source = source;
    }
    @JSONField(name="url")
    public String getUrl() {
        return url;
    }
    @JSONField(name="url")
    public void setUrl(String url) {
        this.url = url;
    }
    @JSONField(name="update_time",format = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return updateTime;
    }
    @JSONField(name="update_time",format = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

