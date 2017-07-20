package com.curtains.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curtains.utils.CounselorUtils;

/**
 * Servlet implementation class DeleteFollowUp
 */
@WebServlet("/deleteFollowUp")
public class DeleteFollowUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid=Integer.parseInt(request.getParameter("fid"));
		CounselorUtils cu=new CounselorUtils();
		if(cu.deleteFollow_up(fid)){
			request.setAttribute("action", "FollowUp Deletion");
			request.setAttribute("result", "Successfully Deleted");
			RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
			dis.forward(request, response);
		}
		else{
			request.setAttribute("action", "FollowUp Deletion");
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
