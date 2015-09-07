package com.j.blog.utils;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j.blog.daomain.AuthCode;
@WebServlet(name="code",urlPatterns="/getCode")
public class SecurityCodeServlet  extends HttpServlet{
	  private static final long serialVersionUID = 1L;


	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {
	    	  String authCode = AuthCode.getAuthCode();  
	          
	          request.getSession().setAttribute("authCode", authCode);    //将验证码保存到session中，便于以后验证  
	            
	          try {  
	              //发送图片  
	              ImageIO.write(AuthCode.getAuthImg(authCode), "JPEG", response.getOutputStream());  
	          } catch (IOException e){  
	              e.printStackTrace();  
	          }  
	    }

}
