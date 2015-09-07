
package com.j.blog.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
	
	private Connection conn;
	
	public TransactionManager(Connection conn) {
		this.conn = conn;
	}

	
	
	public Connection getConn() {
		return conn;
	}



	/**
	 * 开启事务
	 * @throws DAOException
	 */
	public void beginTransaction() {
		try {
			 //把事务提交方式改为手工提交
			 conn.setAutoCommit(false); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 提交事务
	 */
	public void commitAndClose() {
		try {
			conn.commit();
		} catch (SQLException e) {
			System.out.println("发生异常");
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
	
	/**
	 * 回滚事务
	 */
	public void rollbackAndClose(){
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
	
	
}