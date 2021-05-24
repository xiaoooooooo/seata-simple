package com.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaojw
 * @describe SeataSecurity
 * @date 2021/5/20 16:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SeataSecurity {
    public static void main(String[] args) {
        SpringApplication.run(SeataSecurity.class);
    }
}
