package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.regex.*;

import models.*;

public class AddTopicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String result = "fail";
		if(user!=null){
		//if(user.getUserType().getUserTypeId()==1){
		
		String topicName = request.getParameter("topic");
		Topic topic= new Topic();
		topic.setTopic(topicName);
		if(topic.saveTopic()){
			result = "success";
		}
		//}else{
			//result = "Unauthorized Access";
		//}
		}else{
			result = "Session Expired";
		}
		response.getWriter().write(result);
	}
}