package com.j.blog.dao;

import java.util.List;

import com.j.blog.daomain.ArticleType;

public interface ArticleTypeDao {
ArticleType selectTypeById(Integer tId);	
List<ArticleType> selectAllType();
boolean deleteTypeById(Integer tId);
boolean updateType(ArticleType articleType);
int  insertType(ArticleType articleType);
}
