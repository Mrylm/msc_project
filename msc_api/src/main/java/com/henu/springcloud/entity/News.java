package com.henu.springcloud.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author shkstart
 * @create 2019-10-12 19:04
 */
public class News {
    public String  appId;//app_id
    public String  title;//title
    public String  intro;//intro
    public String  source;//source
    public String  url; //url
    public String  updateTime ;//update_time

    @Override
    public String toString() {
        return "News{" +
                "appId='" + appId + '\'' +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", source='" + source + '\'' +
                ", url='" + url + '\'' +
                ", updateTime='" + updateTime + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    @JSONField(name="update_time",format = "yyyy-MM-dd HH:mm:ss")
    public String getUpdateTime() {
        return updateTime;
    }
    @JSONField(name="update_time",format = "yyyy-MM-dd HH:mm:ss")
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    @JSONField(name="app_id")
    public String getAppId() {
        return appId;
    }
    @JSONField(name="app_id")
    public void setAppId(String appId) {
        this.appId = appId;
    }
}

