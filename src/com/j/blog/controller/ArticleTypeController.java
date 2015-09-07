package com.j.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j.blog.daomain.ArticleType;
import com.j.blog.service.ArticleTypeService;
import com.j.blog.serviceImpl.ArticleTypeImpl;
import com.j.blog.utils.Logger;

@WebServlet(name = "type", urlPatterns = "/admin/articletype")
public class ArticleTypeController extends HttpServlet {
	private Logger logger = Logger.getLogger(getClass());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArticleTypeService articleTypeService = new ArticleTypeImpl();

		if (request.getParameter("what") != null
				&& "type".equals(request.getParameter("what"))) {
			List<ArticleType> list = articleTypeService.loadAllType();
			logger.debug("所有类别：" + list);
			request.setAttribute("allType", list);
			request.getRequestDispatcher("/WEB-INF/admin/type.jsp").forward(request,response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArticleTypeService articleTypeService = new ArticleTypeImpl();
		PrintWriter out=response.getWriter();
		if (request.getParameter("what") != null
				&& "add".equals(request.getParameter("what"))) {
			String typeName = request.getParameter("typeName");
			String typeOther = request.getParameter("typeOther");
			logger.debug("分类名：" + typeName + typeOther);
			ArticleType articleType = new ArticleType();
			articleType.settName(typeName);
			articleType.setOther(typeOther);
			boolean result = articleTypeService.addType(articleType);
		
			logger.debug("添加类型结果" + result);
			out.println(result);

		}if(request.getParameter("what") != null
				&& "del".equals(request.getParameter("what"))){
			int id=Integer.valueOf(request.getParameter("typeId"));
			boolean re=articleTypeService.removeTypeById(id);
			out.println(re?"1":"0");
		}else{
			
		}

		
		
		
		
	}

}
