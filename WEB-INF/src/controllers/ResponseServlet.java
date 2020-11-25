package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;

import models.*;
import java.util.ArrayList;

public class ResponseServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		int question_id = Integer.parseInt(request.getParameter("question_id"));
		String nextPage = "response.jsp";
		User user = (User)session.getAttribute("user");
		if(user==null){
			nextPage = "login.jsp";
		}else{
			nextPage = "response.jsp";
		}
		
		ArrayList<Question> question = Question.getQuestionInfo(question_id);
		request.setAttribute("questions",question);
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}