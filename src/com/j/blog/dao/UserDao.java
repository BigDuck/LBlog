package com.j.blog.dao;

import java.util.List;

import com.j.blog.daomain.User;



public interface UserDao {
	User selectUserById(Integer tId);	
	User selectUserByEmail(String mail);	
	List<User> selectAllUser();
	boolean deleteUserById(Integer tId);
	boolean updateUser(User articleType);
	int  insertUser(User user);
}
