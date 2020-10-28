package com.example.springbootjackson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.time.LocalDate;

@JsonRootName("Person")  //JsonRootName 指定jason根属性名称
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @JsonProperty(value = "previousName", index = 3)
    //JsonProperty value指定java对象序列化成Json时key的名字(名字相同不用指定)，order指定生成属性顺序与@JsonPropertyOder相似
    private String name;
    @JsonProperty(value = "newId", index = 1)
    private Integer id;
    @JsonProperty(index = 2)
    private Integer uId;
    @JsonIgnore  //排除属性，java序列化成json字符与json反序列化成java对象均排除
    private String weight;
    @JsonProperty
//    @JsonIgnore
//    @JsonFormat(pattern = "yyyy-DD-MM")
    private LocalDate localDate;

    @SneakyThrows
    public static void main(String[] args) {
        Person person = new Person("xiaowang", 1, 993310, "90", LocalDate.of(1996, 8, 20));
        ObjectMapper objectMapper = new ObjectMapper();
//                objectMapper.registerModule(new JavaTimeModule())
//                .registerModule(new ParameterNamesModule())
//                .registerModule(new Jdk8Module());
        String s = objectMapper.writeValueAsString(person);
        System.out.println(person);
        System.out.println(s);
//        Person person1 = objectMapper.readValue(s, Person.class);
//        System.out.println(person1);
    }
}
