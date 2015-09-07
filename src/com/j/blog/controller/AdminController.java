package com.j.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j.blog.daomain.Article;
import com.j.blog.daomain.ArticleType;
import com.j.blog.daomain.User;
import com.j.blog.service.ArticleService;
import com.j.blog.service.ArticleTypeService;
import com.j.blog.service.UserService;
import com.j.blog.serviceImpl.ArticleServiceImpl;
import com.j.blog.serviceImpl.ArticleTypeImpl;
import com.j.blog.serviceImpl.UserServiceImpl;
import com.j.blog.utils.DateUtil;
import com.j.blog.utils.Logger;

@WebServlet(name = "/AdminController", urlPatterns = "/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ArticleService articleService = new ArticleServiceImpl();
		UserService userService=new UserServiceImpl();
		if (request.getParameter("what") != null
				&& "main".equals(request.getParameter("what"))) {
			request.setAttribute("user",
					request.getSession().getAttribute("user"));
			request.getRequestDispatcher("WEB-INF/admin/main.jsp").forward(
					request, response);
		} else if (request.getParameter("what") != null
				&& "article".equals(request.getParameter("what"))) {
			List<Article> list = articleService.loadAllArticle();
			logger.debug("文章列表" + list);
			request.setAttribute("users", list);
			request.getRequestDispatcher("WEB-INF/admin/article.jsp").forward(
					request, response);
		} else if (request.getParameter("what") != null
				&& "getart".equals(request.getParameter("what"))) {
			
			String aId = request.getParameter("aId");
			logger.debug("传过来的id：" + aId);
			if (aId != null || aId != "") {
				int id = -1;
				try {
					id = Integer.valueOf(aId);
				} catch (Exception e) {
					e.printStackTrace();
					request.getRequestDispatcher("404.jsp").forward(request,
							response);
				}
				logger.debug("要获取的文章的id:" + id);
				Article article = articleService.getArticleById(id);
				ArticleTypeService articleTypeService = new ArticleTypeImpl();
				request.setAttribute("articleType",
						articleTypeService.loadAllType());
				request.setAttribute("article", article);
				logger.debug("文章是：" + article.toString());
				String result=request.getParameter("result");
				if("1".equals(result)){
					request.setAttribute("info", "success");
				}if ("0".equals(request)){
					request.setAttribute("info", "error");
				}
				request.getRequestDispatcher("WEB-INF/admin/showArticle.jsp")
						.forward(request, response);

			}
		}else 
			if(request.getParameter("what") != null&& "add".equals(request.getParameter("what"))){
			request.setAttribute("writeDate", new Date());
			request.setAttribute("writeUser", request.getSession().getAttribute("user"));
			request.setAttribute("writeUserId", request.getSession().getAttribute("userId"));
			ArticleTypeService articleTypeService = new ArticleTypeImpl();
			request.setAttribute("articleType",
					articleTypeService.loadAllType());
			request.getRequestDispatcher("WEB-INF/admin/writeArticle.jsp").forward(request, response);
		}else 
			if(request.getParameter("what") != null&& "person".equals(request.getParameter("what"))){
			request.setAttribute("my",userService.getUserById(Integer.valueOf(request.getSession().getAttribute("userId").toString())));
			request.getRequestDispatcher("WEB-INF/admin/person.jsp").forward(request, response);
		}
		
		
		else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ArticleService articleService = new ArticleServiceImpl();
		if(request.getParameter("what") != null&& "update".equals(request.getParameter("what"))){
		logger.debug("id="+request.getParameter("articleId"));
		logger.debug("articleOther"+request.getParameter("articleOther"));
			Article article=articleService.getArticleById(Integer.valueOf(request.getParameter("articleId")));
			article.setaTitle(request.getParameter("articleTitle"));
			article.setaContent(request.getParameter("articleCon"));
			article.setUserId(Integer.valueOf(request.getParameter("userId")));
			article.setTypeId(Integer.valueOf(request.getParameter("articleType")));
			article.setaPhoto(request.getParameter("aPhoto"));
			article.setaOther(request.getParameter("articleOther"));
			logger.debug("要更新的数据："+article);
			String  result=articleService.updateArticle(article)?"1":"0";
			response.sendRedirect("admin?what=getart&aId="+article.getaId()+"&result="+result);
		} if(request.getParameter("what") != null&& "remove".equals(request.getParameter("what"))){
			logger.debug("aId"+request.getParameter("aId"));
			int aId=Integer.valueOf(request.getParameter("aId"));
			PrintWriter out=response.getWriter();	
				if(articleService.removeArticleById(aId)){
					out.println(1);	
				}else{
					out.println(0);
				}

		}else if(request.getParameter("what") != null&& "add".equals(request.getParameter("what"))){
			Article article=new Article();
			article.setaTitle(request.getParameter("articleTitle"));
			article.setaContent(request.getParameter("articleCon"));
			article.setaDate(new Date());
			article.setaOther(request.getParameter("articleOther"));
			article.setaPhoto(request.getParameter("photo"));
			article.setTypeId(Integer.valueOf(request.getParameter("articleType")));
		article.setaType(new ArticleType(article.getTypeId(),null,null));
			article.setUserId(Integer.valueOf(request.getParameter("userId")));
			article.setUser(new User(article.getUserId(),null,null,null,-1));
			String re=articleService.addArticle(article)?"1":"0";
			response.sendRedirect("admin?what=add&result="+re);
		}else {
			request.getRequestDispatcher("404.jsp").forward(request, response);
		}
	}

}
