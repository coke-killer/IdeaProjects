package com.example.jdbctest.controller;

import com.example.jdbctest.AjaxResponse;
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
    public AjaxResponse selectArticle(@PathVariable long id) {
        Article article = articleService.selectArticleById(id);
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("查询成功");
        ajaxResponse.setData(article);
        return ajaxResponse;
    }

    @GetMapping("/articles")
    public AjaxResponse selectArticles() {
        List<Article> articles = articleService.selectArticles();
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setMessage("查询成功");
        ajaxResponse.setCode(200);
        ajaxResponse.setData(articles);
        return ajaxResponse;
    }
}
