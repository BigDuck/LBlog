package com.j.blog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(filterName="premission",urlPatterns="/admin")
public class PermissionFilter  implements Filter{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest srt, ServletResponse sre, 
			FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("¿πΩÿ");
		 HttpServletRequest request = (HttpServletRequest)srt; 
		 HttpServletResponse response = (HttpServletResponse)sre; 
		String name=(String)request.getSession().getAttribute("user");
		System.out.println("”√ªß"+name+"id="+request.getSession().getAttribute("userId"));
		if(name==null||name.trim().length()<1){
			response.sendRedirect("loginAdmin");
		}else{
			filterChain.doFilter(srt, sre);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

			System.out.println("init");
	}

}
