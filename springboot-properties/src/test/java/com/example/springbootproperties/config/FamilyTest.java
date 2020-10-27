package com.example.springbootproperties.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@EnableConfigurationProperties
class FamilyTest {
    @Autowired
    Family family;
    @Autowired
    ConfigurableApplicationContext ioc;

    @Test
    public void test() {
        System.out.println(family.toString());
    }

    @Test
    public void testBean() {
        System.out.println(ioc.containsBean("testImportResourceService"));
    }
}