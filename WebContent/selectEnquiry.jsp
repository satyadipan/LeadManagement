<%@page import="com.curtains.bean.User"%>
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

	<title>Select Enquiry|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>
 <form class="form-basic" method="POST" action="selectenquiry">
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
                <button type="submit" name="selectenquiry" value="Select_Enquiry">Select Enquiry</button>
            </div>

        </form>

    </div>
</body>
</html>