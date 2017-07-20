<%@page import="com.curtains.bean.User"%>
<%@page import="com.curtains.utils.ManagerUtils"%>

<%@page import="java.util.List"%>
<%@page import="com.curtains.utils.CounselorUtils"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" href="assets/style.css">
 <meta name="viewport" content="initial-scale=1.0; maximum-scale=1.0; width=device-width;">
<title>View All Counselor</title>
</head>
<body>
<div class="table-title">
<center><h3>             All Counselor</h3></center>
</div>
<table class="table-fill">
<thead>
<tr>
<th class="text-left">Uid</th>
<th class="text-left">Name</th>
<th class="text-left">Email</th>
<th class="text-left">Phone</th>
<th class="text-left">User Role</th>

</tr>
</thead>
<%ManagerUtils cu=new ManagerUtils();

List<User> ulist =cu.getAllCounselor();

if(!ulist.isEmpty()){ 
			for(User u:ulist){
		%>
<tbody class="table-hover">
<tr>
<td class="text-left"><%=u.getUid() %></td>
<td class="text-left"><%=u.getUname() %></td>
<td class="text-left"><%=u.getUemail() %></td>
<td class="text-left"><%=u.getUphone() %></td>
<td class="text-left"><%=u.getUrole() %></td>


</tr>
<%}
			}%>
</tbody>
</table>
  
</body>
</html>