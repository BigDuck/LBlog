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

@WebServlet(name="commonSer",urlPatterns="/loginAdmin")
public class CommonController extends HttpServlet {
	private Logger logger=Logger.getLogger(getClass());
	/**
	 * create by J and never say never 
	* 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ºóÌ¨µÇÂ½°É");
		req.getRequestDispatcher("WEB-INF/login/adminLogin.jsp").forward(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		if(request.getParameter("what") != null
				&& "exit".equals(request.getParameter("what"))){
			
			request.getSession().setAttribute("user", null);
			request.getSession().setAttribute("userId",null);
			
		}
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("loginName");
		
		String psw = request.getParameter("password");
		UserService userService = new UserServiceImpl();
		if (name != null || name != "") {
			User user = userService.getUserByEmail(name);
			if (user != null) {
				if (user.getuPsw().equals(psw)) {
					System.out.println("success");
					
					request.getSession().setAttribute("user", user.getuName());
					request.getSession().setAttribute("userId",user.getuId() );
					out.println(1);
				} else {
					System.out.println("error");
					out.println(-1);
				}
			} else {
				System.out.println("error");
				out.println(-1);
			}
		}
		out.close();
	}


}


