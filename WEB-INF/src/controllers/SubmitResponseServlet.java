package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;

import models.*;

public class SubmitResponseServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextPage = "login.jsp";
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			String responseDesc = request.getParameter("response");
			Integer questionId = Integer.parseInt(request.getParameter("question_id"));

			Response response1 = new Response();
			response1.setUser(user);
			response1.setPostType(PostType.REPLY);
			response1.setPost(responseDesc);
			response1.setQuestion(new Question(questionId));
			if(response1.saveResponse()){
				response1.increaseResponseCount();
				nextPage = "question_desc.do";
			}else{
				nextPage = "response.jsp";
			}

		}
	
		request.getRequestDispatcher(nextPage).forward(request,response);
	}
}