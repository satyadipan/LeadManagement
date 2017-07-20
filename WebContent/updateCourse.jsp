<%@page import="com.curtains.bean.Course"%>
<%@page import="com.curtains.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Update Course|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
<% User user = (User)session.getAttribute("user");
	if(user == null )
		response.sendRedirect("login.jsp");%>
<div class="main-content">

        <!-- You only need this form and the form-basic.css -->
<%Course c = (Course)session.getAttribute("course"); %>
        <form class="form-basic" method="POST" action="updateCourse">

            <div class="form-title-row">
                <h1>Update Course</h1>
            </div>
			 <div class="form-row">
                <label>
                    <span>Course Id</span>
                    <input type="text" name="c_id" value="<%=c.getCid()%>" disabled>
                    <input type="hidden" name="cid" value="<%=c.getCid()%>">
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Course Name</span>
                    <input type="text" name="name" value="<%=c.getName() %>">
                </label>
            </div>

            <div class="form-row">
                <label>
                    <span>Duration</span>
                    <input type="number" name="duration" value="<%=c.getDuration()%>">
                </label>
            </div>

			<div class="form-row">
                <label>
                    <span>fee</span>
                    <input type="number" name="fee"value="<%=c.getFee() %>">
                </label>
            </div>
			
			<div class="form-row">
                <label>
                    <span>No of Seats</span>
                    <input type="number" name="noofseats" value="<%=c.getNo_of_seats()%>">
                </label>
            </div>
            
            <div class="form-row">
                <label>
                    <span>Date</span>
                    <input type="text" name="date" value="<%=c.getStart_date()%>">
                </label>
            </div>
            

            <div class="form-row">
                <button type="submit" name="updatecourse" value="Update_Course">Update Course</button>
            </div>

        </form>

    </div>
</body>
</html>