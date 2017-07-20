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
import com.curtains.bean.Follow_Up;
import com.curtains.utils.CounselorUtils;

/**
 * Servlet implementation class UpdateFollowUp
 */
@WebServlet("/updateFollowup")
public class UpdateFollowUpServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid=Integer.parseInt(request.getParameter("fid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		String fdesc = request.getParameter("fdesc");
		String date = request.getParameter("fdate");
		String fstatus = request.getParameter("fstatus");
		Enquiry e=new Enquiry();
		e.setEid(eid);
		
		Follow_Up follow_up= new Follow_Up(fid,e,date,fdesc,fstatus);
		
		
		CounselorUtils cu=new CounselorUtils();
		if(cu.updateFollow_up(follow_up)){
			request.setAttribute("action", "Follow Up updation");
			request.setAttribute("result", "Successfully updated");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}
		else{
			request.setAttribute("action", "Follow Up updation");
			request.setAttribute("result", "Failed");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		//System.out.println(enquiry.getName()+enquiry.getCourse().getCid()+enquiry.getDesc()+enquiry.getEdate()+enquiry.getEid()+enquiry.getEmail()+enquiry.getPhone());
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
