package com.henu.spider.dao;

import com.henu.spider.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-10-15 15:53
 */
@Mapper
@Repository
public interface NewsMapper {
    /**
     * 批量添加爬取数据
     * @param list
     * @return
     */
    public int batchSaveNews(@Param("news") List<News> list);
}


