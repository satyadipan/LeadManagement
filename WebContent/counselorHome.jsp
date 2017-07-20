<%@page import="com.curtains.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Counselor Home</title>
</head>
<body class="w3-theme-l5">
	<% User user = (User)session.getAttribute("user");
	if(user == null)
		response.sendRedirect("login.jsp");%>


<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="counselorHome.jsp" class="w3-bar-item w3-button w3-padding-large w3-theme-d4"><i class="fa fa-home w3-margin-right"></i>Home</a>

  <a href="logout" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white"><i class="fa fa-sign-out w3-margin-right"></i>Logout</a>
 </div>
</div>



<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:800px;margin-top:100px">    
  <!-- The Grid -->
  <div class="w3-row">
    <!-- Left Column -->
    
      <!-- Profile -->
      <div class="w3-card-2 w3-round ">
        <div class="w3-container">
         <h4 class="w3-center">Counselor</h4>
         <p class="w3-center"><img src="assets/counselor.png" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
         <hr>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> Counselor</p>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> <%=user.getUname() %></p>
         <p><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> <%=user.getUemail() %></p>
         <p><i class="fa fa-phone fa-fw w3-margin-right w3-text-theme"></i><%=user.getUphone() %></p>
        </div>
      </div>
      <br>
      
      <!-- Accordion -->
      <div class="w3-card-2 w3-round">
        <div class="w3-white">
          <a href="addEnquiry.jsp" style="text-decoration:none"><button  class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-circle-o-notch fa-fw w3-margin-right"></i>Add Enquiry</button></a>
          
          <a href="selectEnquiry.jsp" style="text-decoration:none"><button  class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>Edit Enquiry</button></a>
      
          
          <a href="selectEnquirytoDelete.jsp" style="text-decoration:none"><button  class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>Delete Enquiry</button></a>
         <a href="addFollowup.jsp" style="text-decoration:none"><button  class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>Add Follow-up</button></a>
          <a href="selectFollowup.jsp" style="text-decoration:none"><button class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-users fa-fw w3-margin-right"></i>Edit Follow-up</button></a>
          <a href="selectFollowuptoDelete.jsp" style="text-decoration:none"><button  class="w3-button w3-block w3-theme-l1 w3-left-align"><i class="fa fa-calendar-check-o fa-fw w3-margin-right"></i>Delete Follow-up</button></a>
  
      </div>
     
         
    </div>
    
    
    
    

    </div>
    
  <!-- End Grid -->
  
  
<!-- End Page Container -->

<br>

<!-- Footer -->
<footer class="w3-container w3-theme-d3 w3-padding-16">
  <center><h5>Curtains.inc</h5></center>
</footer>

<!--<footer class="w3-container w3-theme-d5">
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer> -->
 
<script>
// Accordion
function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-theme-d1";
    } else { 
        x.className = x.className.replace("w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-theme-d1", "");
    }
}

// Used to toggle the menu on smaller screens when clicking on the menu button
function openNav() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
</script>

</body>
</html>