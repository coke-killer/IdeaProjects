package com.example.springbootproperties.ymlConfig;

import lombok.Data;

import java.util.List;

@Data
public class Father {
    private String name;
    private Integer age;
    private List<String> alias;
}
