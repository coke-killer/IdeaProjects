package com.example.springbootproperties.ymlConfig;

import lombok.Data;

import javax.validation.constraints.Max;
import java.util.List;

@Data
public class Child {
    private String name;
    @Max(4)
    private Integer age;
//    private List<Friends> friends;
    private Friends[] friends;
}
