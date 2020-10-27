package com.example.springbootproperties.ymlConfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableConfigurationProperties
class FamilyTest {
    @Autowired
    Family family;

    @Test
    public void test() {
        System.out.println(family.toString());
    }

}