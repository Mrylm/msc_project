package com.henu;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
        import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
        import org.springframework.context.annotation.ComponentScan;

/**
 * @author shkstart
 * @create 2019-10-15 15:49
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.henu")
@MapperScan(basePackages = "com.henu.spider.dao")
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient//服务发现
public class SpiderApplication8001 {
    public static void main(String[] args)
    {
        SpringApplication.run(SpiderApplication8001.class, args);
    }
}

