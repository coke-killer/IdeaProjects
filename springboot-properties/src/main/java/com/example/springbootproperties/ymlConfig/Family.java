package com.example.springbootproperties.ymlConfig;

import com.example.springbootproperties.config.MixPropertiesFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@Configuration
//默认加载resource文件夹下的properties文件
@ConfigurationProperties(prefix = "family")
@Validated
@PropertySource(value = "classpath:family.yml", factory = MixPropertiesFactory.class)
public class Family {
    //@Value获取yml文件的值,不支持松散绑定,一次获取一个值，支持spel,${}表达式,不支持数据校验和复杂类型的数组。
//    @Value("${family.family-name}")
    private String familyName;
    @NotNull
    private Map<String, String> map;
    private Father father;
    private Mother mother;
    private Child child;

}
