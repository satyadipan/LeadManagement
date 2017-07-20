package com.curtains.bean;

public class Course {
private int cid;
private String name;
private int duration;
private int fee;
private int no_of_seats;
private String start_date;

public Course(){}

public Course(int cid, String name, int duration, int fee, int no_of_seats, String start_date) {
	super();
	this.cid = cid;
	this.name = name;
	this.duration = duration;
	this.fee = fee;
	this.no_of_seats = no_of_seats;
	this.start_date = start_date;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
public int getFee() {
	return fee;
}
public void setFee(int fee) {
	this.fee = fee;
}
public int getNo_of_seats() {
	return no_of_seats;
}
public void setNo_of_seats(int no_of_seats) {
	this.no_of_seats = no_of_seats;
}
public String getStart_date() {
	return start_date;
}
public void setStart_date(String start_date) {
	this.start_date = start_date;
}
@Override
public String toString() {
	return "Course [name=" + name + "]";
}
 
}
