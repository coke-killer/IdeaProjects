package com.example.jdbctest.service;


import com.example.jdbctest.entity.Article;

import java.util.List;

public interface ArticleService {
    void save(Article article);

    void deleteArticleById(Long id);

    void updateArticleById(Article article);

    Article selectArticleById(Long id);

    List<Article> selectArticles();
}
