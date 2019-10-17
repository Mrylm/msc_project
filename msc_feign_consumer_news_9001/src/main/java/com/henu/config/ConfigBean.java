package com.henu.config;/**
 * Created by Administrator on 2019/10/8 0008.
 */

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类
 * @author Administrator
 * @date 2019/10/8 0008 14:13
 * @description
 */

@SpringBootConfiguration
public class ConfigBean {
    //创建RestTemplate对象,用于发送rest请求
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate;
    }
}
