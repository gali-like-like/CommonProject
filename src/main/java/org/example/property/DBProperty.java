package org.example.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties(prefix = "spring.datasource.hikari")
@Data
public class DBProperty {
    @Value("${spring.datasource.hikari.username}")
    private String username;
    @Value("${spring.datasource.hikari.connection-timeout}")
    private Integer connectionTimeout;
    @Value("${spring.datasource.hikari.minimum-idle}")
    private Integer minimumIdle;
    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private Integer maximumPoolSize;
    @Value("${spring.datasource.hikari.max-lifetime}")
    private Integer maxLifetime;
    @Value("${spring.datasource.hikari.idle-timeout}")
    private Integer idleTimeout;
    @Value("${spring.datasource.url}")
    private String url;
}
