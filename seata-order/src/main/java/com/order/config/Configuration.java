package com.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author xiaojw
 * @describe Configuration
 * @date 2021/3/29 16:03
 */
@Component
@RefreshScope
@ConfigurationProperties(prefix = "order")
@Data
public class Configuration {
    private String appName;
}
