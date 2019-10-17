package com.henu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author shkstart
 * @create 2019-10-16 9:53
 */
@SpringBootApplication
@RibbonClient(name = "spiderservice")
@EnableFeignClients(basePackages={"com.henu.spider.service"})
@ComponentScan("com.henu")
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
public class NewsConsumerFeignApp9001 {
    public static void main(String[] args) {
        SpringApplication.run(NewsConsumerFeignApp9001.class, args);
        //SpringApplication application = new SpringApplication(NewsConsumerFeignApp.class,args);
    }
}

