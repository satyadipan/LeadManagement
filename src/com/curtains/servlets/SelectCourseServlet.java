package com.curtains.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curtains.bean.Course;
import com.curtains.bean.Enquiry;
import com.curtains.utils.CommonUtils;


/**
 * Servlet implementation class SelectCourseServlet
 */
@WebServlet("/selectCourse")
public class SelectCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid=Integer.parseInt(request.getParameter("cid"));
		Course course=new Course();
		CommonUtils cu=new CommonUtils();
		course=cu.getCourse(cid);
		HttpSession session = request.getSession();
		session.setAttribute("course", course);
		response.sendRedirect("updateCourse.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
