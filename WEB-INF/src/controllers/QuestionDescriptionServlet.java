package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

import java.util.regex.*;

import models.*;

public class QuestionDescriptionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String nextPage = "question_description.jsp";
		
		if(user!=null){
			int user_id = user.getUserId();
			ArrayList<Actions> liked_by = Actions.collectLike(user_id,post_id);
			if(liked_by.size()==0){
			request.setAttribute("liked",0);
			}else{
			request.setAttribute("liked",1);
			}
		}

		int question_id = Integer.parseInt(request.getParameter("question_id"));

		ArrayList<Question> question = Question.getQuestionInfo(question_id);
		ArrayList<Response> response1 = Response.getResponses(question_id);
		
		request.setAttribute("questions",question);
		request.setAttribute("responses",response1);
		request.setAttribute("user",user);
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}