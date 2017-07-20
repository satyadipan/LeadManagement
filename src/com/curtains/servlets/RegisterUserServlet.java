package com.curtains.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curtains.bean.User;
import com.curtains.utils.ManagerUtils;


@WebServlet("/registerProcess")
public class RegisterUserServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		long phone = Long.parseLong(request.getParameter("phone"));
		
		
		User usernw = new User(0,name,email,password,phone,role);
		
		
		ManagerUtils mu = new ManagerUtils();
		if(mu.addUser(usernw)){
			request.setAttribute("action", "UserRegistration");
			request.setAttribute("result", "Successfully Registered");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}else{
			request.setAttribute("action", "UserRegistration");
			request.setAttribute("result", "Failed");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
