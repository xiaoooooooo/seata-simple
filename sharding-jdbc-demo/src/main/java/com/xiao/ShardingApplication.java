package com.xiao;

import org.apache.shardingsphere.infra.config.datasource.DataSourceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author xiaojw
 * @describe ShardingApplication
 * @date 2021/4/14 11:08
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class ShardingApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingApplication.class);
    }
}
