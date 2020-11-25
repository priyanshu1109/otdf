package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;

import models.*;

public class PostQuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextPage = "login.jsp";
		User user = (User)session.getAttribute("user");
		if(user==null){
			nextPage = "login.jsp";
		}else{
			nextPage = "post_question.jsp";
		}
		
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}