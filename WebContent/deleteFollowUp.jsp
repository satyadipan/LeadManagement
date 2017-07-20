<%@page import="com.curtains.bean.User"%>
<%@page import="com.curtains.bean.Follow_Up"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.curtains.bean.Enquiry"%>
<%@page import="java.util.List"%>
<%@page import="com.curtains.utils.CommonUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Delete Follow-Up|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
	
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>

<div class="main-content">

        <!-- You only need this form and the form-basic.css -->
        
         <% Follow_Up f = (Follow_Up)session.getAttribute("followup");%>

        <form class="form-basic" method="POST" action="deleteFollowUp">

            <div class="form-title-row">
                <h1>Update Follow-up</h1>
            </div>
            <div class="form-row">
                <label>
                    <span>Follow_Up Id</span>
                    <input type="text" name="f_id" value="<%=f.getFid()%>" disabled>
                    <input type="hidden" name="fid" value="<%=f.getFid()%>">	
                </label>
            </div>

           <div class="form-row">
                <label>
                    <span>Enquiry Id</span>
                    <input type="text" name="e_id" value="<%=f.getEnquiry().getEid()%>" disabled>
                    <input type="hidden" name="eid" value="<%=f.getEnquiry().getEid()%>">
                </label>
            </div>

			<div class="form-row">
                <label>
                    <span>Status</span>
                   
                    <input type="text" name="fstatus" value="<%=f.getF_status() %>" disabled>
                </label>
            </div>
			
			<div class="form-row">
                <label>
                    <span>Description</span>
                    <textarea  name="fdesc" disabled><%=f.getF_desc()%></textarea>
                </label>
            </div>

            <div class="form-row">
                <label>
                    <span>Date</span>
                    <input type="text" name="fdate" value="<%=f.getFdate()%>" disabled>
                </label>
            </div>
             

            <div class="form-row">
                <button type="submit" name="deletefup" value="Update_Follow-up">Delete Follow-up</button>
            </div>

        </form>

    </div>
</body>
</html>