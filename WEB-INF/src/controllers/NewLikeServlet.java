package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

import models.*;

public class NewLikeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String result = "fail";
		if(user!=null){
		//if(user.getUserType().getUserTypeId()==1){
		
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		Actions act= new Actions();
		act.setUser(user);
		act.setActionType(ActionType.LIKE);
		act.setPost(new Post(post_id));
		
		int user_id = user.getUserId();
		ArrayList<Actions> liked_by = Actions.collectLike(user_id,post_id);
		//request.setAttribute("liked_by",liked_by);
		if(liked_by.size()==0){
			request.setAttribute("liked",0);
			if(act.saveLike()){
				Post.updatePost(post_id);
				result = "";
				request.setAttribute("liked",1);
			}
		}else{
			request.setAttribute("liked",1);
			if(act.deleteLike()){
				Post.updatePostLike(post_id);
				result="delete";
				request.setAttribute("liked",0);
			}
		}
		}else{
			result = "Session Expired";
		}
		response.getWriter().write(result);
	}
}