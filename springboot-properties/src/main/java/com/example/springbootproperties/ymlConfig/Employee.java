package com.example.springbootproperties.ymlConfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

@Data
@Configuration
@PropertySource(value = "classpath:employee.properties", encoding = "utf-8")
public class Employee {
    @Value("#{'${employee.names}'.split('\\|')}")
    private List<String> employeeNames;
    @Value("#{'${employee.names}'.split('\\|')[0]}")
    private String firstEmployeeName;
    @Value("#{${employee.age}}")
    private Map<String, Integer> employeeAges;
    @Value("#{${employee.age}['two']}")
    private Integer employeeAge;
    //没有值，默认添加成31
    @Value("#{${employee.age}['five']?: 31}")
    private Integer ageWithDefaultValue;
    @Value("#{systemProperties['java.home']}")
    private String javaHome;
}
