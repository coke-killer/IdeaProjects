package com.example.jdbctest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    //转化后台body传过来的字符串时间格式为Date对象，传入传出格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;

    public Article(String author, String title, String content, Date createTime) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }
}
