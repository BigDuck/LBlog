package com.j.blog.service;

import java.util.List;

import com.j.blog.daomain.Article;

public interface ArticleService {
	List<Article> loadAllArticle();
	Article getArticleById(Integer aId);
	boolean removeArticleById(Integer aId);
	boolean updateArticle(Article article);
	boolean  addArticle(Article article);
}
