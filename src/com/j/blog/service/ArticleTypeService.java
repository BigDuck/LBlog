package com.j.blog.service;

import java.util.List;

import com.j.blog.daomain.ArticleType;

public interface ArticleTypeService {
	ArticleType getTypeById(Integer tId);	
	List<ArticleType> loadAllType();
	boolean removeTypeById(Integer tId);
	boolean updateType(ArticleType articleType);
	boolean  addType(ArticleType articleType);
}
