<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Registration|Lead Management</title>

	<link rel="stylesheet" href="assets/demo.css">
	<link rel="stylesheet" href="assets/form-basic.css">
</head>
<body>
	<header>
		<h1>Lead Management System</h1>
        
    </header>

    <ul>
        
        <li><a href="#" class="active">Register</a></li>
        <li><a href="login.jsp">Login</a></li>
        <li><a href="aboutUs.jsp">About Us</a></li>
        
    </ul>


    <div class="main-content">

        <!-- You only need this form and the form-basic.css -->

        <form class="form-basic" method="POST" action="registerProcess">

            <div class="form-title-row">
                <h1>Registration</h1>
            </div>

            <div class="form-row">
                <label>
                    <span>Full name</span>
                    <input type="text" name="name">
                </label>
            </div>

            <div class="form-row">
                <label>
                    <span>Email</span>
                    <input type="email" name="email">
                </label>
            </div>
			<div class="form-row">
                <label>
                    <span>Password</span>
                    <input type="password" name="password">
                </label>
            </div>
			<div class="form-row">
                <label>
                    <span>Confirm Password</span>
                    <input type="password" name="password1">
                </label>
            </div>
			<div class="form-row">
                <label>
                    <span>Phone No</span>
                    <input type="number" name="phone">
                </label>
            </div>
			

            <div class="form-row">
                <label>
                    <span>Role</span>
                    <select name="role">
                        <option value="Counselor">Counselor</option>
                        <option value="Manager">Manager</option>
                        
                    </select>
                </label>
            </div>

            <div class="form-row">
                <button type="submit" name="sbmt" value="User_register">Register</button>
            </div>

        </form>

    </div>
</body>
</html>