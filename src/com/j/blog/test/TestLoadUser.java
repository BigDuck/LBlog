package com.j.blog.test;

import java.util.List;

import com.j.blog.dao.ArticleDaoImpl;
import com.j.blog.daomain.Article;
import com.j.blog.service.UserService;
import com.j.blog.serviceImpl.ArticleServiceImpl;
import com.j.blog.serviceImpl.UserServiceImpl;
import com.j.blog.utils.DateUtil;

public class TestLoadUser {

	public static void main(String[] args) {
//		ArticleDaoImpl articleDaoImpl=new ArticleDaoImpl();
//		List<Article> list=articleDaoImpl.selectAllArticle();
		//System.out.println(list);
//UserService  u=new UserServiceImpl();
//System.out.println(u.getUserByEmail("757671834@qq.com"));1
//		getAByid();
		dateTest();
		}
	public static void getAByid(){
ArticleServiceImpl articleDaoImpl=new  ArticleServiceImpl();
System.out.println(articleDaoImpl.getArticleById(1));
	}
	public static void dateTest() {
System.out.println(	DateUtil.javaDate2SqlDate(DateUtil.fomatDate("2015-9-4")));

	}
}
