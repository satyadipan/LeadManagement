<%@page import="com.curtains.bean.Follow_Up"%>
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
<title>View All Follow_Up</title>
</head>
<body>
<div class="table-title">
<center><h3>             All Follow_Up</h3></center>
</div>
<table class="table-fill">
<thead>
<tr>
<th class="text-left">Fid</th>
<th class="text-left">Follow_UpId</th>
<th class="text-left">FollowUp Date</th>
<th class="text-left">FollowUp Description</th>
<th class="text-left">FollowUp Status</th>

</tr>
</thead>
<%CounselorUtils cu=new CounselorUtils();

List<Follow_Up> enqlist =cu.getAllFollow_Up();

if(!enqlist.isEmpty()){ 
			for(Follow_Up e:enqlist){
		%>
<tbody class="table-hover">
<tr>
<td class="text-left"><%=e.getFid() %></td>
<td class="text-left"><%=e.getEnquiry().getEid() %></td>
<td class="text-left"><%=e.getFdate() %></td>
<td class="text-left"><%=e.getF_desc() %></td>
<td class="text-left"><%=e.getF_status() %></td>


</tr>
<%}
			}%>
</tbody>
</table>
  
</body>
</html>