<%@page import="com.curtains.bean.User"%>
<%@page import="com.curtains.bean.Course"%>
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

	<title>Select Course|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>
 <form class="form-basic" method="POST" action="selectCourse">
   <div class="form-row">
               <label>
                    <span>Course</span>
                    <%CommonUtils u=new CommonUtils();
                    List<Course> clist =u.getAllCourses() ; %>
                    <select name="cid">
                    
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
                <button type="submit" name="selectenquiry" value="Select_Course">Select Course</button>
            </div>

        </form>

    </div>
</body>
</html>