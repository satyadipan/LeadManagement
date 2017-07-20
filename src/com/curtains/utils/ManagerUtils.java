package com.curtains.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curtains.bean.Course;
import com.curtains.bean.User;

public class ManagerUtils {	
Connection conn = null;
Statement stmt = null;
PreparedStatement pst = null;
ResultSet rs = null;
public ManagerUtils()
{}

public boolean addUser(User user)
	{boolean registered=false;
	
	try{
		conn = DBUtils.getConnection("lead_management");
		
		String sql = "insert into user(uname,uemail,upassword,uphone,urole) values (?,?,?,?,?)";
		
		pst = DBUtils.getPreparedStatement(sql);
		pst.setString(1, user.getUname());
		pst.setString(2, user.getUemail());
		pst.setString(3, user.getUpassword());
		pst.setLong(4, user.getUphone());
		pst.setString(5, user.getUrole());
		
		int r = pst.executeUpdate();
		if(r > 0){
			registered = true;
		}
		
		DBUtils.closeResources(rs,pst,stmt,conn);
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	
	return registered;
	}
public boolean addCourse(Course course)
{boolean added=false;

try{
	conn = DBUtils.getConnection("lead_management");
	
	String sql = "insert into course(name,duration,fee,no_of_seats,start_date) values (?,?,?,?,?)";
	
	pst = DBUtils.getPreparedStatement(sql);
	pst.setString(1, course.getName());
	pst.setInt(2, course.getDuration());
	pst.setInt(3, course.getFee());
	pst.setInt(4, course.getNo_of_seats());
	pst.setString(5, course.getStart_date());
	
	int r = pst.executeUpdate();
	if(r > 0){
		added = true;
	}
	
	DBUtils.closeResources(rs,pst,stmt,conn);
}
catch(SQLException e){
	e.printStackTrace();
}

return added;
}

public boolean deleteCourse(int cid){
	boolean deleted = false;
	conn = DBUtils.getConnection("lead_management");
	String sql = "delete from course WHERE cid="+cid;
	stmt = DBUtils.getSimpleStatement();
	try{
		
		int r = stmt.executeUpdate(sql);
		if(r > 0)
			deleted = true;
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	DBUtils.closeResources(rs, pst, stmt, conn);
	return deleted;
}

public boolean updateCourse(Course c)
{boolean updated = false;
conn = DBUtils.getConnection("lead_management");
String sql = "update course SET name=?, duration=?, fee=?, no_of_seats=?, start_date=? WHERE cid=?";

pst = DBUtils.getPreparedStatement(sql);
try{
	pst.setString(1, c.getName());
	
	pst.setInt(2, c.getDuration());
	pst.setInt(3,c.getFee());
	pst.setInt(4,c.getNo_of_seats());
	pst.setString(5, c.getStart_date());
	pst.setInt(6,c.getCid());
	int r = pst.executeUpdate();
	if(r != 0){
		updated = true;
	}
}catch(SQLException e){
	e.printStackTrace();
}
DBUtils.closeResources(rs, pst, stmt, conn);
System.out.println(updated);
return updated;
	}

public List<User> getAllCounselor(){
	List<User> ulist = new ArrayList<User>();
	conn = DBUtils.getConnection("lead_management");
	String sql = "select * from user WHERE urole='Counselor'";
	stmt = DBUtils.getSimpleStatement();
	User u = null;
	try{
		rs = stmt.executeQuery(sql);
		if(rs != null){
			while(rs.next()){
				u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6));
				ulist.add(u);
			}
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	DBUtils.closeResources(rs, pst, stmt, conn);
	
	return ulist;
}
public User getCounselor(int uid){
	
	conn = DBUtils.getConnection("lead_management");
	String sql = "select * from user WHERE urole='Counselor' AND uid="+uid;
	stmt = DBUtils.getSimpleStatement();
	User u = null;
	try{
		rs = stmt.executeQuery(sql);
		if(rs != null){
			while(rs.next()){
				u = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6));
				
			}
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	DBUtils.closeResources(rs, pst, stmt, conn);
	
	return u;
}

public boolean deleteCounselor(int uid){
	boolean deleted = false;
	conn = DBUtils.getConnection("lead_management");
	String sql = "delete from user WHERE uid="+uid;
	stmt = DBUtils.getSimpleStatement();
	try{
		
		int r = stmt.executeUpdate(sql);
		if(r > 0)
			deleted = true;
		
	}catch(SQLException e){
		e.printStackTrace();
	}
	DBUtils.closeResources(rs, pst, stmt, conn);
	return deleted;
}

}
