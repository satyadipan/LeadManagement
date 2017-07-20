<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Login|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
<header>
		<h1>Lead Management System</h1>
        
    </header>

    <ul>
        
        <li><a href="userRegister.jsp">Register</a></li>
        <li><a href="login.jsp"  class="active">Login</a></li>
        <li><a href="aboutUs.jsp">About Us</a></li>
        
    </ul>


    <div class="main-content">

        <!-- You only need this form and the form-basic.css -->

        <form class="form-basic" method="POST" action="login">

            <div class="form-title-row">
                <h1>Login</h1>
            </div>

         

            <div class="form-row">
                <label>
                    <span>Email</span>
                    <input type="email" name="loginemail">
                </label>
            </div>
			<div class="form-row">
                <label>
                    <span>Password</span>
                    <input type="password" name="loginpassword">
                </label>
            </div>
			
			

            <div class="form-row">
                <label>
                    <span>Role</span>
                    <select name="loginrole">
                        <option value="Counselor">Counselor</option>
                        <option value="Manager">Manager</option>
                        
                    </select>
                </label>
            </div>

            <div class="form-row">
                <button type="submit" name="login" value="Login">Login</button>
            </div>

        </form>

    </div>
</body>
</html>