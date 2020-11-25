package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;

import models.*;

public class SubmitQuestionServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextPage = "login.jsp";
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			String questionTitle = request.getParameter("q_title");
			String questionDesc = request.getParameter("question");
			Integer topicId = Integer.parseInt(request.getParameter("topic_id"));
			String topic = request.getParameter("topic");
			Question question = new Question();
			question.setUser(user);
			System.out.println(user.getUserId());
			question.setPostType(PostType.QUESTION);
			question.setPost(questionDesc);
			question.setTitle(questionTitle);
			question.setTopic(new Topic(topicId));

			if(question.saveQuestion()){
				question.increaseQuestionCount();
				Topic.increaseQuestionCount(topicId);
				nextPage = "topics_question.do";
			}else{
				nextPage = "post_question.jsp";
			}


		}
	
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}