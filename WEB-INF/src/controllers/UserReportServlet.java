package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.*;

import models.*;
public class UserReportServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "user_reports.jsp";
		ArrayList<User> reports = User.getUserReport();
		request.setAttribute("reports",reports);
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}