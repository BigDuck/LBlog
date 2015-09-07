
package com.j.blog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
		
	//������Connection�󶨵���ǰ�߳��ϵı���
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
	
	/** �������� */
	public synchronized Connection getConn(){
		
		Connection conn=null;
		
		try {
			
			//�ӵ�ǰ�߳��ϻ�ȡ����
			conn = tl.get();
			
			if(conn==null){ //˵����ǰִ���̲߳������κ����Ӷ�����Ҫ�����⹹��
			  //�鿴��·�����Ƿ����������������
			  Class.forName("com.mysql.jdbc.Driver");
//			  conn=DriverManager.getConnection("proxool.hotelsys-ds");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lblog", "root", "757671834");

				//�����󶨵���ǰ�߳���
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
	
	//�ͷ�����
	public  void releaseConn(Connection conn){
		try {			
			if (null != conn){
				tl.remove();// ����ִ����ϣ��ѵ��Ǹ��߳��ϰ󶨵�����ɾ����Ȼ���ͷŵ�
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ͷ���Դ
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
