package com.example.springbootproperties.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
//默认加载resource文件夹下的properties文件
@ConfigurationProperties(prefix = "family")
@PropertySource(value = "classpath:family.yml",factory = MixPropertiesFactory.class)
public class Family {
    private String familyName;
}
