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
 * Servlet implementation class EditEnquiry
 */
@WebServlet("/updateEnquiry")
public class EditEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eid=Integer.parseInt(request.getParameter("eid"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String edesc = request.getParameter("edesc");
		String date = request.getParameter("edate");
		long phone = Long.parseLong(request.getParameter("phone"));
		int cid=Integer.parseInt(request.getParameter("course"));
		
		Course c=new Course();
		c.setCid(cid);
		Enquiry enquiry= new Enquiry(eid,name,email,phone,edesc,date,c);
		
		
		CounselorUtils cu=new CounselorUtils();
		if(cu.updateEnquiry(enquiry)){
			request.setAttribute("action", "Edit Enquiry");
			request.setAttribute("result", "Successfully edited");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}
		else{
			request.setAttribute("action", "Edit Enquiry");
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
