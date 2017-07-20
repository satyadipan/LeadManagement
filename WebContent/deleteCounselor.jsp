<%@page import="com.curtains.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Delete Counselor|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>
	<header>
		<h1>Lead Management System</h1>
        
    </header>

   


    <div class="main-content">

        <!-- You only need this form and the form-basic.css -->
		<%User u = (User)session.getAttribute("counselor"); %>
        <form class="form-basic" method="POST" action="deleteCounselor">

            <div class="form-title-row">
                <h1>View/Delete Counselor</h1>
            </div>
			<div class="form-row">
                <label>
                    <span>User Id</span>
                    <input type="text" name="u_id" value="<%=u.getUid()%>" disabled>
                    <input type="hidden" name="uid" value="<%=u.getUid()%>" >
                </label>
            </div>
            <div class="form-row">
                <label>
                    <span>Full name</span>
                    <input type="text" name="name" value="<%=u.getUname()%>" disabled>
                </label>
            </div>

            <div class="form-row">
                <label>
                    <span>Email</span>
                    <input type="email" name="email" value="<%=u.getUemail()%>" disabled>
                </label>
            </div>
			
			
			<div class="form-row">
                <label>
                    <span>Phone No</span>
                    <input type="number" name="phone" value="<%=u.getUphone()%>" disabled>
                </label>
            </div>
			

            

            <div class="form-row">
                <button type="submit" name="deletecounselor" value="delete_counselor">Delete Counselor</button>
            </div>

        </form>

    </div>
</body>
</html>