package com.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaojw
 * @describe com.order.OrderApplication
 * @date 2021/3/23 17:45
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        System.setProperty("nacos.standalone", "true");
        SpringApplication.run(OrderApplication.class,args);
    }
}
