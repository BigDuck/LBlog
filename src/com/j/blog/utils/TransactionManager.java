
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
	 * ��������
	 * @throws DAOException
	 */
	public void beginTransaction() {
		try {
			 //�������ύ��ʽ��Ϊ�ֹ��ύ
			 conn.setAutoCommit(false); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ύ����
	 */
	public void commitAndClose() {
		try {
			conn.commit();
		} catch (SQLException e) {
			System.out.println("�����쳣");
			e.printStackTrace();
		}finally{
			DBUtils.getInstance().releaseConn(conn);
		}
	}
	
	/**
	 * �ع�����
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