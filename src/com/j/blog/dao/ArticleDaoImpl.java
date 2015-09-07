package com.j.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j.blog.daomain.Article;
import com.j.blog.daomain.ArticleType;
import com.j.blog.daomain.User;
import com.j.blog.utils.DBUtils;
import com.j.blog.utils.DateUtil;
import com.j.blog.utils.Logger;

/**
 * 操作文章
 * 
 * @author J
 *
 */
public class ArticleDaoImpl implements ArticleDao {
	private static final String SQL_ADD = "insert into blog_article (article_title,article_content,article_user,article_type,article_date,article_other,article_photo) "
			+ "														values(?,?,?,?,?,?,?)";
	private static final String SQL_LOADALL = "select * from blog_article order by article_date desc";
	private static final String SQL_GETBYID = "select * from blog_article where article_id=?";
	private static final String SQL_DEL = "delete from blog_article where article_id=?";
	private static final String SQL_UPDATE = "update blog_article set article_title=?, article_content=?, article_user=?, article_type=? ,article_date=?,article_other=?,article_photo=? where article_id=?";
	private Logger logger=Logger.getLogger(getClass());

	@Override
	public List<Article> selectAllArticle() {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		 List<Article> articles = null;
		try {
			pstmt=conn.prepareStatement(SQL_LOADALL);
			rset=pstmt.executeQuery();
			articles=new ArrayList<Article>();
			while(rset.next()){
				Article article=new Article();
				article.setaId(rset.getInt("article_id"));
				article.setaTitle(rset.getString("article_title"));
				article.setaContent(rset.getString("article_content"));
				article.setaDate(rset.getDate("article_date"));
				article.setaOther(rset.getString("article_other"));
				article.setaPhoto(rset.getString("article_photo"));
			
//				UserDao userDaoImpl=new UserDaoImpl();
//				User user=userDaoImpl.selectUserById(rset.getInt("article_user"));
				article.setUserId(rset.getInt("article_user"));
				if(conn==null){
				 conn=DBUtils.getInstance().getConn();

				}
//				ArticleTypeDao articleTypeDaoImpl=new ArticleTypeDaoImpl();
//				ArticleType articleType=new ArticleType();
//				articleType=articleTypeDaoImpl.selectTypeById(rset.getInt("article_type"));
				article.setTypeId(rset.getInt("article_type"));
				articles.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.getInstance().releaseRes(null, pstmt, rset);

		}
		return articles.size()>0?articles:null;
	}

	@SuppressWarnings("null")
	@Override
	public Article selectArticleById(Integer aId) {

		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		Article article = null;
		try {
			pstmt=conn.prepareStatement(SQL_GETBYID);
			if(aId!=null){
				pstmt.setInt(1, aId);
			}else{
				return null;
			}
		
			rset=pstmt.executeQuery();
			while(rset.next()){
				article=new Article();
				article.setaId(rset.getInt("article_id"));
				article.setaTitle(rset.getString("article_title"));
				article.setaContent(rset.getString("article_content"));
				article.setUserId(rset.getInt("article_user"));;
				article.setaDate(rset.getDate("article_date"));
				article.setTypeId(rset.getInt("article_type"));
				article.setaOther(rset.getString("article_other"));
				article.setaPhoto(rset.getString("article_photo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return article;
	}
	/**
	 * 根据id删除文章
	 * 成功true否则false
	 */

	@Override
	public boolean deleteArticleById(Integer aId) {

		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		boolean result=false;
		try {
			pstmt = conn.prepareStatement(SQL_DEL);
			pstmt.setInt(1, aId);
			int cnt = pstmt.executeUpdate();
			logger.debug("删除结果："+cnt);
			if(cnt!=0){
			result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.getInstance().releaseRes(null, pstmt,null);
		}
		return result;
	}

	@Override
	public boolean updateArticle(Article article) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, article.getaTitle());
			pstmt.setString(2, article.getaContent());
			pstmt.setInt(3, article.getUser().getuId());
			pstmt.setInt(4, article.getaType().gettId());
			pstmt.setDate(5, DateUtil.javaDate2SqlDate(article.getaDate()));
			pstmt.setString(6, article.getaOther());
			pstmt.setString(7, article.getaPhoto());
			pstmt.setInt(8, article.getaId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			DBUtils.getInstance().releaseRes(null, pstmt, null);
		}

		return true;
	}
	/**
	 * 添加文章
	 */
	@Override
	public int insertArticle(Article article) {
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int result=0;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL_ADD);
			pstmt.setString(1, article.getaTitle());
			pstmt.setString(2, article.getaContent());
			pstmt.setInt(3, article.getUser().getuId());
			pstmt.setInt(4, article.getaType().gettId());
			pstmt.setDate(5, DateUtil.javaDate2SqlDate(article.getaDate()));
			pstmt.setString(6, article.getaOther());
			pstmt.setString(7, article.getaPhoto());
			//执行
		  result=	pstmt.executeUpdate();
		conn.commit();
		} catch (SQLException e) {
			System.out.println("添加文章異常");
			e.printStackTrace();
		}finally {
			DBUtils.getInstance().releaseRes(null, pstmt, rs);
		}

		return result;
	}

}
