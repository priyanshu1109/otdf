package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;

import models.*;
import java.util.ArrayList;

public class UserProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "user_profile.jsp";
		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		ArrayList<User> users = User.getUserInfo(userId);
		//ArrayList<Nation> nations = Nation.getAllNations();
		request.setAttribute("users",users);
		//request.setAttribute("nations",nations);

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}