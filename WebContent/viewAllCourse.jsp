<%@page import="com.curtains.utils.CommonUtils"%>

<%@page import="com.curtains.bean.Course"%>
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
<title>View All Course</title>
</head>
<body>
<div class="table-title">
<center><h3>             All Course</h3></center>
</div>
<table class="table-fill">
<thead>
<tr>
<th class="text-left">Cid</th>
<th class="text-left">Name</th>
<th class="text-left">Duration</th>
<th class="text-left">Fee</th>
<th class="text-left">No of Seats</th>
<th class="text-left">Start Date</th>

</tr>
</thead>
<%CommonUtils cu=new CommonUtils();

List<Course> clist =cu.getAllCourses();

if(!clist.isEmpty()){ 
			for(Course e:clist){
		%>
<tbody class="table-hover">
<tr>
<td class="text-left"><%=e.getCid() %></td>
<td class="text-left"><%=e.getName() %></td>
<td class="text-left"><%=e.getDuration() %></td>
<td class="text-left"><%=e.getFee() %></td>
<td class="text-left"><%=e.getNo_of_seats() %></td>
<td class="text-left"><%=e.getStart_date() %></td>


</tr>
<%}
			}%>
</tbody>
</table>
  
</body>
</html>