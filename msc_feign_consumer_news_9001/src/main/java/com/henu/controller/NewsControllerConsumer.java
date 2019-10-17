package com.henu.controller;

import com.henu.spider.service.SpiderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author shkstart
 * @create 2019-10-16 10:49
 */
@RestController
public class NewsControllerConsumer {
    //注入feign接口客户端代理对象
    @Autowired
    private SpiderClientService spiderClientService;

    //访问路径前缀
    private static final String REST_URL_PREFIX = "http://localhost:8001";
    //注入restTemplate对象
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 在客户端执行远程访问，访问服务发现接口
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value="/consumer/search")
    public String list(String keyword, @RequestParam(value="currentPage",defaultValue = "1") int currentPage, @RequestParam(value="pageSize",defaultValue = "10") int pageSize){
        return spiderClientService.search(keyword, currentPage, pageSize);
    }


}

