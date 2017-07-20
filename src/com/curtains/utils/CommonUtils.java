package com.curtains.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curtains.bean.User;
import com.curtains.bean.Course;
import com.curtains.bean.Enquiry;




public class CommonUtils {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public User validateUser(String email,String password,String role){
		User user = null;
		conn = DBUtils.getConnection("lead_management");
		String sql = "select * from user WHERE uemail=? AND upassword=? AND urole=?";
		pst = DBUtils.getPreparedStatement(sql);
		try{
			pst.setString(1, email);
			pst.setString(2, password);
			pst.setString(3, role);
			rs = pst.executeQuery();
			if(rs != null){
				while(rs.next()){
					user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources(rs, pst, stmt, conn);
		return user;
	}
	
	public List<Course> getAllCourses(){
		List<Course> clist = new ArrayList<Course>();
		conn = DBUtils.getConnection("lead_management");
		String sql = "select * from course";
		stmt = DBUtils.getSimpleStatement();
		Course c = null;
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					c = new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
					clist.add(c);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources(rs, pst, stmt, conn);
		
		return clist;
	}
	
	public List<Enquiry> getAllEnquiry(){
		List<Enquiry> elist = new ArrayList<Enquiry>();
		conn = DBUtils.getConnection("lead_management");
		String sql = "select * from enquiry";
		stmt = DBUtils.getSimpleStatement();
		Enquiry e = null;
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					e = new Enquiry(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),null);
					Course c=new Course();
					c.setCid(rs.getInt(7));
					e.setCourse(c);
	
					elist.add(e);
				}
			}
		}catch(SQLException e1){
			e1.printStackTrace();
		}
		DBUtils.closeResources(rs, pst, stmt, conn);
		
		return elist;
	}
	
	public Course getCourse(int cid){
		
		conn = DBUtils.getConnection("lead_management");
		String sql = "select * from course WHERE cid="+cid;
		stmt = DBUtils.getSimpleStatement();
		Course c = null;
		try{
			rs = stmt.executeQuery(sql);
			if(rs != null){
				while(rs.next()){
					c = new Course(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6));
					
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources(rs, pst, stmt, conn);
		
		return c;
	}
}
