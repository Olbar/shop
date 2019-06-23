package org.levelup.shop.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class JpaConfiguration {

    @Value("${shop.db.host}")
    private String host;
    @Value("${shop.db.name}")
    private String dbName;
    @Value("${shop.db.port}")
    private String port;
    @Value("${shop.db.username}")
    private String username;
    @Value("${shop.db.password}")
    private String password;


   @Bean
    public DataSource dataSource(){
       HikariDataSource dataSource =new HikariDataSource();
       dataSource.setUsername(username);
       dataSource.setPassword(password);
       dataSource.setJdbcUrl(String.format("jdbc:postgresql://%s:%s/%s", host, port, dbName));
       return dataSource;
   }
}
