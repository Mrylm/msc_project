package com.config;/**
 * Created by Administrator on 2019/10/10 0010.
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author Administrator
 * @date 2019/10/10 0010 9:07
 * @description
 */
@SpringBootConfiguration
public class RibbonConfig {
    @Bean
    public IRule getRule(){
        //return  new RandomRule();//指定负载均衡算法
        return  new RandomRule_Five();
    }
}
