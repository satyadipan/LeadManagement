package com.curtains.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.curtains.bean.Course;
import com.curtains.bean.Enquiry;
import com.curtains.bean.Follow_Up;
import com.curtains.bean.User;
import com.curtains.utils.DBUtils;

import javafx.scene.chart.PieChart.Data;


public class CounselorUtils {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	
	public boolean addEnquiry(Enquiry enquiry){
		boolean added=false;
		
		try{
			conn = DBUtils.getConnection("lead_management");
			
			String sql = "insert into enquiry (name,email,phone,edesc,edate,c_id) values (?,?,?,?,?,?)";
			
			pst = DBUtils.getPreparedStatement(sql);
			pst.setString(1, enquiry.getName());
			pst.setString(2, enquiry.getEmail());
			pst.setLong(3, enquiry.getPhone());
			pst.setString(4, enquiry.getDesc());
			pst.setString(5, enquiry.getEdate());
			pst.setInt(6, enquiry.getCourse().getCid());
			//delete is a simple statement
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
	
	public boolean addFollow_up(Follow_Up follow_up){
		boolean added=false;
		
		
		try{
			conn = DBUtils.getConnection("lead_management");
			
			String sql = "insert into follow_up(e_id,fdate,fdesc,f_status) values (?,?,?,?)";
			
			pst = DBUtils.getPreparedStatement(sql);
			pst.setInt(1, follow_up.getEnquiry().getEid());
			pst.setString(2, follow_up.getFdate());
			pst.setString(3, follow_up.getF_desc());
			pst.setString(4, follow_up.getF_status());
			
			
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
	public boolean updateEnquiry(Enquiry enquiry){
		boolean updated = false;
		conn = DBUtils.getConnection("lead_management");
		String sql = "update enquiry SET name=?, email=?, phone=?, edesc=?, edate=?, c_id=? WHERE eid=?";
		
		pst = DBUtils.getPreparedStatement(sql);
		try{
			pst.setString(1, enquiry.getName());
			pst.setString(2, enquiry.getEmail());
			pst.setLong(3, enquiry.getPhone());
			pst.setString(4, enquiry.getDesc());
			pst.setString(5, enquiry.getEdate());
			pst.setInt(6, enquiry.getCourse().getCid());
			pst.setInt(7,enquiry.getEid());
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
	
	public boolean updateFollow_up(Follow_Up follow_up){
		boolean updated = false;
		String sql = "update follow_up SET fdate=?, fdesc=?, f_status=? WHERE fid=?";
		conn = DBUtils.getConnection("lead_management");
		pst = DBUtils.getPreparedStatement(sql);
		try{
			
			pst.setString(1, follow_up.getFdate());
			pst.setString(2, follow_up.getF_desc());
			pst.setString(3, follow_up.getF_status());
			pst.setInt(4, follow_up.getFid());
			int r = pst.executeUpdate();
			if(r != 0){
				updated = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		DBUtils.closeResources(rs, pst, stmt, conn);
		return updated;
	}
	









public List<Enquiry> getAllEnquiry(){
	List<Enquiry> enquiryList = new ArrayList<Enquiry>();
	
	conn = DBUtils.getConnection("lead_management");
	
	String sql = "select * from enquiry";
	
	stmt = DBUtils.getSimpleStatement();
	
	try{
		rs = stmt.executeQuery(sql);
		
		Enquiry enquiry = null;
		
		if(rs != null){
			while(rs.next()){
				enquiry = new Enquiry(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),null);
				Course c = new Course();
				c.setCid(rs.getInt(7));
				enquiry.setCourse(c);
				
				enquiryList.add(enquiry);
			}
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	DBUtils.closeResources(rs,pst,stmt,conn);
	
	return enquiryList;
}

public boolean deleteEnquiry(int eid){
	boolean deleted = false;
	conn = DBUtils.getConnection("lead_management");
	String sql = "delete from enquiry WHERE eid="+eid;
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

public boolean deleteFollow_up(int fid){
	boolean deleted = false;
	conn = DBUtils.getConnection("lead_management");
	String sql = "delete from follow_up WHERE fid="+fid;
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

public Enquiry getEnquiry(int eid)

{Enquiry enquiry=null;
	
	String sql = "select * from enquiry WHERE eid="+eid;
conn = DBUtils.getConnection("lead_management");
stmt = DBUtils.getSimpleStatement();
try{
	rs = stmt.executeQuery(sql);
	if(rs != null){
		while(rs.next()){
			enquiry = new Enquiry(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5),rs.getString(6),null);
			Course c = new Course();
			c.setCid(rs.getInt(7));
			
			enquiry.setCourse(c);
		}
	}
}catch(SQLException e){
	e.printStackTrace();
}
DBUtils.closeResources(rs, pst, stmt, conn);

return enquiry;
}

public Follow_Up getFollowup(int fid)

{Follow_Up followup=null;
	
	String sql = "select * from follow_up WHERE fid="+fid;
conn = DBUtils.getConnection("lead_management");
stmt = DBUtils.getSimpleStatement();
try{
	rs = stmt.executeQuery(sql);
	if(rs != null){
		while(rs.next()){
			followup = new Follow_Up(rs.getInt(1),null,rs.getString(3),rs.getString(4),rs.getString(5));
			Enquiry e = new Enquiry();
			e.setEid(rs.getInt(2));
			
			followup.setEnquiry(e);
		}
	}
}catch(SQLException e){
	e.printStackTrace();
}
DBUtils.closeResources(rs, pst, stmt, conn);

return followup;
}

public List<Follow_Up> getAllFollow_Up(){
	List<Follow_Up> followupList = new ArrayList<Follow_Up>();
	
	conn = DBUtils.getConnection("lead_management");
	
	String sql = "select * from follow_up";
	
	stmt = DBUtils.getSimpleStatement();
	
	try{
		rs = stmt.executeQuery(sql);
		
		Follow_Up followup = null;
		
		if(rs != null){
			while(rs.next()){
				followup = new Follow_Up(rs.getInt(1),null,rs.getString(3),rs.getString(4),rs.getString(5));
				Enquiry e = new Enquiry();
				e.setEid(rs.getInt(2));
				
				followup.setEnquiry(e);
				
				followupList.add(followup);
			}
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	DBUtils.closeResources(rs,pst,stmt,conn);
	
	return followupList;
}	

}
