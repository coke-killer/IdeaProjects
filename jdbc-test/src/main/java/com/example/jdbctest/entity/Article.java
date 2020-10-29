package com.example.jdbctest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Date createTime;

    public Article(String author, String title, String content, Date createTime) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }
}
