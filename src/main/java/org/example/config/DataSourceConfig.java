package org.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariDataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/t");
        hikariDataSource.setUsername("root");
        hikariDataSource.setPassword(System.getenv("LOCALHOST_MYSQL_PASSWORD"));
        hikariDataSource.setMinimumIdle(3);
        hikariDataSource.setConnectionTimeout(1000);
        hikariDataSource.setMaximumPoolSize(4);
        hikariDataSource.setMaxLifetime(60000);
        hikariDataSource.setIdleTimeout(60000);
        return hikariDataSource;
    }

}
