<%@page import="com.curtains.bean.User"%>
<%@page import="java.util.List"%>
<%@page import="com.curtains.utils.ManagerUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Select Counselor|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>
 <form class="form-basic" method="POST" action="selectCounselor">
   <div class="form-row">
               <label>
                    <span>Counselor</span>
                    <%ManagerUtils mu=new ManagerUtils();
                    List<User> ulist = mu.getAllCounselor(); %>
                    <select name="uid">
                    
                    <%
									if(!ulist.isEmpty()){
				
										for(User u : ulist){
								%>
                        <option value="<%=u.getUid()%>"><%=u.getUid()%>. <%=u.getUname() %></option>
                        
                        <%}
										}%>
                    </select>
                </label>
            </div>
            

			

            <div class="form-row">
                <button type="submit" name="selectcounselor" value="Select_Counselor">Select Counselor</button>
            </div>

        </form>

    </div>
</body>
</html>