package com.example.springbootjackson.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import java.time.LocalDate;

@Data
@JsonRootName("Person")
@AllArgsConstructor
//@JsonIgnoreProperties({"name","weight","uid","localDate"}) //序列化时忽略指定属性
@JsonIgnoreProperties(ignoreUnknown = true)  //反序列化时没有get和set的属性全部忽略
//@JsonIgnoreType(value = false)  //不知道
public class PersonTwo {
    private String name;
    private String weight;
    private Integer age;
    private Integer uId;
    private LocalDate localDate;

    @SneakyThrows
    public static void main(String[] args) {
        PersonTwo person = new PersonTwo("xiaowang", "90", 1, 993310, LocalDate.of(1996, 8, 20));
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(person);
        System.out.println(person);
        System.out.println(s);
    }
}
