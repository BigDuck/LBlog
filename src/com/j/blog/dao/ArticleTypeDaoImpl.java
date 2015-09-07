package com.j.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j.blog.daomain.ArticleType;
import com.j.blog.utils.DBUtils;

public class ArticleTypeDaoImpl implements ArticleTypeDao {
	private static final String SQL_ADD = "insert into blog_type (type_name,type_other) values(?,?)";
	private static final String SQL_LOADALL = "select * from blog_type ";
	private static final String SQL_GETBYID = "select * from blog_type where type_id=?";
	private static final String SQL_DEL = "delete from blog_type where type_id=?";
	private static final String SQL_UPDATE = "update blog_type set type_name=?, type_other=? where type_id=?";

	/**
	 * 根据id 查询类别
	 */
	@Override
	public ArticleType selectTypeById(Integer tId) {
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArticleType articleType = null;
		try {
			pstmt = conn.prepareStatement(SQL_GETBYID);
			pstmt.setInt(1, tId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				articleType = new ArticleType();
				articleType.settId(rs.getInt("type_id"));
				articleType.settName(rs.getString("type_name"));
				articleType.setOther(rs.getString("type_other"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.getInstance().releaseRes(null, pstmt, rs);

		}
		return articleType;
	}

	@Override
	public List<ArticleType> selectAllType() {
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ArticleType> listA = new ArrayList<ArticleType>();
		try {
			pstmt = conn.prepareStatement(SQL_LOADALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ArticleType articleType = new ArticleType();
				articleType.settId(rs.getInt("type_id"));
				articleType.settName(rs.getString("type_name"));
				articleType.setOther(rs.getString("type_other"));
				listA.add(articleType);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			DBUtils.getInstance().releaseRes(null, pstmt, rs);

		}

		return listA;
	}

	@Override
	public boolean deleteTypeById(Integer tId) {
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(SQL_DEL);
			pstmt.setInt(1, tId);
			int cnt = pstmt.executeUpdate();
			if (cnt != 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}

		return false;
	}

	@Override
	public boolean updateType(ArticleType articleType) {
		Connection conn = DBUtils.getInstance().getConn();
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, articleType.gettName());
			pstmt.setString(2, articleType.getOther());
			pstmt.setInt(3, articleType.gettId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public int insertType(ArticleType articleType) {
		Connection conn=DBUtils.getInstance().getConn();
		PreparedStatement pstmt=null;
		int  rs=0;
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(SQL_ADD);
			pstmt.setString(1, articleType.gettName());
			pstmt.setString(2, articleType.getOther());
			rs=pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//设置数据库为不自动提交，必须的一步	

		return rs;
	}

}
