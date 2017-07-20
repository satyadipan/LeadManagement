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
 * Servlet implementation class UpdateCourseServlet
 */
@WebServlet("/updateCourse")
public class UpdateCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		int duration=Integer.parseInt(request.getParameter("duration"));
		int fee=Integer.parseInt(request.getParameter("fee"));
		int noofseats=Integer.parseInt(request.getParameter("noofseats"));
		String date = request.getParameter("date");
		Course course=new Course(cid,name,duration,fee,noofseats,date);
		ManagerUtils mu=new ManagerUtils();
		if(mu.updateCourse(course))
			{request.setAttribute("action", "Course Updation");
			request.setAttribute("result", "Success");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
	}
	else{
		request.setAttribute("action", "Course Updation");
		request.setAttribute("result", "Failed");
		RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
		dis.forward(request, response);
	//System.out.println(enquiry.getName()+enquiry.getCourse().getCid()+enquiry.getDesc()+enquiry.getEdate()+enquiry.getEid()+enquiry.getEmail()+enquiry.getPhone());
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
