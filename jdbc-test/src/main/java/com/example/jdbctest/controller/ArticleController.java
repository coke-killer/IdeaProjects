package com.example.jdbctest.controller;

import com.example.jdbctest.entity.Article;
import com.example.jdbctest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @PostMapping("/article")
    public void saveArticle(Article article) {
        articleService.save(article);
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }

    @PutMapping("/article")
    public void updateArticle(Article article) {
        articleService.updateArticleById(article);
    }

    @GetMapping("/article/{id}")
    public Article selectArticle(@PathVariable long id) {
        return articleService.selectArticleById(id);
    }

    @GetMapping("/articles")
    public List<Article> selectArticles() {
        return articleService.selectArticles();
    }
}
