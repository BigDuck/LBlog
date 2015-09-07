package com.j.blog.serviceImpl;

import java.util.List;

import com.j.blog.dao.ArticleDao;
import com.j.blog.dao.ArticleDaoImpl;
import com.j.blog.dao.ArticleTypeDao;
import com.j.blog.dao.ArticleTypeDaoImpl;
import com.j.blog.dao.UserDao;
import com.j.blog.dao.UserDaoImpl;
import com.j.blog.daomain.Article;
import com.j.blog.service.ArticleService;
import com.j.blog.utils.DBUtils;
import com.j.blog.utils.Logger;
import com.j.blog.utils.TransactionManager;

public class ArticleServiceImpl implements ArticleService {
private Logger logger=Logger.getLogger(getClass());
	@Override
	public List<Article> loadAllArticle() {
		UserDao userDao = new UserDaoImpl();
		ArticleTypeDao aType = new ArticleTypeDaoImpl();
		List<Article> list = null;
		TransactionManager tx = null;
		try {
			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			ArticleDao articleDao = new ArticleDaoImpl();
			list = articleDao.selectAllArticle();
			for (Article article : list) {
				article.setUser(userDao.selectUserById(article.getUserId()));
				article.setaType(aType.selectTypeById(article.getTypeId()));
			}
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Article getArticleById(Integer aId) {
		TransactionManager tx = null;
		Article a = null;
		try {
			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			ArticleDao articleDao = new ArticleDaoImpl();
			a = articleDao.selectArticleById(aId);
			a.setaType((new ArticleTypeDaoImpl()).selectTypeById(a.getTypeId()));
			a.setUser((new UserDaoImpl()).selectUserById(a.getUserId()));
			logger.debug("ÎÄÕÂImpl£º"+a);
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public boolean removeArticleById(Integer aId) {
		TransactionManager tx = null;
		boolean re = false;
		try {
			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			ArticleDao articleDao = new ArticleDaoImpl();
			re = articleDao.deleteArticleById(aId);
			tx.commitAndClose();

		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean updateArticle(Article article) {
		TransactionManager tx = null;
		boolean re = false;
		try {
			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			ArticleDao articleDao = new ArticleDaoImpl();
			re = articleDao.updateArticle(article);

		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return re;
	}

	@Override
	public boolean addArticle(Article article) {
		TransactionManager tx = null;
		int result = 0;
		try {
			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			ArticleDao articleDao = new ArticleDaoImpl();
			result = articleDao.insertArticle(article);

			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();

		}

		if (result > 0) {
			return true;
		}
		return false;

	}

}
