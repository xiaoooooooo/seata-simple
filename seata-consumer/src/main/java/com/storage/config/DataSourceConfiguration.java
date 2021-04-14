package com.storage.config;

import com.zaxxer.hikari.HikariDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author xiaojw
 * @describe DataSourceConfiguration
 * @date 2021/3/29 17:55
 */
//@Configuration
public class DataSourceConfiguration {
    @Bean
    @Primary
    public DataSourceProxy dataSourceProxy(DataSourceProperties properties){
        HikariDataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
        DataSourceProxy dataSourceProxy = new DataSourceProxy(dataSource);
        return dataSourceProxy;
    }
}