package com.curtains.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curtains.bean.Course;
import com.curtains.utils.ManagerUtils;

/**
 * Servlet implementation class AddCourseServlet
 */
@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		
		
		int duration=Integer.parseInt(request.getParameter("duration"));
		int fee=Integer.parseInt(request.getParameter("fee"));
		int noofseats=Integer.parseInt(request.getParameter("noofseats"));
		String date = request.getParameter("date");
		Course course=new Course(0,name,duration,fee,noofseats,date);
		ManagerUtils mu=new ManagerUtils();
		if(mu.addCourse(course)){
			request.setAttribute("action", "Add Course");
			request.setAttribute("result", "Successfully Added");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}
		else{
			request.setAttribute("action", "Add Course");
			request.setAttribute("result", "Failed");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
