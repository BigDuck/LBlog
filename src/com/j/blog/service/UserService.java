package com.j.blog.service;

import java.util.List;

import com.j.blog.daomain.User;

public interface UserService {
	User getUserById(Integer tId);	
	User getUserByEmail(String mail);	
	List<User> loadAllUser();
	boolean removeUserById(Integer tId);
	boolean updateUser(User articleType);
	boolean  addUser(User user);
}
