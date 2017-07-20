<%@page import="com.curtains.bean.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Add Course|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>
<div class="main-content">

        <!-- You only need this form and the form-basic.css -->

        <form class="form-basic" method="POST" action="addCourse">

            <div class="form-title-row">
                <h1>Add Course</h1>
            </div>

            <div class="form-row">
                <label>
                    <span>Course Name</span>
                    <input type="text" name="name">
                </label>
            </div>

            <div class="form-row">
                <label>
                    <span>Duration</span>
                    <input type="number" name="duration">
                </label>
            </div>

			<div class="form-row">
                <label>
                    <span>fee</span>
                    <input type="number" name="fee">
                </label>
            </div>
			
			<div class="form-row">
                <label>
                    <span>No of Seats</span>
                    <input type="number" name="noofseats">
                </label>
            </div>
            <% Date myDate = new Date();
           

            SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Format the date to Strings
            String dmy = mdyFormat.format(myDate);%>
            <div class="form-row">
                <label>
                    <span>Date</span>
                    <input type="text" name="date" value="<%=dmy%>">
                </label>
            </div>
            

            <div class="form-row">
                <button type="submit" name="addcourse" value="Add_Course">Add Course</button>
            </div>

        </form>

    </div>
</body>
</html>