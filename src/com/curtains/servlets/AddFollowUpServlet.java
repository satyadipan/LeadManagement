package com.curtains.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curtains.bean.Enquiry;
import com.curtains.bean.Follow_Up;
import com.curtains.utils.CounselorUtils;

/**
 * Servlet implementation class AddFollowUp
 */
@WebServlet("/addFollowup")
public class AddFollowUpServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eid=Integer.parseInt(request.getParameter("e_id"));
		String fdesc = request.getParameter("fdesc");
		String date = request.getParameter("fdate");
		String f_status = request.getParameter("f_status");
		Enquiry enquiry=new Enquiry();
		enquiry.setEid(eid);
		Follow_Up follow_up=new Follow_Up(0,enquiry,date,fdesc,f_status);
		
		CounselorUtils cu=new CounselorUtils();
		if(cu.addFollow_up(follow_up)){
			request.setAttribute("action", "Add FollowUp");
			request.setAttribute("result", "Successfully Added");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}
		else{
			request.setAttribute("action", "Add FollowUp");
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
