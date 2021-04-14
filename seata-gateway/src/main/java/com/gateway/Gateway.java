package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaojw
 * @describe Gateway
 * @date 2021/4/9 13:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Gateway {
    public static void main(String[] args) {
        SpringApplication.run(Gateway.class,args);
    }
}
