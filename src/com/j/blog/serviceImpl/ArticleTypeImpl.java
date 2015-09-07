package com.j.blog.serviceImpl;

import java.util.List;

import com.j.blog.dao.ArticleTypeDao;
import com.j.blog.dao.ArticleTypeDaoImpl;
import com.j.blog.daomain.Article;
import com.j.blog.daomain.ArticleType;
import com.j.blog.service.ArticleService;
import com.j.blog.service.ArticleTypeService;
import com.j.blog.utils.DBUtils;
import com.j.blog.utils.TransactionManager;

public class ArticleTypeImpl implements ArticleTypeService {

	@Override
	public ArticleType getTypeById(Integer tId) {
		ArticleTypeDao aType = new ArticleTypeDaoImpl();

		ArticleType articleType = null;

		TransactionManager tx = null;
		try {
			tx = DBUtils.getInstance().getTranManager();

			tx.beginTransaction();
			articleType = aType.selectTypeById(tId);
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return articleType;
	}

	@Override
	public List<ArticleType> loadAllType() {
		ArticleTypeDao aType = new ArticleTypeDaoImpl();
		List<ArticleType> listType = null;
		TransactionManager tx = null;
		try {

			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			listType = aType.selectAllType();
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return listType;
	}

	@Override
	public boolean removeTypeById(Integer tId) {
		ArticleTypeDao aType = new ArticleTypeDaoImpl();
		TransactionManager tx = DBUtils.getInstance().getTranManager();
		tx.beginTransaction();
		boolean rs = false;
		rs = aType.deleteTypeById(tId);
		tx.commitAndClose();
		return rs;
	}

	@Override
	public boolean updateType(ArticleType articleType) {
		ArticleTypeDao aType = new ArticleTypeDaoImpl();
		TransactionManager tx = null;
		boolean rs = false;
		try {

			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			rs = aType.updateType(articleType);
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public boolean addType(ArticleType articleType) {
		ArticleTypeDao aType = new ArticleTypeDaoImpl();
		int rs = 0;
		TransactionManager tx = DBUtils.getInstance().getTranManager();
		try {
			tx.beginTransaction();
			rs = aType.insertType(articleType);
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}

		if (rs > 0) {
			return true;
		} else {
			return false;
		}
	}

}
