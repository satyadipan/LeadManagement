<%@page import="com.curtains.bean.User"%>
<%@page import="com.curtains.bean.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.curtains.bean.Enquiry"%>
<%@page import="com.curtains.utils.CommonUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Update Enquiry|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>
<div class="main-content">

        <!-- You only need this form and the form-basic.css -->
<%
	
	
	Enquiry e = (Enquiry)session.getAttribute("enquiry");
%>
        <form class="form-basic" method="POST" action="updateEnquiry">

            <div class="form-title-row">
                <h1>Update Enquiry</h1>
            </div>
            
            <div class="form-row">
                <label>
                    <span>Employee Id</span>
                    <input type="text" name="e_id" value="<%=e.getEid()%>" disabled>
                    <input type="hidden" name="eid" value="<%=e.getEid()%>">	
                </label>
            </div>

            <div class="form-row">
                <label>
                    <span>Full name</span>
                    <input type="text" name="name" value="<%=e.getName() %>">
                </label>
            </div>

            <div class="form-row">
                <label>
                    <span>Email</span>
                    <input type="email" name="email" value="<%=e.getEmail()%>">
                </label>
            </div>

			<div class="form-row">
                <label>
                    <span>Phone No</span>
                    <input type="number" name="phone" value="<%=e.getPhone()%>">
                </label>
            </div>
			
			<div class="form-row">
                <label>
                    <span>Description</span>
                    <textarea  name="edesc" ><%=e.getDesc()%></textarea>
                </label>
            </div>
            
            <div class="form-row">
                <label>
                    <span>Date</span>
                    <input type="text" name="edate" value="<%=e.getEdate()%>">
                </label>
            </div>
             <div class="form-row">
                <label>
                    <span>Course</span>
                    <%CommonUtils u=new CommonUtils();
                    List<Course> clist = u.getAllCourses(); %>
                    <select name="course">
                    
                    <%
									if(!clist.isEmpty()){
				
										for(Course c : clist){
								%>
                        <option value="<%=c.getCid()%>"><%=c.getCid()%>. <%=c.getName() %></option>
                        
                        <%}
										}%>
                    </select>
                </label>
            </div>

            <div class="form-row">
                <button type="submit" name="updateenq" value="Update_Enquiry">Update Enquiry</button>
            </div>
            

        </form>

    </div>
</body>
</html>