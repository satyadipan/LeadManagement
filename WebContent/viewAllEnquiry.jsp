<%@page import="com.curtains.bean.Enquiry"%>
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
<title>View All Enquiry</title>
</head>
<body>
<div class="table-title">
<center><h3>             All Enquiry</h3></center>
</div>
<table class="table-fill">
<thead>
<tr>
<th class="text-left">Eid</th>
<th class="text-left">Name</th>
<th class="text-left">Email</th>
<th class="text-left">Phone</th>
<th class="text-left">Description</th>
<th class="text-left">Date</th>
<th class="text-left">CourseId</th>
</tr>
</thead>
<%CounselorUtils cu=new CounselorUtils();

List<Enquiry> enqlist =cu.getAllEnquiry();

if(!enqlist.isEmpty()){ 
			for(Enquiry e:enqlist){
		%>
<tbody class="table-hover">
<tr>
<td class="text-left"><%=e.getEid() %></td>
<td class="text-left"><%=e.getName() %></td>
<td class="text-left"><%=e.getEmail() %></td>
<td class="text-left"><%=e.getPhone() %></td>
<td class="text-left"><%=e.getDesc() %></td>
<td class="text-left"><%=e.getEdate() %></td>
<td class="text-left"><%=e.getCourse().getCid() %></td>

</tr>
<%}
			}%>
</tbody>
</table>
  
</body>
</html>