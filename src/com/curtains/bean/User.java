package com.curtains.bean;

public class User {
private int uid;
private String uname;
private String uemail;
private String upassword;
private long uphone;
private String urole;
public User()
{}
public User(int uid, String uname, String uemail, String upassword, long uphone, String urole) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.uemail = uemail;
	this.upassword = upassword;
	this.uphone = uphone;
	this.urole = urole;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getUemail() {
	return uemail;
}
public void setUemail(String uemail) {
	this.uemail = uemail;
}
public String getUpassword() {
	return upassword;
}
public void setUpassword(String upassword) {
	this.upassword = upassword;
}
public long getUphone() {
	return uphone;
}
public void setUphone(long uphone) {
	this.uphone = uphone;
}
public String getUrole() {
	return urole;
}
public void setUrole(String urole) {
	this.urole = urole;
}
@Override
public String toString() {
	return "User [uname=" + uname + "]";
}

}
