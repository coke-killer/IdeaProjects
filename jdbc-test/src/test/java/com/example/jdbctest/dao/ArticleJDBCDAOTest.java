package com.example.jdbctest.dao;

import com.example.jdbctest.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleJDBCDAOTest {
    @Autowired
    ArticleJDBCDAO articleJDBCDAO;

    @Test
    void save() {
        Article article = new Article("zzz", "10月29心情日记", "xxxxxxxxx", new Date());
        articleJDBCDAO.save(article);
    }

    @Test
    void deleteArticleById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void findArticleById() {
    }

    @Test
    void findArticle() {
    }
}