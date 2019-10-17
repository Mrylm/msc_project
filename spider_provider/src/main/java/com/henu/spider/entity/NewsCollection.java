package com.henu.spider.entity;/**
 * Created by Administrator on 2019/10/11 0011.
 */

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019/10/11 0011 16:36
 * @description
 */
public class NewsCollection {
    //data与json中data相对应
    public List<News> data;


    public List<News> getData() {
        return data;
    }

    public void setData(List<News> data) {
        this.data = data;
    }
}
