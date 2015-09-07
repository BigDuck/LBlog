package com.j.blog.serviceImpl;

import java.util.List;

import com.j.blog.dao.UserDao;
import com.j.blog.dao.UserDaoImpl;
import com.j.blog.daomain.User;
import com.j.blog.service.UserService;
import com.j.blog.utils.DBUtils;
import com.j.blog.utils.TransactionManager;

public class UserServiceImpl implements UserService {

	@Override
	public User getUserById(Integer tId) {
		UserDao userDao = new UserDaoImpl();
		TransactionManager tx = null;
		User user = null;
		try {

			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			user = userDao.selectUserById(tId);
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> loadAllUser() {
		UserDao userDao = new UserDaoImpl();
		TransactionManager tx = null;
		List<User> user = null;
		try {
			tx = DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			user = userDao.selectAllUser();
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		
		
		return user;
	}

	@Override
	public boolean removeUserById(Integer tId) {
		UserDao userDao = new UserDaoImpl();
		TransactionManager tx =null;
		boolean result = false;
		try {
			
			tx=DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			result = userDao.deleteUserById(tId);
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean updateUser(User articleType) {
		UserDao userDao = new UserDaoImpl();
		TransactionManager tx =null;
		boolean result = false;
		try {
			
			tx=DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			result = userDao.updateUser(articleType);
			tx.commitAndClose();
		} catch (Exception e) {
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean addUser(User user) {
		UserDao userDao = new UserDaoImpl();
		TransactionManager tx = null;
		int result = 0;
		try {
			tx=DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			result = userDao.insertUser(user);
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

	@Override
	public User getUserByEmail(String mail) {
		UserDao userDao = new UserDaoImpl();
		TransactionManager tx = null;
		User user = null;
		try{
			tx=DBUtils.getInstance().getTranManager();
			tx.beginTransaction();
			user = userDao.selectUserByEmail(mail);
			tx.commitAndClose();
			
		}catch(Exception e){
			tx.rollbackAndClose();
			e.printStackTrace();
		}
		return user;
	}

}
