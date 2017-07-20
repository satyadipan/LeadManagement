package com.curtains.bean;

public class Enquiry {
private int eid;
private String name;
private String email;
private long phone;
private String desc;
private String edate;
private Course course;
public Enquiry(int eid, String name, String email, long phone, String desc, String edate, Course course) {
	super();
	this.eid = eid;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.desc = desc;
	this.edate = edate;
	this.course = course;
}
public Enquiry()
{
	}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}
public String getEdate() {
	return edate;
}
public void setEdate(String edate) {
	this.edate = edate;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
@Override
public String toString() {
	return "Enquiry [name=" + name + ", course=" + course.getName() + "]";
}

}
