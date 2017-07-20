<%@page import="com.curtains.utils.CounselorUtils"%>
<%@page import="com.curtains.bean.User"%>
<%@page import="com.curtains.bean.Follow_Up"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Select Follow_Up|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>
 <form class="form-basic" method="POST" action="selectfollowup">
   <div class="form-row">
               <label>
                    <span>Follow_Up</span>
                    <%CounselorUtils u=new CounselorUtils();
                    List<Follow_Up> flist = u.getAllFollow_Up(); %>
                    <select name="f_id">
                    
                    <%
									if(!flist.isEmpty()){
				
										for(Follow_Up f : flist){
								%>
                        <option value="<%=f.getFid()%>"><%=f.getFid()%>. <%=u.getEnquiry(f.getEnquiry().getEid()).getName() %></option>
                        
                        <%}
										}%>
                    </select>
                </label>
            </div>
            

			

            <div class="form-row">
                <button type="submit" name="selectenquiry" value="Select_Follow_Up">Select Follow_Up</button>
            </div>

        </form>

    </div>
</body>
</html>