package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.example.property.DBProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Autowired
    private DBProperty properties;

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariDataSource.setJdbcUrl(properties.getUrl());
        hikariDataSource.setUsername(properties.getUsername());
        hikariDataSource.setPassword(System.getenv("LOCALHOST_MYSQL_PASSWORD"));
        hikariDataSource.setMinimumIdle(properties.getMinimumIdle());
        hikariDataSource.setConnectionTimeout(properties.getConnectionTimeout());
        hikariDataSource.setMaximumPoolSize(properties.getMaximumPoolSize());
        hikariDataSource.setMaxLifetime(properties.getMaxLifetime());
        return hikariDataSource;
    }

}
