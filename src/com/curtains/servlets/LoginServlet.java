package com.curtains.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curtains.utils.*;
import com.curtains.bean.*;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("loginemail");
		String password = request.getParameter("loginpassword");
		String role = request.getParameter("loginrole");
		CommonUtils u = new CommonUtils();
		User user = u.validateUser(email, password, role);
		if(user != null && user.getUrole().equals("Counselor")){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("counselorHome.jsp");
		}else if(user != null && user.getUrole().equals("Manager")){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("managerHome.jsp");
		}
		else{
			request.setAttribute("action", "Login");
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
