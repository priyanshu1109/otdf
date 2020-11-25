package controllers;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import java.util.*;

import models.*;
import com.google.gson.Gson;

public class CollectLikeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		int post_id = Integer.parseInt(request.getParameter("post_id"));
		String like = null;
		User user = (User)session.getAttribute("user");
		Actions action = new Actions();
		action.setActionType(ActionType.LIKE);
		action.setUser(user);
		action.setPost(new Post(post_id));
		
		ArrayList<Post> post = Post.collectLike(post_id);
	
		//request.setAttribute("liked_by",liked_by)
		
		like = new Gson().toJson(post);
		response.getWriter().write(like);
	}
}