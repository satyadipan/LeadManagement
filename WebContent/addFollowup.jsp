<%@page import="com.curtains.bean.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.curtains.bean.Enquiry"%>
<%@page import="java.util.List"%>
<%@page import="com.curtains.utils.CommonUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Add Follow-Up|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>
<div class="main-content">

        <!-- You only need this form and the form-basic.css -->

        <form class="form-basic" method="POST" action="addFollowup">

            <div class="form-title-row">
                <h1>Add Follow-up</h1>
            </div>

           <div class="form-row">
                <label>
                    <span>Enquiry</span>
                    <%CommonUtils u=new CommonUtils();
                    List<Enquiry> elist = u.getAllEnquiry(); %>
                    <select name="e_id">
                    
                    <%
									if(!elist.isEmpty()){
				
										for(Enquiry e : elist){
								%>
                        <option value="<%=e.getEid()%>"><%=e.getEid()%>. <%=e.getName() %></option>
                        
                        <%}
										}%>
                    </select>
                </label>
            </div>
            

			<div class="form-row">
                <label>
                    <span>Status</span>
                    <input type="text" name="f_status">
                </label>
            </div>
			
			<div class="form-row">
                <label>
                    <span>Description</span>
                    <textarea  name="fdesc"></textarea>
                </label>
            </div>
            <% Date myDate = new Date();
           

            SimpleDateFormat mdyFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Format the date to Strings
            String dmy = mdyFormat.format(myDate);%>
            <div class="form-row">
                <label>
                    <span>Date</span>
                    <input type="text" name="fdate" value="<%=dmy%>">
                </label>
            </div>
             

            <div class="form-row">
                <button type="submit" name="addfup" value="Add_Follow-up">Add Follow-up</button>
            </div>

        </form>

    </div>
</body>
</html>