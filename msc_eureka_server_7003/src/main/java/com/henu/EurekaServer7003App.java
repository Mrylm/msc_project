package com.henu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author shkstart
 * @create 2019-10-15 14:30
 */
@SpringBootApplication
@EnableEurekaServer//EurekaServer服务器端启动类,接受其它微服务注册进来
public class EurekaServer7003App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003App.class, args);
    }
}

