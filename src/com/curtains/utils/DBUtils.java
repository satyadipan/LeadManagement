package com.curtains.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static Connection conn = null;
	private static Statement stmt = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	
	public static Connection getConnection(String dbName){
		String url = "jdbc:mysql://localhost:3306/"+dbName;
		String user = "root";
		String pwd = "dip#Box95";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static Statement getSimpleStatement(){
		try{
		if(conn != null){
			stmt = conn.createStatement();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
	return stmt;
	}
	
	public static PreparedStatement getPreparedStatement(String sql){
		try{
			if(conn != null){
				pst = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			}
			}catch(SQLException e){
				e.printStackTrace();
			}
		return pst;
	}
	public static void closeResources(ResultSet rs,PreparedStatement pst,Statement stmt,Connection conn){
		try{
			if(rs != null)
				rs.close();
			if(pst != null)
				pst.close();
			if(stmt != null)
				stmt.close();
			if(conn != null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
