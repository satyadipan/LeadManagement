package com.curtains.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curtains.bean.Course;
import com.curtains.bean.Enquiry;
import com.curtains.utils.CounselorUtils;



/**
 * Servlet implementation class AddEnquiry
 */
@WebServlet("/addEnquiry")
public class AddEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String edesc = request.getParameter("edesc");
		String date = request.getParameter("edate");
		long phone = Long.parseLong(request.getParameter("phone"));
		int cid=Integer.parseInt(request.getParameter("course"));
		Course c=new Course();
		c.setCid(cid);
		Enquiry enquiry= new Enquiry(0,name,email,phone,edesc,date,c);
		
		
		CounselorUtils cu=new CounselorUtils();
		if(cu.addEnquiry(enquiry)){
			request.setAttribute("action", "Add Enquiry");
			request.setAttribute("result", "Successfully Added");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}
		else{
			request.setAttribute("action", "Add Enquiry");
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
