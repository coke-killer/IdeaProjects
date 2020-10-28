package com.example.springbootproperties.ymlConfig;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import net.minidev.json.JSONUtil;
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
    Employee employee;
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

    @Test
    public void testEmployee() {
        System.out.println(employee.getEmployeeNames().toString());
        System.out.println(employee.getFirstEmployeeName());
        System.out.println(employee.getEmployeeAges().toString());
        System.out.println(employee.getEmployeeAge().toString());
        System.out.println(employee.getAgeWithDefaultValue());
        System.out.println(employee.getJavaHome());
    }
}
