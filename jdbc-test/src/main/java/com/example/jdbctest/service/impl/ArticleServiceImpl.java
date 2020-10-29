package com.example.jdbctest.service.impl;

import com.example.jdbctest.dao.ArticleJDBCDAO;
import com.example.jdbctest.entity.Article;
import com.example.jdbctest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleJDBCDAO articleJDBCDAO;

    @Override
    public void save(Article article) {
        articleJDBCDAO.save(article);

    }

    @Override
    public void deleteArticleById(Long id) {
        articleJDBCDAO.deleteArticleById(id);
    }

    @Override
    @Transactional
    //回滚，，，异常抛出之后数据库不继兴继续操作
    public void updateArticleById(Article article) {
        if (article.getId() == null) {
            //TODO 抛出自定义异常
        }
        articleJDBCDAO.updateById(article);
        int a = 10 / 0;
    }

    @Override
    public Article selectArticleById(Long id) {
        return articleJDBCDAO.findArticleById(id);
    }

    @Override
    public List<Article> selectArticles() {
        return articleJDBCDAO.findArticle();
    }
}
