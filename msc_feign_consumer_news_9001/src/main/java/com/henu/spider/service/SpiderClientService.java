package com.henu.spider.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shkstart
 * @create 2019-10-16 16:32
 */
    @FeignClient(value = "SPIDER8001")
    public interface SpiderClientService {
        @RequestMapping("/search")
        public String search(@RequestParam(value="keyword",defaultValue = "") String keyword, @RequestParam(value="currentPage",defaultValue = "1") int currentPage, @RequestParam(value="pageSize",defaultValue = "10") int pageSize);

    }



