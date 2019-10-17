package com.henu.factory;/**
 * Created by Administrator on 2019/10/10 0010.
 */

import com.henu.spider.service.NewsClientService;
import com.henu.springcloud.entity.News;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Administrator
 * @date 2019/10/10 0010 14:01
 * @description
 */
/*@Component
public class NewsClientServiceFallbackFactory implements FallbackFactory<NewsClientService> {
    @Override
    public NewsClientService create(Throwable throwable) {
        return new NewsClientService(){

            @Override
            public List<News> list() {
                return null;
            }

        };
    }
}*/
