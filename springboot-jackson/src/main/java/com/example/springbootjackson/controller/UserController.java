package com.example.springbootjackson.controller;

import com.example.springbootjackson.config.JacksonHelper;
import com.example.springbootjackson.entity.Test;
import com.example.springbootjackson.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    User user = new User("", 1, LocalDate.of(1997, 12, 04));
    Test test = new Test("XIAOWANG", 1, LocalDate.of(1997, 12, 04), new User());
    @Autowired
    JacksonHelper jacksonHelper;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/getTest")
    public Test json() {
        return test;
    }

    @RequestMapping(value = "/toJson")
    public String toJson() {
        String s = jacksonHelper.toJson(test);
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/fromJson")
    public Object fromJson() {
        String s = jacksonHelper.toJson(user);
        User user = jacksonHelper.fromJson(s, User.class);
        System.out.println(user);
        return user;
    }

    @RequestMapping(value = "/listToJson")
    public String listToJson() {
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user);
        list.add(null);
        String s = jacksonHelper.toJson(list);
        System.out.println(s);
        return s;
    }

}
