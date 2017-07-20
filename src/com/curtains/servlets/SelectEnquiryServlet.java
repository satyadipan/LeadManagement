package com.curtains.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curtains.bean.Enquiry;
import com.curtains.utils.CounselorUtils;

/**
 * Servlet implementation class SelectEnquiryServlet
 */
@WebServlet("/selectenquiry")
public class SelectEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eid=Integer.parseInt(request.getParameter("e_id"));
		Enquiry enquiry=new Enquiry();
		CounselorUtils cu=new CounselorUtils();
		enquiry=cu.getEnquiry(eid);
		HttpSession session = request.getSession();
		session.setAttribute("enquiry", enquiry);
		response.sendRedirect("updateEnquiry.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
