<%@page import="com.curtains.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
<title>Information | Lead Management</title>
</head>
<% 

	
	String action = (String)request.getAttribute("action");
	String result = (String)request.getAttribute("result");
%>
<body>

	
	<form class="form-basic" method="POST" action="selectCourse">
  	<center><h1>Information Page</h1></center>
	<center>
	</br>
		Action : <b><%=action %></b></br></br>
		Result : <b><%=result %></b>
	</center><br>
            </br>
	<a href="counselorHome.jsp"> Home</a>
			<!--  <a href="managerHome.jsp">Manager Home</a>-->

           

        </form>

    </div>
</body>
</html>