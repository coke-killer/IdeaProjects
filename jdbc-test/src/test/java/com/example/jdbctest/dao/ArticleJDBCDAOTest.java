package com.example.jdbctest.dao;

import com.example.jdbctest.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleJDBCDAOTest {
    @Autowired
    ArticleJDBCDAO articleJDBCDAO;

    @Test
    void save() {
        Article article = new Article("小王", "10月29心情日记", "xxxxxxxxx", new Date());
        articleJDBCDAO.save(article);
    }

    @Test
    void deleteArticleById() {
        articleJDBCDAO.deleteArticleById(1l);
    }

    @Test
    void updateById() {
        Article article = new Article(2l, "小鱼", "10月29心情日记", "xxxxxxxxx", new Date());
        articleJDBCDAO.updateById(article);

    }

    @Test
    void findArticleById() {
        Article articleById = articleJDBCDAO.findArticleById(2l);
        System.out.println(articleById);
    }

    @Test
    void findArticle() {
        List<Article> article = articleJDBCDAO.findArticle();
        System.out.println(article.toString());
    }
}