package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import java.util.regex.*;

import models.*;

public class UpdateUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "user_profile1.jsp";
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		ArrayList<User> users = User.getUserInfo(userId);
		ArrayList<Nation> nations = Nation.getAllNations();
		request.setAttribute("users",users);	
		request.setAttribute("nations",nations);
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}