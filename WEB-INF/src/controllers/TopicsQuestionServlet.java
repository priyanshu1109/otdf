package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;

import models.*;
import java.util.ArrayList;

public class TopicsQuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		String nextPage = "topic_questions.jsp";
		int topicId = Integer.parseInt(request.getParameter("topic_id"));//"topic_id" should match with "topic_id" of SubmitQuestionServlet while getting it

		ArrayList<Question> questions = Question.collectQuestions(topicId);
		request.setAttribute("questions",questions);

		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}