package com.example.springbootjackson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootJacksonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJacksonApplication.class, args);
    }

}
