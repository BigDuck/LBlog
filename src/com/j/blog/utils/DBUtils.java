
package com.j.blog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
		
	//用来把Connection绑定到当前线程上的变量
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

	private static final DBUtils utils=new DBUtils();
	
	
	public static DBUtils getInstance(){
		return utils;
	}
	
	private DBUtils(){
		
	}
	
	public synchronized TransactionManager getTranManager(){
		return new TransactionManager(getConn());
	}
	
	/** 创建连接 */
	public synchronized Connection getConn(){
		
		Connection conn=null;
		
		try {
			
			//从当前线程上获取连接
			conn = tl.get();
			
			if(conn==null){ //说明当前执行线程不附带任何连接对象，需要理解额外构建
			  //查看类路径中是否存在这个驱动入口类
			  Class.forName("com.mysql.jdbc.Driver");
//			  conn=DriverManager.getConnection("proxool.hotelsys-ds");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lblog", "root", "757671834");

				//把它绑定到当前线程上
			  tl.set(conn); 
			}
		  	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	//释放连接
	public  void releaseConn(Connection conn){
		try {			
			if (null != conn){
				tl.remove();// 方法执行完毕，把的那个线程上绑定的连接删除，然后释放掉
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源
	 */
	public void releaseRes(Connection conn, PreparedStatement pstmt, ResultSet rset){
		

			try {
				
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
	}	

}
