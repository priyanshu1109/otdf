package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

import models.*;

public class NewSpamServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String result = "fail";
		if(user!=null){
		//if(user.getUserType().getUserTypeId()==1){
		
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		Actions act= new Actions();
		act.setUser(user);
		act.setActionType(ActionType.SPAM);
		act.setPost(new Post(post_id));
		
		int user_id = user.getUserId();
		ArrayList<Actions> spam_by = Actions.collectSpam(user_id,post_id);
		//request.setAttribute("liked_by",liked_by);
		if(spam_by.size()==0){
			request.setAttribute("spam",0);
			if(act.saveLike()){
				Post.updatePost2(post_id);
				result = "";
				request.setAttribute("spam",1);
			}
		}else{
			request.setAttribute("spam",1);
			if(act.deleteLike()){
				Post.updatePostSpam(post_id);
				result="delete";
				request.setAttribute("spam",0);
			}
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