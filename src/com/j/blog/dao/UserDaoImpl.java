package com.j.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.j.blog.daomain.User;
import com.j.blog.utils.DBUtils;

public class UserDaoImpl implements UserDao {
	private static final String SQL_ADD = "insert into blog_user (user_name,user_psw,user_mail,user_lv) "
			+ "														values(?,?,?,?)";
	private static final String SQL_LOADALL = "select * from blog_user";
	private static final String SQL_GETBYID = "select * from blog_user where user_id=?";
	private static final String SQL_GETBYMAIL = "select * from blog_user where user_mail=?";

	private static final String SQL_DEL = "delete from blog_user where user_id=?";
	private static final String SQL_UPDATE = "update blog_user set user_name=?, user_psw=?, user_mail=?, user_lv=?"
			+ "where article_id=?";
	@Override
	public User selectUserById(Integer tId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBUtils.getInstance().getConn();
		ResultSet rset=null;
		User user=null;
		
		try {
			pstmt=conn.prepareStatement(SQL_GETBYID);
			pstmt.setInt(1,tId);
			rset=pstmt.executeQuery();
			while(rset.next()){
				user=new User();
				user.setuId(rset.getInt("user_id"));
				user.setuName(rset.getString("user_name"));
				user.setuPsw(rset.getString("user_psw"));
				user.setuLv(rset.getInt("user_lv"));
				user.setuEmail(rset.getString("user_mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseRes(null, pstmt, rset);
		}
		return user;
	}

	@Override
	public List<User> selectAllUser() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBUtils.getInstance().getConn();
		ResultSet rset=null;
		List<User> userList=new ArrayList<User>();
		
		try {
			pstmt=conn.prepareStatement(SQL_LOADALL);
			rset=pstmt.executeQuery();
			while(rset.next()){
				User user=new User();
				user.setuId(rset.getInt("user_id"));
				user.setuName(rset.getString("user_name"));
				user.setuPsw(rset.getString("user_psw"));
				user.setuLv(rset.getInt("user_lv"));
				user.setuEmail(rset.getString("user_mail"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseRes(null, pstmt, rset);
		}
		return userList;
	}

	@Override
	public boolean deleteUserById(Integer tId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBUtils.getInstance().getConn();	
		try {
			pstmt=conn.prepareStatement(SQL_DEL);
			pstmt.setInt(1, tId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			DBUtils.getInstance().releaseRes(null, pstmt, null);

		}
		
		
		
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBUtils.getInstance().getConn();
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(SQL_UPDATE);
			//user_name=?, user_psw=?, user_mail=?, user_lv=?
			pstmt.setString(1, user.getuName());
			pstmt.setString(2, user.getuPsw());
			pstmt.setString(3, user.getuEmail());
			pstmt.setInt(4, user.getuLv());
			pstmt.setInt(5, user.getuId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally{
			DBUtils.getInstance().releaseRes(null, pstmt, null);
		}
		return true;
	}

	@Override
	public int insertUser(User user) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBUtils.getInstance().getConn();
		int result=0;
		try {
		//	conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(SQL_ADD);
//			(user_name,user_psw,user_mail,user_lv)
			pstmt.setString(1, user.getuName());
			pstmt.setString(2, user.getuPsw());
			pstmt.setString(3, user.getuEmail());
			pstmt.setInt(4, user.getuLv());
			result=pstmt.executeUpdate();
			//conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseRes(null, pstmt, null);
		}
		return result;
	}

	@Override
	public User selectUserByEmail(String mail) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn=DBUtils.getInstance().getConn();
		ResultSet rset=null;
		User user=null;
		try {
			pstmt=conn.prepareStatement(SQL_GETBYMAIL);
			pstmt.setString(1,mail);
			rset=pstmt.executeQuery();
			while(rset.next()){
				user=new User();
				user.setuId(rset.getInt("user_id"));
				user.setuName(rset.getString("user_name"));
				user.setuPsw(rset.getString("user_psw"));
				user.setuLv(rset.getInt("user_lv"));
				user.setuEmail(rset.getString("user_mail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseRes(null, pstmt, rset);
		}
		return user;
	}

}
