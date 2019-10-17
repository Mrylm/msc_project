package com.henu.spider.service;

import com.henu.springcloud.entity.News;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author shkstart
 * @create 2019-10-16 9:19
 */
@FeignClient(value = "config-service")
public interface NewsClientService {
    @RequestMapping(value = "/spider/get/{id}",method = RequestMethod.GET)
    public News get(@PathVariable("id") long id);

    @RequestMapping(value = "/spider/list" ,method = RequestMethod.GET)
    public List<News> list();

    @RequestMapping(value = "/spider/add",method = RequestMethod.POST)
    public boolean add(News dept);
}
