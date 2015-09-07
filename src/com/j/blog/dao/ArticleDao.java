package com.j.blog.dao;

import java.util.List;

import com.j.blog.daomain.Article;

public interface ArticleDao {
List<Article> selectAllArticle();
Article selectArticleById(Integer aId);
boolean deleteArticleById(Integer aId);
boolean updateArticle(Article article);
int  insertArticle(Article article);
}
