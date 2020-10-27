package com.example.springbootproperties.ymlConfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "family")
public class Family {
    //@Value获取yml文件的值,不支持松散绑定,一次获取一个值，支持spel,${}表达式,不支持数据校验和复杂类型的数组。
//    @Value("${family.family-name}")
    private String familyName;
    private Map<String, String> map;
    private Father father;
    private Mother mother;
    private Child child;

}
