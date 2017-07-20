package com.curtains.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curtains.bean.Enquiry;
import com.curtains.bean.Follow_Up;
import com.curtains.utils.CounselorUtils;

/**
 * Servlet implementation class SelectFollowUpServlet
 */
@WebServlet("/selectfollowup")
public class SelectFollowUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fid=Integer.parseInt(request.getParameter("f_id"));
		Follow_Up followup=new Follow_Up();
		CounselorUtils cu=new CounselorUtils();
		followup=cu.getFollowup(fid);
		HttpSession session = request.getSession();
		session.setAttribute("followup", followup);
		response.sendRedirect("updateFollowup.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
