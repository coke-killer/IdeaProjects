package com.example.springbootjackson.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@JsonRootName("User")  //JsonRootName用于指定json根属性名称
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"name", "age"})   //反序列化是标注的类置为null，没有无参构造函数无法从json发布序列化成字符串
public class User {
    //    @JsonProperty(value = "xxx",index = 3)  //JsonProperty 用于指定一个属性用于Json映射 ,value指定Jsonkey，的值。 Index指定生成的Json顺序
    private String name;
    //    @JsonProperty(value = "aaa",index = 1)
    private Integer age;
    //    @JsonFormat
    @JsonIgnore   //JsonIgnore 排除某些属性，jackson不会序列化和反序列化某些属性
    private LocalDate localDate;

    @SneakyThrows
    public static void main(String[] args) {
//        User user = new User("xiaowang", 1, LocalDate.of(1997, 12, 04));
        ObjectMapper objectMapper = new ObjectMapper();
//        String s = objectMapper.writeValueAsString(user);
//        System.out.println(s);
//        System.out.println(user);
//        User user1 = objectMapper.readValue(s, User.class);
//        //反序列化
//        System.out.println(user1);
//        //字节流序列化与反序列化
//        byte[] bytes = objectMapper.writeValueAsBytes(user);
//        System.out.println(bytes);
//        //反序列化参数：序列化结果，和对象class类
//        User user2 = objectMapper.readValue(bytes, User.class);
//        System.out.println(user2);
//        //文件序列化与反序列化
//        objectMapper.writeValue(new File("user.json"),user);
//        User user3 = objectMapper.readValue(new File("user.json"), User.class);
//        System.out.println(user3);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "xiaowang");
        map.put("age", "18");
        map.put("interests", new String[]{"music", "sing"});
        map.put("xxx", null);
        String s1 = objectMapper.writeValueAsString(map);
        System.out.println(s1);
        //map形式由于类型擦除需要写入new TypeReference<Map<String,Object>>(){} 指定泛型
        Map<String, Object> stringObjectMap = objectMapper.readValue(s1, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(stringObjectMap);
//        JsonNode root = objectMapper.readTree(s1);
//        String name = root.get("name").asText();
//        int age = root.get("age").asInt();
//        System.out.println("name:" + name + " age:" + age);
    }
}
