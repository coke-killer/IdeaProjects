package com.example.jdbctest.dao;

import com.example.jdbctest.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ArticleJDBCDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Article article) {
        jdbcTemplate.update("INSERT INTO article(author,title,content,create_time) value (?,?,?,?)", article.getAuthor(), article.getTitle(), article.getContent(),new Date());
    }

    public void deleteArticleById(Long id) {
        jdbcTemplate.update("delete from article where id=?", id);
    }

    public void updateById(Article article) {
        jdbcTemplate.update("UPDATE article SET author=?,title=?,content=?,create_time=? where id=?", article.getAuthor(), article.getTitle(), article.getContent(), new Date(), article.getId());
    }


    public Article findArticleById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM ARTICLE WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Article.class));
    }

    public List<Article> findArticle() {
        return jdbcTemplate.query("SELECT * FROM ARTICLE", new BeanPropertyRowMapper<>(Article.class));
    }
}
