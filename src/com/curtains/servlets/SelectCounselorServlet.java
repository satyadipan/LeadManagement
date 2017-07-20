package com.curtains.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curtains.bean.Course;
import com.curtains.bean.User;
import com.curtains.utils.CommonUtils;
import com.curtains.utils.ManagerUtils;

/**
 * Servlet implementation class SelectCounselorServlet
 */
@WebServlet("/selectCounselor")
public class SelectCounselorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int uid=Integer.parseInt(request.getParameter("uid"));
		User user=new User();
		ManagerUtils mu=new ManagerUtils();
		user=mu.getCounselor(uid);
		HttpSession session = request.getSession();
		session.setAttribute("counselor", user);
		response.sendRedirect("deleteCounselor.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
