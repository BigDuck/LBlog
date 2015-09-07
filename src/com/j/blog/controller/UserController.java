package com.j.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j.blog.daomain.User;
import com.j.blog.service.UserService;
import com.j.blog.serviceImpl.UserServiceImpl;
import com.j.blog.utils.Logger;
/**
 * @see 用户注册控制器
 * @author j
 *
 */
@WebServlet(name="name",urlPatterns="/user")
public class UserController extends HttpServlet {
private Logger logger=Logger.getLogger(getClass());
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	if(request.getParameter("what") != null
			&& "toRegister".equals(request.getParameter("what"))){
		request.getRequestDispatcher("/WEB-INF/admin/userReg.jsp").forward(request, response);
	}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

			UserService userService=null;
			/**
			 * 注册用户
			 */
		if(request.getParameter("what") != null
				&& "register".equals(request.getParameter("what"))){
			String name=request.getParameter("username");
			String psw=request.getParameter("password");
			String uEmail=request.getParameter("email");
			if(name==null||psw==null||uEmail==null){
				resp.sendRedirect("user?result="+0);
			}else{
			logger.debug(name+psw+uEmail);
			User user=new User();
			user.setuName(name);
			user.setuEmail(uEmail);
			user.setuPsw(psw);
			user.setuLv(0);
			userService=new UserServiceImpl();
			String result=userService.addUser(user)?"1":"0";
			resp.sendRedirect("user?what=toRegister&result="+result);
		}
			}
	}

}
