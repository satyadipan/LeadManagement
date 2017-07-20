package com.curtains.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curtains.utils.ManagerUtils;

/**
 * Servlet implementation class DeleteCounselorServlet
 */
@WebServlet("/deleteCounselor")
public class DeleteCounselorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		ManagerUtils mu=new ManagerUtils();
		if(mu.deleteCounselor(uid))
		{request.setAttribute("action", "Remove Counselor");
		request.setAttribute("result", "Successfully removed");
		RequestDispatcher dis = request.getRequestDispatcher("confirm.jsp");
		dis.forward(request, response);
			
		}
		else
		{request.setAttribute("action", "Remove Counselor");
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
