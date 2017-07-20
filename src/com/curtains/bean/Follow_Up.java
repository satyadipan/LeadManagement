package com.curtains.bean;

public class Follow_Up {
private int fid;
private int e_id;
private String fdate;
private String f_desc;
private String f_status;
private Enquiry enquiry;
public Follow_Up()
{}
public Follow_Up(int fid, Enquiry enquiry, String fdate, String f_desc, String f_status) {
	super();
	this.fid = fid;
	this.fdate = fdate;
	this.f_desc = f_desc;
	this.f_status = f_status;
	this.enquiry = enquiry;
}
public int getFid() {
	return fid;
}
public void setFid(int fid) {
	this.fid = fid;
}

public String getFdate() {
	return fdate;
}
public void setFdate(String fdate) {
	this.fdate = fdate;
}
public String getF_desc() {
	return f_desc;
}
public void setF_desc(String f_desc) {
	this.f_desc = f_desc;
}
public String getF_status() {
	return f_status;
}
public void setF_status(String f_status) {
	this.f_status = f_status;
}
public Enquiry getEnquiry() {
	return enquiry;
}
public void setEnquiry(Enquiry enquiry) {
	this.enquiry = enquiry;
}
@Override
public String toString() {
	return "Follow_Up [fid=" + fid + ", enquiry=" + enquiry.getEid() + "]";
}

}
