package com.example.springbootjackson.entity;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonRootName("test")
@AllArgsConstructor
public class Test {
    private String name;
    private Integer age;
    private LocalDate localDate;
    private User user;

}
